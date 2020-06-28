package com.epam.rd.izh.dao;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AuthorizedUserDao {
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
        String sql = "SElECT * FROM users WHERE LOGIN=?";
        return jdbcTemplate.queryForObject(sql, authorizedUserMapper);
    }

    public List<AuthorizedUser> getUsersList(){
        String sql = "SELECT * FROM users";
        System.out.println(authorizedUserMapper+" 2 "+jdbcTemplate);
        return jdbcTemplate.query(sql,authorizedUserMapper);
    }

}
