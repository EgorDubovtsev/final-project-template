package com.epam.rd.izh.dao;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.mappers.CartMapper;
import com.epam.rd.izh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartDaoImpl implements CartDao {
    @Autowired
    private BookService bookService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CartMapper cartMapper;

    @Override
    public boolean addToCart(String bookName, String login) {
//        BookDTO bookDTO = bookService.findByName(bookName);
        String sql = "INSERT INTO cart (user_login,book_name) values (?, ?)";
        jdbcTemplate.update(sql, login, bookName);
        return true;
    }

    @Override
    public void deleteFromTheCart(String bookName, String login) {
        String sql = "DELETE FROM cart WHERE id IN (SELECT id " +
                "FROM cart WHERE user_login = ? and book_name =? LIMIT 1)";
        jdbcTemplate.update(sql, login, bookName);
    }

    @Override
    public List<BookInCart> getList() {
        String sqlGetAllCart = "SELECT * FROM cart;";
        return jdbcTemplate.query(sqlGetAllCart, cartMapper);
    }

    @Override
    public List<BookInCart> getCartByLogin(String login) {
        String sqlGetCartByLogin = "SELECT * FROM cart WHERE user_login = ?";
        try {
            return jdbcTemplate.query(sqlGetCartByLogin, cartMapper, login);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}
