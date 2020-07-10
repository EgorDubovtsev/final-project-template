package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dto.BookDTO;
import com.epam.rd.izh.dto.SearchParametersDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SimpleSearchService implements SearchService {
    @Autowired
    BooksDao booksDao;

    @Override
    public List<BookDTO> findBookBySearchParameters(SearchParametersDTO searchParameters) {
        return booksDao.getBooksByParameters(searchParameters);
    }
}
