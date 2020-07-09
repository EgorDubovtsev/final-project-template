package com.epam.rd.izh.controller;

import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.dto.BookInCart;
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
    private CartDao cartDao;

    @RequestMapping(value = "/api/addToCart", method = RequestMethod.GET)
    public @ResponseBody
    boolean addToCart(@RequestParam String name, @RequestParam String login) {
        return cartDao.addToCart(name, login);
    }

    @RequestMapping(value = "/api/getCountOfBooks", method = RequestMethod.GET)
    public @ResponseBody
    int getCount(@RequestParam String login) {
        return cartDao.getCartByLogin(login).size();
    }

    @RequestMapping(value = "/api/deleteBook", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteBook(@RequestParam String bookName, @RequestParam String userLogin) {
        cartDao.deleteFromTheCart(bookName, userLogin);
        return true;
    }

    @RequestMapping(value = "/api/buy", method = RequestMethod.GET)
    public @ResponseBody
    boolean buyAllBooksInCart(@RequestParam String userLogin) {
        List<BookInCart> booksInCart = cartDao.getCartByLogin(userLogin);
        for(BookInCart book:booksInCart){
            cartDao.deleteFromTheCart(book.getBookName(),userLogin);
        }
        return true;
    }
}