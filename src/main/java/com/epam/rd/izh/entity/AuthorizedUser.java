package com.epam.rd.izh.entity;

import com.epam.rd.izh.dto.BookDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users_jpa_new")
public class AuthorizedUser implements User {
    @Id
    private String login;
    private String password;
    private String name;
    private String role;
    private LocalDate birthdate;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BookDto> books = new ArrayList<>();

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<BookDto> getBooks() {
        return books;
    }


    public void addBook(BookDto bookDto){
        System.out.println("ADD BOOK BEF"+books);
        books.add(bookDto);
        System.out.println("ADD BOOK af"+books);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorizedUser that = (AuthorizedUser) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        return birthdate != null ? birthdate.equals(that.birthdate) : that.birthdate == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
