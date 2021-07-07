package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.CreatedBookDTO;

public interface IBookMapper {
    BookDTO mapFromCreatedBook(CreatedBookDTO createdBookDTO);
}
