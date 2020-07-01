package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;
import org.springframework.beans.factory.annotation.Autowired;

public class ConverterService implements Converter {
    @Autowired
    BooksDao booksDao;
    @Override
    public BookDTO convertToBookDto(BookInCart bookInCart) {
        return booksDao.getBookByName(bookInCart.getBookName());
    }
}
