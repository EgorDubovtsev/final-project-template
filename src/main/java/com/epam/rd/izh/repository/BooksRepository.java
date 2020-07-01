package com.epam.rd.izh.repository;

import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.List;

@Component
public class BooksRepository implements IBooksRepository {
    @Autowired
    BooksDao booksDao;

    public List<BookDTO> getBooksList() {
        return booksDao.getList();
    }

    public boolean addBook(@Nullable BookDTO book) {
        if (book != null) {
            booksDao.addBook(book);
            return true;
        }
        return false;
    }

    public BookDTO findByName(String name) {
        return getBooksList().stream().filter(bookName -> bookName.getName().equals(name))
                .findFirst().orElse(null);
    }
}
