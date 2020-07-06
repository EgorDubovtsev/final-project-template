package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.User;

public class UserServiceImpl implements UserService {

    @Override
    public User getAuthorizedUserByLogin(String login) {
        return null;
    }

    @Override
    public boolean addAuthorizedUser(AuthorizedUser user) {
        return false;
    }

    @Override
    public boolean isManager(String login) {
        return false;
    }
}
