package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<BookDTO>,IBookMapper {

    @Override
    public BookDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        BookDTO book = new BookDTO();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("name"));
        book.setPublishYear(resultSet.getInt("publishYear"));
        book.setDescription(resultSet.getString("description"));
        book.setAuthor(resultSet.getString("author"));
        book.setPrice(resultSet.getDouble("price"));

        return book;
    }

    @Override
    public Book mapFromDto(BookDTO bookDTO) throws SQLException {
        //TODO:
        return null;
    }
}
