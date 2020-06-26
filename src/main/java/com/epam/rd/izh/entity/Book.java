package com.epam.rd.izh.entity;

public class Book {
    private String name;
    private String author;
    private String dateOfPublish;
    private int price;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDateOfPublish() {
        return dateOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public Book(String name, String author, String dateOfPublish, int price) {
        this.name = name;
        this.author = author;
        this.dateOfPublish = dateOfPublish;
        this.price = price;
    }

    public Book() {
    }
}
