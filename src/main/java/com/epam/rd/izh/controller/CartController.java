package com.epam.rd.izh.controller;

import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.repository.BookInCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private BookInCartRepository bookInCartRepository;

    @RequestMapping(value = "/api/addToCart", method = RequestMethod.GET)
    public @ResponseBody
    boolean addToCart(@RequestParam String name, @RequestParam String login) {
        bookInCartRepository.save(new BookInCart(login, name));
        return true;
    }

    @RequestMapping(value = "/api/getCountOfBooks", method = RequestMethod.GET)
    public @ResponseBody
    int getCount(@RequestParam String login) {
        return bookInCartRepository.findByUserLogin(login).size();
    }

    @RequestMapping(value = "/api/deleteBook", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteBook(@RequestParam String bookName, @RequestParam String userLogin) {
        BookInCart bookInCart = new BookInCart();
        bookInCart.setUserLogin(userLogin);
        bookInCart.setBookName(bookName);
        bookInCartRepository.delete(bookInCart);
        return true;
    }

    @RequestMapping(value = "/api/buy", method = RequestMethod.GET)
    public @ResponseBody
    boolean buyAllBooksInCart(@RequestParam String userLogin) {
        List<BookInCart> booksInCart = bookInCartRepository.findByUserLogin(userLogin);
        for (BookInCart book : booksInCart) {
            book.setUserLogin(userLogin);
            bookInCartRepository.delete(book);
        }
        return !booksInCart.isEmpty();
    }
}