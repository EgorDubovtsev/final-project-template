package com.epam.rd.izh.repository;

import com.epam.rd.izh.dto.BookDTO;

import java.util.List;

public interface IBooksRepository {
    List<BookDTO> getBooksList();
}

