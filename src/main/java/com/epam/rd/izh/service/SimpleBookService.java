package com.epam.rd.izh.service;

import com.epam.rd.izh.repository.BookDtoRepository;
import com.epam.rd.izh.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleBookService implements BookService {
    @Autowired
    private BookDtoRepository bookDtoRepository;

    @Override
    public List<BookDto> getBooksList() {
        return (List<BookDto>) bookDtoRepository.findAll();
    }

    @Override
    public void addBook(BookDto book) {
        bookDtoRepository.save(book);
    }

    @Override
    public BookDto findByName(String name) {
        return bookDtoRepository.findByName(name);
    }

}
