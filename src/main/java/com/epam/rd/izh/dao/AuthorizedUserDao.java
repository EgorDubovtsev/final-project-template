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

    public AuthorizedUser getUserByLogin(String login) {
        //TODO: TEST ME
        String sql = "SElECT * FROM users WHERE LOGIN=?";
        return jdbcTemplate.queryForObject(sql, authorizedUserMapper);
    }

    @Override
    public List<AuthorizedUser> getList() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, authorizedUserMapper);
    }

    public int registrateUser(AuthorizedUser authorizedUser) {
        String sql = "INSERT INTO USERS (name, birthdate, login, password, role) VALUES ('"
                + authorizedUser.getName() + "','"
                + authorizedUser.getBirthdate() + "','"
                + authorizedUser.getLogin() + "','"
                + authorizedUser.getPassword() + "','"
                + authorizedUser.getRole() + "');";
        return jdbcTemplate.update(sql);
    }

}
