package com.epam.rd.izh.dto;

public class Book {
    private long id;
    private String name;
    private String author;
    private int publishYear;
    private double price;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book(long id, String name,
                String author, int publishYear,
                double price, String description) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
        this.description = description;
    }

    public Book() {
    }
}
