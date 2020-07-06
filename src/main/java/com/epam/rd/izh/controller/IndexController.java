package com.epam.rd.izh.controller;

import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.dto.Message;
import com.epam.rd.izh.service.BookService;
import com.epam.rd.izh.service.UserPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserPriority userPriority;
    @Autowired
    private CartDao cartDao;

    @GetMapping("/")
    public String login(Authentication authentication, Model model,
                        @RequestParam(required = false) String open,
                        @RequestParam(required = false) String toCart,
                        HttpServletResponse response) {
        Message greetingMessage = new Message();
//        greetingMessage.setMessage(ENG_GREETING + authentication.getName());
        model.addAttribute("name", authentication.getName());
        model.addAttribute("booksList", bookService.getBooksList());
        response.addCookie(new Cookie("login", authentication.getName()));
        if (userPriority.checkPriority().equals("MANAGER")) {
            model.addAttribute("admin", "MANAGER");
        }
        if (toCart != null) {
            cartDao.addToCart(authentication.getName(), toCart);
        }
        if (open != null) {
            model.addAttribute("open", open);
            model.addAttribute("openedBook", bookService.findByName(open));
        }
        return "index";
    }

}
