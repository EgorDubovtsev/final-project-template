package com.epam.rd.izh.dao;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.SearchParametersDTO;

import java.util.List;

public interface BooksDao {
    List<BookDTO> getList();

    int addBook(BookDTO bookDTO);

    BookDTO getBookByName(String name);

    List<BookDTO> getBooksByParameters(SearchParametersDTO searchParameters);
}
