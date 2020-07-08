package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.SearchParametersDTO;

import java.util.List;

public interface SearchService {
    List<BookDTO> findBookBySearchParameters(SearchParametersDTO searchParameters);
}
