package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.AuthorizedUserRepository;
import com.epam.rd.izh.repository.BookDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private AuthorizedUserRepository authorizedUserRepository;
    @Autowired
    private BookDtoRepository bookDtoRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping(value = "/api/addToCart", method = RequestMethod.GET)
    public @ResponseBody
    boolean addToCart(@RequestParam String name, @RequestParam String login) {
        AuthorizedUser buyer = authorizedUserRepository.findByLogin(login);
        BookDto bookDto = bookDtoRepository.findByName(name);
        buyer.addBook(bookDto);
        bookDto.addBuyer(buyer);//todo: check work when this is removed
        bookDtoRepository.save(bookDto);
        authorizedUserRepository.save(buyer);
        return true;
    }

    @RequestMapping(value = "/api/getCountOfBooks", method = RequestMethod.GET)
    public @ResponseBody
    int getCount(@RequestParam String login) {
        System.out.println(authorizedUserRepository.findByLogin(login).getBooks());
        return authorizedUserRepository.findByLogin(login).getBooks().size();
    }

    @RequestMapping(value = "/api/deleteBook", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteBook(@RequestParam String bookName, @RequestParam String userLogin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BookDto bookDto = entityManager.find(BookDto.class, bookName);
        AuthorizedUser authorizedUser = entityManager.find(AuthorizedUser.class, userLogin);

        authorizedUser.getBooks().remove(bookDto);
        authorizedUserRepository.save(authorizedUser);
        return true;
    }

    @RequestMapping(value = "/api/buy", method = RequestMethod.GET)
    public @ResponseBody
    boolean buyAllBooksInCart(@RequestParam String userLogin) {
        AuthorizedUser authorizedUser = authorizedUserRepository.findByLogin(userLogin);
        if (authorizedUser.getBooks().isEmpty()) {
            return false;
        }
        authorizedUser.getBooks().clear();
        authorizedUserRepository.save(authorizedUser);

        return true;
    }
}