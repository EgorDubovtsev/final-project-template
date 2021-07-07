package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooksList();

    void addBook(BookDTO book);

    BookDTO findByName(String name);

}
