package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksRepository implements IBooksRepository {
    private  List<Book> bookList = new ArrayList<>();

    public List<Book> getBooksList(){
        bookList.add(new Book(1212312,"TEST","Bob ralph",1999,1200.0,"dsdf"));
        return bookList;
    }
    public void addBook(Book book){
        bookList.add(book);
    }
}
