package com.epam.rd.izh.dto;

public class BookInCartImpl implements BookInCart {
    private String userLogin;
    private String bookName;

    @Override
    public String getUserLogin() {
        return userLogin;
    }

    @Override
    public String getBookName() {
        return bookName;
    }

    @Override
    public void setBookName(String name) {
        this.bookName = name;
    }

    @Override
    public void setUserLogin(String login) {
        this.userLogin = login;
    }
}
