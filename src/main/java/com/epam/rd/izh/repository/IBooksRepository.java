package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Book;

import java.util.List;

public interface IBooksRepository {
    List<Book> getBooksList();
}
