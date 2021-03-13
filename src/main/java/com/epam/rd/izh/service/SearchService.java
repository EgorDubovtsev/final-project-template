package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.dto.SearchParametersDTO;

import java.util.List;

public interface SearchService {
    List<BookDto> findBookBySearchParameters(SearchParametersDTO searchParameters);
}
