package com.epam.rd.izh.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "books_in_cart_jpa")
@Entity
public class BookInCart {
    @Id
    private String bookName;
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public String getBookName() {
        return bookName;
    }

    public BookInCart() {
    }

    public BookInCart(String userLogin, String bookName) {
        this.userLogin = userLogin;
        this.bookName = bookName;
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    public void setUserLogin(String login) {
        this.userLogin = login;
    }
}
