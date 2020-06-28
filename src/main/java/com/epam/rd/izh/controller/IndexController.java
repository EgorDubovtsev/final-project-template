package com.epam.rd.izh.controller;

import static com.epam.rd.izh.util.StringConstants.ENG_GREETING;

import com.epam.rd.izh.dto.Message;
import com.epam.rd.izh.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private BooksRepository books;
    public String[] array = new String[]{"Test", "test"};

    @GetMapping("/")
    public String login(Authentication authentication, Model model, boolean addToCart) {
        Message greetingMessage = new Message();
        greetingMessage.setMessage(ENG_GREETING + authentication.getName());

        model.addAttribute("message", greetingMessage.getMessage());
        System.out.println(books.getBookList());
        model.addAttribute("booksList", books.getBookList());
        System.out.println(addToCart);
        if (authentication.getName().equals("admin")) {/** change to role check*/
            model.addAttribute("admin", "ADMIN");
        }
        return "index";
    }

}
