package com.epam.rd.izh.controller;

import static com.epam.rd.izh.util.StringConstants.ENG_GREETING;

import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.dao.CartDaoImpl;
import com.epam.rd.izh.dto.Message;
import com.epam.rd.izh.repository.BooksRepository;
import com.epam.rd.izh.repository.UserRepository;
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
import java.util.Arrays;

@Controller
public class IndexController {
    @Autowired
    private BooksRepository books;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPriority userPriority;
    @Autowired
    private CartDao cartDao;

    @GetMapping("/")
    public String login(Authentication authentication, Model model,
                        @RequestParam(required = false) String open,
                        @RequestParam(required =false) String toCart,
                        HttpServletResponse response,
                        HttpServletRequest request) {
        Message greetingMessage = new Message();
//        greetingMessage.setMessage(ENG_GREETING + authentication.getName());
        model.addAttribute("name", authentication.getName());
        model.addAttribute("booksList", books.getBooksList());
        response.addCookie(new Cookie("login",authentication.getName()));
        if (userPriority.checkPriority().equals("MANAGER")) {
            model.addAttribute("admin", "MANAGER");
        }
        System.out.println(Arrays.toString(request.getCookies()));
        if (toCart!=null){
            System.out.println("TO CART: "+toCart);
            System.out.println("LOGIN "+authentication.getName());
            cartDao.addToCart(authentication.getName(),toCart);
            System.out.println(cartDao.getList());
        }
        if (open != null) {
            model.addAttribute("open", open);
            model.addAttribute("openedBook",books.findByName(open));
        }
        return "index";
    }

}
