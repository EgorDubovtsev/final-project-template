package com.epam.rd.izh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "authors_jpa")
@Entity
public class Author {
    @Id
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
