package com.epam.rd.izh.mappers;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizedUserMapper implements RowMapper<AuthorizedUser> {

    @Override
    public AuthorizedUser mapRow(ResultSet resultSet, int i) throws SQLException {
        AuthorizedUser authorizedUser = new AuthorizedUser();
        authorizedUser.setName(resultSet.getString("name"));
        authorizedUser.setBirthdate(resultSet.getDate("birthdate"));
        authorizedUser.setLogin(resultSet.getString("login"));
        authorizedUser.setPassword(resultSet.getString("password"));
        authorizedUser.setRole(resultSet.getString("role").equals("ADMIN") ? Role.ADMIN : Role.USER);
        return authorizedUser;
    }
}
