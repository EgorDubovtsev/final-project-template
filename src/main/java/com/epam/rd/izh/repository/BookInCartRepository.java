package com.epam.rd.izh.repository;

import com.epam.rd.izh.dto.BookInCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookInCartRepository extends CrudRepository<BookInCart, Long> {
    List<BookInCart> findByUserLogin(String userLogin);
}
