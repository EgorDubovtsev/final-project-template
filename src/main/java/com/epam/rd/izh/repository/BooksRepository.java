package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksRepository {
    private  List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList(){
        bookList.add(new Book("TEST","AUTHOR","22/22/22",1200));
        return bookList;
    }
    public void addBook(Book book){

        bookList.add(book);
    }
}
