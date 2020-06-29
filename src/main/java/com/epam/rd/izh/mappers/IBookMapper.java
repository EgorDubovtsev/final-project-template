package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IBookMapper {
    Book mapFromDto(BookDTO bookDTO) throws SQLException;
}
