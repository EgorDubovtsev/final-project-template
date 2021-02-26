package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.dto.BookInCartImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<BookInCart> {
    @Override
    public BookInCart mapRow(ResultSet resultSet, int i) throws SQLException {
        BookInCart bookInCart = new BookInCartImpl();
        bookInCart.setUserLogin(resultSet.getString("user_login"));
        bookInCart.setBookName(resultSet.getString("book_name"));
        return bookInCart;
    }
}
