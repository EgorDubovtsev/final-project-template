package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.User;

public interface UserService {
    User getAuthorizedUserByLogin(String login);

    boolean addAuthorizedUser(AuthorizedUser user);

    boolean isManager(String login);
}
