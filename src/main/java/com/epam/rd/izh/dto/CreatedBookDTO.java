package com.epam.rd.izh.dto;

public interface CreatedBookDTO {
    String getName();

    void setName(String name);

    String getAuthor();

    void setAuthor(String author);

    String getGenre();

    void setGenre(String genre);

    int getPublishYear();

    void setPublishYear(int publishYear);

    double getPrice();

    void setPrice(double price);

    String getDescription();

    void setDescription(String description);
}
