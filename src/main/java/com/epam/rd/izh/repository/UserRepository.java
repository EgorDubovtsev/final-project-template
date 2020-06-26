package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Administrator;
import com.epam.rd.izh.entity.AuthorizedUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.epam.rd.izh.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Данный репозиторий хранит список зарегистрированных пользователей;
 * На данный момент он представляет из себя коллекцию List<AuthorizedUser> и методы доступа к ней;
 *
 * Необходимо превратить данный репозиторий в DAO класс:
 * Создать базу данных, подключить ее к приложению, сделать CRUD операции (или их часть) для доступа
 * к хранящимся сущностям.
 * Создать другие DAO классы для хранения бизнес-сущностей выбранной темы финального проекта в этом же пакете.
 */

@Repository
public class UserRepository {//pass :1
  private final AuthorizedUser ADMIN = new AuthorizedUser("admin","$2a$10$n.QaCWAS19vlVzA4ylby0ebvQEUKPVysfkU2DEKakcqaVOoVTOzZW", Role.USER);
  private final List<AuthorizedUser> users = new ArrayList<>();

  /**
   * В данном методе использована библиотека Stream API:
   * .filter проверяет каждый элемент коллекции на удовлетворение условия .equals(login), в случае, если совпадающий
   * элемент будет найдет, он будет возвращен методом .findFirst(). Если в коллекции не будет найдет удовлетворяющий
   * условию элемент, методом .orElse(null) будет возвращен null.
   * Допускается использовать вместо  Stream API стандартные циклы For и While.
   *
   * аннотации @Nullable и @Nonnull расставляются над возвращающими не примитивные значения методами и передаваемыми
   * в метод аргументами.
   */

  @Nullable
  public AuthorizedUser getAuthorizedUserByLogin(@Nonnull String login) {
    System.out.println("TEST"+ ADMIN.toString());
  /** password must be encrypted*/
    users.add(ADMIN);// get out of here
    System.out.println(users);
    return users.stream()
        .filter(value -> value.getLogin().equals(login))
        .findFirst().orElse(null);
  }

  public boolean addAuthorizedUser(@Nullable AuthorizedUser user) {
    if (user != null) {
      System.out.println(user);
      users.add(user);
      return true;
    }
    return false;
  }

}
