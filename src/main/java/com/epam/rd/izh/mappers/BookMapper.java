package com.epam.rd.izh.mappers;


import com.epam.rd.izh.entity.Book;
import com.epam.rd.izh.dto.CreatedBookDTO;

public class BookMapper implements IBookMapper {

    @Override
    public Book mapFromCreatedBook(CreatedBookDTO createdBookDTO) {
        Book book = new Book();
        book.setDescription(createdBookDTO.getDescription());
        book.setName(createdBookDTO.getName());
        book.setPrice(createdBookDTO.getPrice());
        book.setPublishYear(createdBookDTO.getPublishYear());
        book.setGenre(createdBookDTO.getGenre());

        return book;
    }
}
