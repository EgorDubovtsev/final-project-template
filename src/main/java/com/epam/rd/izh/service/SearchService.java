package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.dto.SearchParametersDTO;

import java.util.List;

public interface SearchService {
    List<Book> findBookBySearchParameters(SearchParametersDTO searchParameters);
}
