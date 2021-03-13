package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuthorizedUserMapper implements UserMapper {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
