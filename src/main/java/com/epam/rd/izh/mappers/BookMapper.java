package com.epam.rd.izh.mappers;


import com.epam.rd.izh.dto.BookDto;
import com.epam.rd.izh.dto.CreatedBookDTO;

public class BookMapper implements IBookMapper {

    @Override
    public BookDto mapFromCreatedBook(CreatedBookDTO createdBookDTO) {
        BookDto bookDTO = new BookDto();
        bookDTO.setAuthor(createdBookDTO.getAuthor());
        bookDTO.setDescription(createdBookDTO.getDescription());
        bookDTO.setName(createdBookDTO.getName());
        bookDTO.setPrice(createdBookDTO.getPrice());
        bookDTO.setPublishYear(createdBookDTO.getPublishYear());
        bookDTO.setGenre(createdBookDTO.getGenre());
        return bookDTO;
    }
}
