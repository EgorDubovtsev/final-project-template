package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByName(String name);

    List<Book> findByNameLikeAndAuthorNameLikeAndGenreLikeAndPriceLessThanEqual(String name, String authorName, String genre, int price);

    List<Book> findAll();

}
