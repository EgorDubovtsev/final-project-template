package com.epam.rd.izh.mappers;


import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.dto.CreatedBookDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<BookDto>, IBookMapper {

    @Override
    public BookDto mapRow(ResultSet resultSet, int i) throws SQLException {
        BookDto book = new BookDto();
        book.setName(resultSet.getString("book_name"));
        book.setPublishYear(resultSet.getInt("publishYear"));
        book.setDescription(resultSet.getString("description"));
        book.setAuthor(resultSet.getString("author"));
        book.setGenre(resultSet.getString("genre"));
        book.setPrice(resultSet.getInt("price"));
        return book;
    }

    @Override
    public BookDto mapFromCreatedBook(CreatedBookDTO createdBookDTO) {
        BookDto bookDTO = new BookDto();
        bookDTO.setAuthor(createdBookDTO.getAuthor());
        bookDTO.setDescription(createdBookDTO.getDescription());
        bookDTO.setName(createdBookDTO.getName());
        bookDTO.setPrice(createdBookDTO.getPrice());
        bookDTO.setPublishYear(createdBookDTO.getPublishYear());
        bookDTO.setGenre(createdBookDTO.getGenre());
        return bookDTO;
    }
}
