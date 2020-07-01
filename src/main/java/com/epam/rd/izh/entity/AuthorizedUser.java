package com.epam.rd.izh.entity;

import java.time.LocalDate;
import java.util.Date;

/**
 * Сущность пользователя, содержит данные(credentials), необходимые для авторизации в Spring Web приложении; Может
 * быть использована как часть бизнес логики приложеняи, например сотрудник больницы, где role определяет его
 * полномочия.
 * <p>
 * Рекомендуется добавить поле id в сущнсть пользователя. Поле id может генерироваться базой данных, также можно
 * добавить в код приложения сервис, генерирующий UUID: 'private UUID id = randomUUID();' и проверяющий его на
 * наличие совпадений с уже существующими.
 */

public class AuthorizedUser implements User {
    private String login;
    private String password;
    private String name;
    private String role;
    private LocalDate birthdate;

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

    /**
     * Определяет GrantedAuthority пользователя. Может быть колелкцией, например Set<Strings> если логика приложения
     * подразумевает множество ролей и их комбинацию в пределах одного пользователя.
     * Хорошим решением будет хранить роль в таблице БД, также допускается использовать ENUM класс в пакете utils.
     * Если роль для бизнес-логики не важна, можно задать для всех объектов 'private String role = "User"'.
     */


    /**
     * Ниже представлена простая реализация паттерна builder;
     * Паттерн builder рекомендуется использовать в DTO или часто создаваемых Entity объектах для лаконичности кода;
     * Реализация паттерна builder может быть легко добавлена при помощи библиотеки Lombok.
     */


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
