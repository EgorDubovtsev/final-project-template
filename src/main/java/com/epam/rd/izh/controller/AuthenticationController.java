package com.epam.rd.izh.controller;

import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.dto.CreatedBookImpl;
import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import com.epam.rd.izh.mappers.BookMapper;
import com.epam.rd.izh.repository.UserRepository;

import javax.validation.Valid;

import com.epam.rd.izh.service.Converter;
import com.epam.rd.izh.service.FieldChecker;
import com.epam.rd.izh.service.UserPriority;
import com.epam.rd.izh.service.UserPriorityService;
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
    UserRepository userRepository;
    @Autowired
    AuthorizedUserMapper authorizedUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserPriority userPriority;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CartDao cartDao;
    @Autowired
    Converter converter;
    @Autowired
    FieldChecker fieldChecker;
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
        if (error!=null){
            if (error.equals("userRegistered")){
                model.addAttribute("errorMessage","Логин занят другим пользователем");
            }else if(error.equals("emptyFields")){
                System.out.println("EMPTY");
                model.addAttribute("errorMessage","Заполните все необходимые поля");
            }else{
                model.addAttribute("errorMessage","Неизвестная ошибка");
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
    public String viewCart(Model model, String login) {
        model.addAttribute("name",login);
        List<BookDTO> booksInTheCart =  cartDao.getCartByLogin(login).stream().map(bookInCart ->converter.convertToBookDto(bookInCart)).collect(Collectors.toList());
        model.addAttribute("booksInTheCart",booksInTheCart);
        System.out.println(booksInTheCart);
        return "cart";

    }//TODO: MAKE HEADER COMPONENT

    @GetMapping("/createBook")
    public String viewCreateBook(Model model) {
        if (!model.containsAttribute("createBookForm")) {
            model.addAttribute("createBookForm", new CreatedBookImpl());
        }
        String role = userPriority.checkPriority();
        return role.equals("MANAGER") ? "createBook" : "/";

    }

//    @GetMapping("/error")
//    public String viewError(Model model) {
//        return "error";
//    }


    /**
     * Метод, отвечающий за подтверждение регистрации пользователя и сохранение данных в репозиторий или DAO.
     */
    @PostMapping("/registration/proceed")
    public String processRegistration(@Valid @ModelAttribute("registrationForm") RegistredUserDTO registeredUser,
                                      BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        /**
         * Здесь по желанию можно добавить валидацию введенных данных на back-end слое.
         * Для этого необходимо написать реализацию Validator.
         */
        //registeredUser.validate(registeredUserDto, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println("EEEEEEEEEERROOOOORRRR");
            return "redirect:/registration";
        }
        /**
         * Здесь происходит присвоение роли пользователю и шифрование пароля.
         * Роль может быть так же определена пользователем на этапе регистрации, либо иным способов, зависящим
         * от темы финального проекта.
         * registeredUser может быть DTO объектом, преобразуемым в AuthorizedUser сущность в сервисе-маппере
         * (эот сервис нужно написать самим), вместе с присвоением роли и шифрованием пароля.
         */
        if (userRepository.getAuthorizedUserByLogin(registeredUser.getName()) != null ) {
            return "redirect:/registration?error=userRegistered";
        }else if( fieldChecker.isNull(registeredUser)){
            return "redirect:/registration?error=emptyFields";
        }
        AuthorizedUser authorizedUser = authorizedUserMapper.mapFromDto(registeredUser);
        authorizedUser.setPassword(passwordEncoder.encode(registeredUser.getPassword()));

        /**
         * Добавление пользователя в репозиторий или в базу данных через CRUD операции DAO.
         * Рекомендуется вынести эту логику на сервисный слой.
         */
        userRepository.addAuthorizedUser(authorizedUser);
        /**
         * В случае успешной регистрации редирект можно настроить на другой энд пойнт.
         */
        return "redirect:/login";
    }

}