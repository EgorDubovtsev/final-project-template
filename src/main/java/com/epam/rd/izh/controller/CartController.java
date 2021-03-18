package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.AuthorizedUserRepository;
import com.epam.rd.izh.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Controller
public class CartController {
    @Autowired
    private AuthorizedUserRepository authorizedUserRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping(value = "/api/addToCart", method = RequestMethod.GET)
    public @ResponseBody
    boolean addToCart(@RequestParam String name, @RequestParam String login) {
        AuthorizedUser buyer = authorizedUserRepository.findByLogin(login);
        Book book = bookRepository.findByName(name);
        buyer.addBook(book);
        book.addBuyer(buyer);
        bookRepository.save(book);
        authorizedUserRepository.save(buyer);

        return true;
    }

    @RequestMapping(value = "/api/getCountOfBooks", method = RequestMethod.GET)
    public @ResponseBody
    int getCount(@RequestParam String login) {
        return authorizedUserRepository.findByLogin(login).getBooks().size();
    }

    @RequestMapping(value = "/api/deleteBook", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteBook(@RequestParam String bookName, @RequestParam String userLogin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, bookName);
        AuthorizedUser authorizedUser = entityManager.find(AuthorizedUser.class, userLogin);

        entityManager.getTransaction().begin();
        authorizedUser.getBooks().remove(book);
        entityManager.getTransaction().commit();

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