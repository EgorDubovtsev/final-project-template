package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
    public Book mapRow(ResultSet resultSet) throws SQLException {
    Book book = new Book();
    book.setId(resultSet.getLong("id"));
    book.setName(resultSet.getString("name"));
    book.setPublishYear(resultSet.getInt("publishYear"));
    book.setDescription(resultSet.getString("description"));
    book.setAuthor(resultSet.getString("author"));
    book.setPrice(resultSet.getDouble("price"));

    return book;
    }
}
