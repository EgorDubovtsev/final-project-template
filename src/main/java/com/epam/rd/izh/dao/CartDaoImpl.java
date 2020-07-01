package com.epam.rd.izh.dao;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.dto.BookInCartImpl;
import com.epam.rd.izh.mappers.BookMapper;
import com.epam.rd.izh.mappers.CartMapper;
import com.epam.rd.izh.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CartDaoImpl implements CartDao {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CartMapper cartMapper;
    @Override
    public boolean addToCart(String bookName, String login) {
        BookDTO bookDTO = booksRepository.findByName(bookName);
        String sql = "INSERT INTO usercart (user_login,book_name) values ('"
                + bookName + "','"
                + login + "')";
        jdbcTemplate.update(sql);
        return true;
    }
    @Override
    public List<BookInCart> getList() {//TODO: make method with insert login in sql
        String sqlGetAllCart = "SELECT * FROM usercart;";
        return jdbcTemplate.query(sqlGetAllCart,cartMapper);
    }
    @Override
    public List<BookInCart> getCartByLogin(String login){
        String sqlGetCartByLogin = "SELECT * FROM usercart WHERE user_login='"+login+"'";
        return jdbcTemplate.query(sqlGetCartByLogin,cartMapper);
    }
}
