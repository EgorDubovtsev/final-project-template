package com.epam.rd.izh.entity;

import java.time.LocalDate;

public interface User {

    public String getLogin();

    public void setLogin(String login);

    public String getPassword();

    public void setPassword(String password);

    public String getName();

    public void setName(String name);

    public String getRole();

    public void setRole(String role);

    public LocalDate getBirthdate();

    public void setBirthdate(LocalDate birthdate);

}
