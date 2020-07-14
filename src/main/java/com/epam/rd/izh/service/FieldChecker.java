package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.CreatedBookDTO;
import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.User;

public interface FieldChecker {
    boolean isNull(RegistredUserDTO registredUserDTO);

    boolean isNull(CreatedBookDTO createdBookDTO);

    boolean isNull(User user);
}
