package com.epam.rd.izh.controller;

import com.epam.rd.izh.repository.AuthorizedUserRepository;
import com.epam.rd.izh.repository.BookDtoRepository;
import com.epam.rd.izh.service.BookService;
import com.epam.rd.izh.service.UserPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserPriorityService userPriorityService;
    @Autowired
    private AuthorizedUserRepository authorizedUserRepository;
    @Autowired
    private BookDtoRepository bookDtoRepository;

    @GetMapping("/")
    public String login(Authentication authentication, Model model,
                        @RequestParam(required = false) String open,
                        @RequestParam(required = false) String toCart,
                        HttpServletResponse response) {
        model.addAttribute("name", authentication.getName());
        model.addAttribute("booksList", bookService.getBooksList());
        response.addCookie(new Cookie("login", authentication.getName()));

        if (userPriorityService.checkPriority().equals("MANAGER")) {
            model.addAttribute("admin", "MANAGER");
        }
//        if (toCart != null) {
//            BookDto bookDto1
//            authorizedUserRepository.findByLogin(authentication.getName()).addBook();
//        }
        if (open != null) {
            model.addAttribute("open", open);
            model.addAttribute("openedBook", bookService.findByName(open));
        }
        return "index";
    }

}
