package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.dto.CreatedBookDTO;

public interface IBookMapper {
    BookDto mapFromCreatedBook(CreatedBookDTO createdBookDTO);
}
