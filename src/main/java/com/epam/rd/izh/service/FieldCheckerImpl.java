package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.RegistredUserDTO;

public class FieldCheckerImpl implements FieldChecker {
    @Override
    public boolean isNull(RegistredUserDTO registredUserDTO) {
        return registredUserDTO.getName() == null
                && registredUserDTO.getPassword() == null
                && registredUserDTO.getBirthdate() == null
                && registredUserDTO.getLogin() == null
                && registredUserDTO.getPassword()==null;
    }
}
