package com.epam.rd.izh.controller;

import com.epam.rd.izh.dao.CartDao;
import com.epam.rd.izh.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
//TODO: create media for button to cart and to home