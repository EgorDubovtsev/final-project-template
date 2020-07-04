package com.epam.rd.izh.dao;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.mappers.CartMapper;
import com.epam.rd.izh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CartDaoImpl implements CartDao {
    @Autowired
    BookService bookService;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CartMapper cartMapper;
    @Override
    public boolean addToCart(String bookName, String login) {
        BookDTO bookDTO = bookService.findByName(bookName);
        String sql = "INSERT INTO usercart (user_login,book_name) values ('"
                + login + "','"
                + bookName + "')";
        jdbcTemplate.update(sql);
        return true;
    }
    @Override
    public void deleteFromTheCart(String bookName, String login) {
        String sql = "DELETE FROM usercart WHERE id IN (SELECT id " +
                "FROM usercart WHERE user_login = '"+login+"' and book_name = '"+bookName+"'" + " LIMIT 1" + ")";
       jdbcTemplate.update(sql); //FIXME: AFTER PRESS DELETE BOOK WILL BE ADD
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
