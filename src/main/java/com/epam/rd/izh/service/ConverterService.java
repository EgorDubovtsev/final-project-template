package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;
import org.springframework.beans.factory.annotation.Autowired;

public class ConverterService implements Converter {
    @Autowired
    private BookService bookService;

    @Override
    public BookDTO convertToBookDto(BookInCart bookInCart) {
        return bookService.findByName(bookInCart.getBookName());
    }
}
