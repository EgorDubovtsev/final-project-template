package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBooksList();

    void addBook(BookDto book);

    BookDto findByName(String name);

}
