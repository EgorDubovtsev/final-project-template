package com.epam.rd.izh.dao;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AuthorizedUserDao implements Dao {
    JdbcTemplate jdbcTemplate;
    AuthorizedUserMapper authorizedUserMapper;


    public AuthorizedUserDao(JdbcTemplate jdbcTemplate, AuthorizedUserMapper authorizedUserMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorizedUserMapper = authorizedUserMapper;
    }

    /**
     * TODO: add more methods
     */


    @Override
    public List<AuthorizedUser> getList() {
        String sql = "SELECT * FROM users full join authorized_data on users.login=authorized_data.login";
        return jdbcTemplate.query(sql, authorizedUserMapper);
    }

    public int registrateUser(AuthorizedUser authorizedUser) {
        String sqlInsertIntoUsers = "INSERT INTO USERS (user_name,login, birthdate, role) VALUES ('"
                + authorizedUser.getLogin() + "','"
                + authorizedUser.getName() + "','"
                + authorizedUser.getBirthdate() + "','"
                + authorizedUser.getRole() + "');";
        String sqlInsertIntoAuthorizedData = "INSERT INTO authorized_data values('"
                +authorizedUser.getLogin()+"','"+authorizedUser.getPassword()+"');";
        jdbcTemplate.update(sqlInsertIntoUsers);
        return jdbcTemplate.update(sqlInsertIntoAuthorizedData);
    }

}
