package com.epam.rd.izh.entity;

import java.time.LocalDate;

public interface User {

    public String getLogin();

    public void setLogin(String login);

    public String getPassword();

    public void setPassword(String password);

    public String getName();

    public void setName(String name);

    public Role getRole();

    public void setRole(Role role);

    public LocalDate getBirthdate();

    public void setBirthdate(LocalDate birthdate);

    public AuthorizedUser login(String login);

    public AuthorizedUser password(String password);

    public AuthorizedUser role(Role role);
}
