package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.User;
import com.epam.rd.izh.repository.AuthorizedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;

@Service
public class SimpleUserService implements UserService {
    @Autowired
    private AuthorizedUserRepository authorizedUserRepository;

    @Override
    @Nullable
    public User getAuthorizedUserByLogin(String login) {
        return authorizedUserRepository.findAll().stream()
                .filter(value -> value.getLogin().equals(login))
                .findFirst().orElse(null);
    }

    @Override
    public boolean addAuthorizedUser(@Nullable AuthorizedUser user) {
        if (user != null) {
            authorizedUserRepository.save(user);
            return true;
        }
        return false;
    }

}
