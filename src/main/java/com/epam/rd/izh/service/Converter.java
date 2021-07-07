package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.BookInCart;

public interface Converter {
    BookDTO convertToBookDto(BookInCart bookInCart);
}
