package com.epam.rd.izh.mappers;

import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.dto.CreatedBookDTO;

public interface IBookMapper {
    Book mapFromCreatedBook(CreatedBookDTO createdBookDTO);
}
