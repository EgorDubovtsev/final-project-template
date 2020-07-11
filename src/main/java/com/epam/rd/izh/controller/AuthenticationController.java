package com.epam.rd.izh.controller;

import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.CreatedBookImpl;
import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import com.epam.rd.izh.service.Converter;
import com.epam.rd.izh.service.FieldChecker;
import com.epam.rd.izh.service.UserPriorityService;
import com.epam.rd.izh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * В аргументы контроллеров, которые обрабатывают запросы, можно указать дополнительные входные параметры: Например:
 * HttpServletRequest и HttpServletResponse. Данные объекты автоматически заполняться данными о реквесте и респонсе. Эти
 * данные можно использовать, например достать куки, сессию, хедеры итд.
 */

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorizedUserMapper authorizedUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserPriorityService userPriorityService;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private Converter converter;
    @Autowired
    private FieldChecker fieldChecker;

    /**
     * Метод, отвечающий за логику авторизации пользователя.
     * /login - определяет URL, по которому пользователь должен перейти, чтобы запустить данный метод-обработчик.
     */
    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            /**
             * Model представляет из себя Map коллекцию ключ-значения, распознаваемую View элементами MVC.
             * Добавляется String "invalid login or password!", с ключем "error_login_placeholder".
             * При создании View шаблона плейсхолдер ${error_login_placeholder} будет заменен на переданное значение.
             *
             * В класс Model можно передавать любые объекты, необходимые для генерации View.
             */
            model.addAttribute("errorMessage", "invalid login or password!");
        }
        /**
         * Контроллер возвращает String название JSP страницы.
         * В application.properties есть следующие строки:
         * spring.mvc.view.prefix=/WEB-INF/pages/
         * spring.mvc.view.suffix=.jsp
         * Spring MVC, используя суффикс и префикс, создаст итоговый путь к JSP: /WEB-INF/pages/login.jsp
         */
        return "login";
    }

    /**
     * Метод, отвечающий за логику регистрации пользователя.
     */
    @GetMapping("/registration")
    public String viewRegistration(Model model, @RequestParam(required = false) String error) {
        if (!model.containsAttribute("registrationForm")) {
            model.addAttribute("registrationForm", new AuthorizedUser());
        }
        if (error != null) {
            switch (error) {
                case "userRegistered":
                    model.addAttribute("errorMessage", "Логин занят другим пользователем");
                    break;
                case "emptyFields":
                    model.addAttribute("errorMessage", "Заполните все необходимые поля");
                    break;
                case "loginTooShort":
                    model.addAttribute("errorMessage", "Логин должен содержать минимум 6 символов");
                    break;
                case "passwordTooShort":
                    model.addAttribute("errorMessage", "Пароль должен содержать минимум 6 символов");
                    break;
                default:
                    model.addAttribute("errorMessage", "Неизвестная ошибка");
                    break;
            }
        }

        return "registration";
    }

    @GetMapping("/logout")
    public String viewLogout(Model model) {
        model.addAttribute("registrationForm", null);
        return "login";
    }

    @GetMapping("/cart")
    public String viewCart(Model model, HttpServletRequest request) {
        String login = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName()
                .equals("login")).findFirst()
                .orElse(new Cookie("status", "forbidden")).getValue();
        model.addAttribute("name", login);
        List<BookDTO> booksInTheCart = cartDao.getCartByLogin(login).stream().map(bookInCart -> converter.convertToBookDto(bookInCart)).collect(Collectors.toList());
        model.addAttribute("booksInTheCart", booksInTheCart);
        return "cart";

    }

    @GetMapping("/createBook")
    public String viewCreateBook(Model model,
                                 HttpServletRequest request,
                                 @RequestParam(required = false) String error) {
        if (!model.containsAttribute("createBookForm")) {
            model.addAttribute("createBookForm", new CreatedBookImpl());
        }
        if (error != null) {
            if (error.equals("emptyFields")) {
                model.addAttribute("errorMessage", "Заполите все необходимые поля");
            } else if (error.equals("bookExist")) {
                model.addAttribute("errorMessage", "Книга с таким названием уже существует");
            }
        }
        String login = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName()
                .equals("login")).findFirst()
                .orElse(new Cookie("status", "forbidden")).getValue();
        model.addAttribute("name", login);

        String role = userPriorityService.checkPriority();
        return role.equals("MANAGER") ? "createBook" : "redirect:/";

    }

    @GetMapping("/error")
    public String viewError(Model model) {
        return "error";
    }


    /**
     * Метод, отвечающий за подтверждение регистрации пользователя и сохранение данных в репозиторий или DAO.
     */
    @PostMapping("/registration/proceed")
    public String processRegistration(@Valid @ModelAttribute("registrationForm") RegistredUserDTO registeredUser,
                                      BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/registration";
        }
        if (userService.getAuthorizedUserByLogin(registeredUser.getLogin()) != null) {
            return "redirect:/registration?error=userRegistered";
        } else if (fieldChecker.isNull(registeredUser)) {
            return "redirect:/registration?error=emptyFields";
        } else if (registeredUser.getLogin().trim().length() < 6) {
            return "redirect:/registration?error=loginTooShort";
        } else if (registeredUser.getPassword().trim().length() < 6) {
            return "redirect:/registration?error=passwordTooShort";
        }
        AuthorizedUser authorizedUser = authorizedUserMapper.mapFromDto(registeredUser);
        authorizedUser.setPassword(passwordEncoder.encode(registeredUser.getPassword()));

        /**
         * Добавление пользователя в репозиторий или в базу данных через CRUD операции DAO.
         * Рекомендуется вынести эту логику на сервисный слой.
         */
        userService.addAuthorizedUser(authorizedUser);
        return "redirect:/login";
    }

}