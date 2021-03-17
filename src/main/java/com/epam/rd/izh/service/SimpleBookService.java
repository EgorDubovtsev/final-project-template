package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.entity.Author;
import com.epam.rd.izh.repository.AuthorRepository;
import com.epam.rd.izh.repository.BookDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleBookService implements BookService {
    @Autowired
    private BookDtoRepository bookDtoRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Book> getBooksList() {
        Author author1 = new Author();
        author1.setName("First Author");
        Book book = new Book();
        book.setName("Book 1");
        book.setPublishYear(123);
        book.setPrice(123);
        book.setGenre("Роман");
        book.setDescription("desc");
        book.setAuthor(author1);
        author1.addBook(book);
        authorRepository.save(author1);
        bookDtoRepository.save(book);
        return (List<Book>) bookDtoRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookDtoRepository.save(book);
    }

    @Override
    public Book findByName(String name) {
        return bookDtoRepository.findByName(name);
    }

    @Override
    public BookDto convertToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setName(book.getName());
        bookDto.setDescription(book.getDescription());
        bookDto.setGenre(book.getGenre());
        bookDto.setPrice(book.getPrice());
        bookDto.setPublishYear(book.getPublishYear());
        bookDto.setAuthor(book.getAuthor().getName());
        return bookDto;
    }


}
