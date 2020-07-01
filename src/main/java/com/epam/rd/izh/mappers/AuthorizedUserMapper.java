package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuthorizedUserMapper implements RowMapper<AuthorizedUser>, UserMapper {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public AuthorizedUser mapRow(ResultSet resultSet, int i) throws SQLException {
        AuthorizedUser authorizedUser = new AuthorizedUser();
        authorizedUser.setName(resultSet.getString("user_name"));
        authorizedUser.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
        authorizedUser.setLogin(resultSet.getString("login"));
        authorizedUser.setPassword(resultSet.getString("password"));
        authorizedUser.setRole(resultSet.getString("role"));
        return authorizedUser;
    }

    @Override
    public AuthorizedUser mapFromDto(RegistredUserDTO registredUserDTO) {
        AuthorizedUser authorizedUser = new AuthorizedUser();
        authorizedUser.setName(registredUserDTO.getName());
        authorizedUser.setRole(registredUserDTO.getRole());
        authorizedUser.setPassword(registredUserDTO.getPassword());
        authorizedUser.setLogin(registredUserDTO.getLogin());
        authorizedUser.setBirthdate(LocalDate.parse(registredUserDTO.getBirthdate(), dateTimeFormatter));
        return authorizedUser;
    }
}
