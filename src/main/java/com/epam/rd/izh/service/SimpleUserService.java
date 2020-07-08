package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.AuthorizedUserDao;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;

@Service
public class SimpleUserService implements UserService {
    @Autowired
    private AuthorizedUserDao authorizedUserDao;

    @Override
    @Nullable
    public User getAuthorizedUserByLogin(String login) {
        return authorizedUserDao.getList().stream()
                .filter(value -> value.getLogin().equals(login))
                .findFirst().orElse(null);
    }

    @Override
    public boolean addAuthorizedUser(@Nullable AuthorizedUser user) {
        if (user != null) {
            authorizedUserDao.registrateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean isManager(String login) {
        String role = getAuthorizedUserByLogin(login).getRole();
        return role.equals("MANAGER");
    }
}
