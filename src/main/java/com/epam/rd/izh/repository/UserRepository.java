package com.epam.rd.izh.repository;

import com.epam.rd.izh.dao.AuthorizedUserDao;
import com.epam.rd.izh.entity.AuthorizedUser;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Данный репозиторий хранит список зарегистрированных пользователей;
 * На данный момент он представляет из себя коллекцию List<AuthorizedUser> и методы доступа к ней;
 * <p>
 * Необходимо превратить данный репозиторий в DAO класс:
 * Создать базу данных, подключить ее к приложению, сделать CRUD операции (или их часть) для доступа
 * к хранящимся сущностям.
 * Создать другие DAO классы для хранения бизнес-сущностей выбранной темы финального проекта в этом же пакете.
 */

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private AuthorizedUserDao authorizedUserDao;

    public UserRepository(AuthorizedUserDao authorizedUserDao) {
        this.authorizedUserDao = authorizedUserDao;
    }

    /**
     * В данном методе использована библиотека Stream API:
     * .filter проверяет каждый элемент коллекции на удовлетворение условия .equals(login), в случае, если совпадающий
     * элемент будет найдет, он будет возвращен методом .findFirst(). Если в коллекции не будет найдет удовлетворяющий
     * условию элемент, методом .orElse(null) будет возвращен null.
     * Допускается использовать вместо  Stream API стандартные циклы For и While.
     * <p>
     * аннотации @Nullable и @Nonnull расставляются над возвращающими не примитивные значения методами и передаваемыми
     * в метод аргументами.
     */
    @Override
    @Nullable
    public AuthorizedUser getAuthorizedUserByLogin(@Nonnull String login) {
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
