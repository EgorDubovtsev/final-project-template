package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.dto.CreatedBookImpl;
import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import com.epam.rd.izh.repository.AuthorizedUserRepository;
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
    private AuthorizedUserRepository authorizedUserRepository;
    @Autowired
    private FieldChecker fieldChecker;


    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            model.addAttribute("errorMessage", "invalid login or password!");
        }

        return "login";
    }

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
        try {
            List<Book> booksInTheCart = authorizedUserRepository.findByLogin(login).getBooks();
            model.addAttribute("booksInTheCart", booksInTheCart);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

        userService.addAuthorizedUser(authorizedUser);
        return "redirect:/login";
    }

}