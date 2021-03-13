package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.repository.BookInCartRepository;
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
    private BookInCartRepository bookInCartRepository;

    @GetMapping("/")
    public String login(Authentication authentication, Model model,
                        @RequestParam(required = false) String open,
                        @RequestParam(required = false) String toCart,
                        HttpServletResponse response) {
        model.addAttribute("name", authentication.getName());
        model.addAttribute("booksList", bookService.getBooksList());
        response.addCookie(new Cookie("login", authentication.getName()));
        BookDto bookDto = new BookDto();
        bookDto.setAuthor("sdfs");
        bookDto.setName("anme name");
        bookDto.setGenre("Роман");
        bookDto.setDescription("оман");
        bookDto.setPrice(100);
        bookDto.setPublishYear(2002);
        bookService.addBook(bookDto);
        if (userPriorityService.checkPriority().equals("MANAGER")) {
            model.addAttribute("admin", "MANAGER");
        }
        if (toCart != null) {
            bookInCartRepository.save(new BookInCart(authentication.getName(), toCart));
        }
        if (open != null) {
            model.addAttribute("open", open);
            model.addAttribute("openedBook", bookService.findByName(open));
        }
        return "index";
    }

}
