package com.epam.rd.izh.repository;

import com.epam.rd.izh.dto.BookDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDtoRepository extends CrudRepository<BookDto, Long> {
    BookDto findByName(String name);

    List<BookDto> findByNameLikeAndAuthorLikeAndGenreLikeAndPriceLessThanEqual(String name, String author, String genre, int price);
}
