package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.List;
@Component
public class BookServiceImpl implements BookService {
    @Autowired
    BooksDao booksDao;

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
        return getBooksList().stream().filter(bookName -> bookName.getName()
                .trim().equals(name.trim()))
                .findFirst().orElse(null);
    }
}
