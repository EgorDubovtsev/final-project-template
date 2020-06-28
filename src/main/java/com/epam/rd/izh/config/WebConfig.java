package com.epam.rd.izh.config;

import com.epam.rd.izh.dao.AuthorizedUserDao;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import com.epam.rd.izh.repository.UserRepository;
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

}
