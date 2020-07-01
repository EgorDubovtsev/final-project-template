package com.epam.rd.izh.dto;

public interface BookInCart {
    String getUserLogin();
    String getBookName();
    void setBookName(String name);
    void setUserLogin(String login);
}
