package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dao.SimpleBooksDao;
import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.SearchParametersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SimpleBookService implements BookService {
    @Autowired
    private BooksDao booksDao;

    @Override
    public List<BookDTO> getBooksList() {
        return booksDao.getList();
    }

    @Override
    public void addBook(BookDTO book) {
        booksDao.addBook(book);
    }

    @Override
    public BookDTO findByName(String name) {
        return booksDao.getBookByName(name);
    }

}
