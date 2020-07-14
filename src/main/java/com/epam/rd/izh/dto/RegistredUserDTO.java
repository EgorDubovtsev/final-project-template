package com.epam.rd.izh.dto;

public class RegistredUserDTO {
    private String name;
    private String login;
    private String password;
    private String role;
    private String birthdate;

    public RegistredUserDTO(String name, String login, String password, String role, String birthdate) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return "RegistredUserDTO{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
