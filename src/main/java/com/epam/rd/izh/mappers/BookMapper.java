package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<BookDTO>,IBookMapper {

    @Override
    public BookDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        BookDTO book = new BookDTO();
        book.setName(resultSet.getString("book_name"));
        book.setPublishYear(resultSet.getInt("publishYear"));
        book.setDescription(resultSet.getString("description"));
        book.setAuthor(resultSet.getString("author"));
        book.setPrice(resultSet.getDouble("price"));
        System.out.println("MAPPED BOOK "+book.toString());
        return book;
    }

}
