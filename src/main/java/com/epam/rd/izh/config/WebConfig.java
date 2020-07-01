package com.epam.rd.izh.config;

import com.epam.rd.izh.dao.AuthorizedUserDao;
import com.epam.rd.izh.dao.BooksDao;
import com.epam.rd.izh.dao.CartDaoImpl;
import com.epam.rd.izh.dto.BookInCart;
import com.epam.rd.izh.dto.BookInCartImpl;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import com.epam.rd.izh.mappers.BookMapper;
import com.epam.rd.izh.mappers.CartMapper;
import com.epam.rd.izh.repository.UserRepository;
import com.epam.rd.izh.service.Converter;
import com.epam.rd.izh.service.ConverterService;
import com.epam.rd.izh.service.UserPriority;
import com.epam.rd.izh.service.UserPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class WebConfig {
    /**
     * Данный класс можно использовать для создание бинов приложения, например бин ObjectMapper для десериализации.
     * Этот класс не является обязательным, но является стандартным там, где используется настройка бинов.
     */
    @Bean
    public AuthorizedUserMapper authorizedUserMapper() {
        return new AuthorizedUserMapper();
    }

    @Autowired
    @Bean
    public AuthorizedUserDao authorizedUserDao(JdbcTemplate jdbcTemplate, AuthorizedUserMapper authorizedUserMapper) {
        return new AuthorizedUserDao(jdbcTemplate, authorizedUserMapper);
    }

    @Bean
    public UserPriority userPriority(){
        return new UserPriorityService();
    }

    @Bean
    public BookMapper bookMapper(){
        return new BookMapper();
    }
    public BooksDao booksDao(){
        return new BooksDao();
    }
    @Bean
    public CartDaoImpl cartDao(){
        return new CartDaoImpl();
    }
    @Bean
    public BookInCart bookInCart(){
        return new BookInCartImpl();
    }
    @Bean
    public CartMapper cartMapper(){
        return new CartMapper();
    }
    @Bean
    public Converter converter(){
        return new ConverterService();
    }
}
