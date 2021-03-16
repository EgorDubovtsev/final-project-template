package com.epam.rd.izh.dto;


import com.epam.rd.izh.entity.AuthorizedUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "books_jpa_new")
@Entity
public class BookDto {
    @Id
    private String name;
    private String author;
    private int publishYear;
    private int price;
    private String description;
    private String genre;
    @JsonIgnore
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AuthorizedUser> buyers = new ArrayList<>();

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

    public List<AuthorizedUser> getBuyers() {
        return buyers;
    }
    public void addBuyer(AuthorizedUser authorizedUser){
        buyers.add(authorizedUser);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto bookDto = (BookDto) o;

        if (publishYear != bookDto.publishYear) return false;
        if (price != bookDto.price) return false;
        if (name != null ? !name.equals(bookDto.name) : bookDto.name != null) return false;
        if (author != null ? !author.equals(bookDto.author) : bookDto.author != null) return false;
        if (description != null ? !description.equals(bookDto.description) : bookDto.description != null) return false;
        return genre != null ? genre.equals(bookDto.genre) : bookDto.genre == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + publishYear;
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    public BookDto() {
    }
}
