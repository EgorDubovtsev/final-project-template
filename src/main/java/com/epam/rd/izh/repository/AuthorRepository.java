package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String name);
}
