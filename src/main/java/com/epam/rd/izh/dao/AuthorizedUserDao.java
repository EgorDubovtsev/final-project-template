package com.epam.rd.izh.dao;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AuthorizedUserDao implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AuthorizedUserMapper authorizedUserMapper;


    public AuthorizedUserDao(JdbcTemplate jdbcTemplate, AuthorizedUserMapper authorizedUserMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorizedUserMapper = authorizedUserMapper;
    }

    @Override
    public List<AuthorizedUser> getList() {
        String sql = "SELECT * FROM users full join authorized_data on users.login = authorized_data.login";
        return jdbcTemplate.query(sql, authorizedUserMapper);
    }

    @Override
    public int registrateUser(AuthorizedUser authorizedUser) {
        String sqlInsertIntoUsers = "INSERT INTO USERS (user_name,login, birthdate, role) VALUES (?, ?, ?, ?)";
        String sqlInsertIntoAuthorizedData = "INSERT INTO authorized_data values('"
                + authorizedUser.getLogin() + "','" + authorizedUser.getPassword() + "');";
        String roleTable = authorizedUser.getRole().equals("MANAGER") ? "managers" : "customers";
        String addToRoleGroup = "INSERT INTO " + roleTable + " VALUES (?)";
        jdbcTemplate.update(sqlInsertIntoUsers, authorizedUser.getName(),
                authorizedUser.getLogin(), authorizedUser.getBirthdate(), authorizedUser.getRole());
        jdbcTemplate.update(addToRoleGroup, authorizedUser.getLogin());

        return jdbcTemplate.update(sqlInsertIntoAuthorizedData);
    }

}
