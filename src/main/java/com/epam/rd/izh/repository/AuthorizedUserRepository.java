package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.AuthorizedUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorizedUserRepository extends CrudRepository<AuthorizedUser, Long> {
    List<AuthorizedUser> findAll();

    AuthorizedUser findByLogin(String login);
}
