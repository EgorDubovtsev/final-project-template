package com.epam.rd.izh.repository;

import com.epam.rd.izh.dto.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksRepository {
    private  List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList(){
        bookList.add(new Book(1212312,"TEST","Bob ralph",1999,1200.0,"dsdf"));
        return bookList;
    }
    public void addBook(Book book){
        bookList.add(book);
    }
}
