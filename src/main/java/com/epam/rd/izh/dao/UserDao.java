package com.epam.rd.izh.dao;

import com.epam.rd.izh.entity.AuthorizedUser;

import java.util.List;

public interface UserDao {
    List<AuthorizedUser> getList();

    int registrateUser(AuthorizedUser authorizedUser);
}
