package com.epam.rd.izh.dao;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AuthorizedUserDao implements UserDao {
    JdbcTemplate jdbcTemplate;
    AuthorizedUserMapper authorizedUserMapper;


    public AuthorizedUserDao(JdbcTemplate jdbcTemplate, AuthorizedUserMapper authorizedUserMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorizedUserMapper = authorizedUserMapper;
    }

    @Override
    public List<AuthorizedUser> getList() {
        String sql = "SELECT * FROM users full join authorized_data on users.login=authorized_data.login";
        return jdbcTemplate.query(sql, authorizedUserMapper);
    }

    @Override
    public int registrateUser(AuthorizedUser authorizedUser) {
        String sqlInsertIntoUsers = "INSERT INTO USERS (user_name,login, birthdate, role) VALUES ('"
                + authorizedUser.getName() + "','"
                + authorizedUser.getLogin() + "','"
                + authorizedUser.getBirthdate() + "','"
                + authorizedUser.getRole() + "');";
        String sqlInsertIntoAuthorizedData = "INSERT INTO authorized_data values('"
                + authorizedUser.getLogin() + "','" + authorizedUser.getPassword() + "');";
        String roleTable = authorizedUser.getRole().equals("MANAGER") ? "managers" : "customers";
        String addToRoleGroup = "INSERT INTO " + roleTable + " VALUES ('" + authorizedUser.getLogin() + "')";
        jdbcTemplate.update(sqlInsertIntoUsers);
        jdbcTemplate.update(addToRoleGroup);
        return jdbcTemplate.update(sqlInsertIntoAuthorizedData);
    }

}
