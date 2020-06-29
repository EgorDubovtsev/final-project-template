package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.User;

import javax.annotation.Nullable;

public interface IUserRepository {
    User getAuthorizedUserByLogin(String login);

    boolean addAuthorizedUser(AuthorizedUser user);

    boolean isManager(String login);
}
