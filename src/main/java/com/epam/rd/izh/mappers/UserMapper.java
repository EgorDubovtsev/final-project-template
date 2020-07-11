package com.epam.rd.izh.mappers;

import com.epam.rd.izh.dto.RegistredUserDTO;
import com.epam.rd.izh.entity.User;

public interface UserMapper{
    User mapFromDto(RegistredUserDTO registredUserDTO);
}
