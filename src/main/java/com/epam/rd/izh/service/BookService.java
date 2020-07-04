package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.List;

public interface BookService {
    List<BookDTO> getBooksList();

    void addBook(BookDTO book);

    BookDTO findByName(String name);

}
