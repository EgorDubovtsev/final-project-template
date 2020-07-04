package com.epam.rd.izh.dao;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;

import java.util.List;

public interface CartDao {
    boolean addToCart(String bookName,String login);
    List<BookInCart> getList();
    List<BookInCart> getCartByLogin(String login);
    void deleteFromTheCart(String bookName, String login);
}
