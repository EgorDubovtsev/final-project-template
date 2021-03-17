package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDtoRepository extends CrudRepository<Book, Long> {
    Book findByName(String name);

    List<Book> findByNameLikeAndAuthorLikeAndGenreLikeAndPriceLessThanEqual(String name, String author, String genre, int price);

}
