package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.CreatedBookDTO;
import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.User;

public class FieldCheckerService implements FieldChecker {
    @Override
    public boolean isNull(RegistredUserDTO registredUserDTO) {
        return registredUserDTO == null
                || registredUserDTO.getName().trim().equals("")
                || registredUserDTO.getPassword().trim().equals("")
                || registredUserDTO.getBirthdate().trim().equals("")
                || registredUserDTO.getLogin().trim().equals("")
                || registredUserDTO.getRole().trim().equals("");
    }

    @Override
    public boolean isNull(CreatedBookDTO createdBookDTO) {
        return createdBookDTO == null
                || createdBookDTO.getName().trim().equals("")
                || createdBookDTO.getAuthor().trim().equals("")
                || createdBookDTO.getDescription().trim().equals("")
                || createdBookDTO.getGenre().equals("null")
                || createdBookDTO.getPrice() == 0
                || createdBookDTO.getPublishYear() == 0;
    }

    @Override
    public boolean isNull(User user) {
        return user == null
                || user.getName().equals("")
                || user.getRole().equals("")
                || user.getBirthdate() == null
                || user.getPassword().equals("")
                || user.getLogin().equals("");
    }
}
