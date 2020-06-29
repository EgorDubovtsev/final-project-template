package com.epam.rd.izh.entity;

public enum Role {
    USER,
    MANAGER;


    public String toString(Role role) {
        return String.valueOf(role);
    }
}
