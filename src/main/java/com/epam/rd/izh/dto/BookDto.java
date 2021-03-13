package com.epam.rd.izh.dto;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "book_jpa")
@Entity
public class BookDto {
    @Id
    private String name;
    private String author;
    private int publishYear;
    private int price;
    private String description;
    private String genre;

    public BookDto(String name, String author, int publishYear, int price, String description, String genre) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
        this.description = description;
        this.genre = genre;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BookDto() {
    }
}
