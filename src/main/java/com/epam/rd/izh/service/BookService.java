package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooksList();

    void addBook(Book book);

    Book findByName(String name);

    BookDto convertToDto(Book book);
}
