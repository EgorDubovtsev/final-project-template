package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.CreatedBookDTO;
import com.epam.rd.izh.dto.RegistredUserDTO;

public class FieldCheckerImpl implements FieldChecker {
    @Override
    public boolean isNull(RegistredUserDTO registredUserDTO) {
        return registredUserDTO.getName().equals("")
                || registredUserDTO.getPassword().equals("")
                || registredUserDTO.getBirthdate().equals("")
                || registredUserDTO.getLogin().equals("")
                || registredUserDTO.getRole().equals("");
    }

    @Override
    public boolean isNull(CreatedBookDTO createdBookDTO) {
        return createdBookDTO.getName().trim().equals("")
                || createdBookDTO.getAuthor().trim().equals("")
                || createdBookDTO.getDescription().trim().equals("")
                || createdBookDTO.getGenre().equals("null")
                || createdBookDTO.getPrice()==0
                || createdBookDTO.getPublishYear()==0;
    }
}
