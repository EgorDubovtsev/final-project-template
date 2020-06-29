package com.epam.rd.izh.controller;

import static com.epam.rd.izh.util.StringConstants.ENG_GREETING;

import com.epam.rd.izh.dto.Message;
import com.epam.rd.izh.repository.BooksRepository;
import com.epam.rd.izh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private BooksRepository books;
    @Autowired
    private UserRepository userRepository;
    public String[] array = new String[]{"Test", "test"};

    @GetMapping("/")
    public String login(Authentication authentication, Model model) {
        Message greetingMessage = new Message();
        greetingMessage.setMessage(ENG_GREETING + authentication.getName());

        System.out.println(authentication.getName()+" HEY");
        model.addAttribute("name", greetingMessage.getMessage());
        model.addAttribute("booksList", books.getBooksList());
        if (userRepository.isManager(authentication.getName())) {
            model.addAttribute("admin", "MANAGER");
        }
        return "index";
    }

}
