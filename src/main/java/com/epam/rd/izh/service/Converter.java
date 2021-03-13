package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.dto.BookInCart;

public interface Converter {
    BookDto convertToBookDto(BookInCart bookInCart);
}
