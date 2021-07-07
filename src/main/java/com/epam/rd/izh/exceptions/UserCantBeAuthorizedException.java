package com.epam.rd.izh.exceptions;

public class UserCantBeAuthorizedException extends Exception {
    public UserCantBeAuthorizedException() {
    }

    public UserCantBeAuthorizedException(String s) {
        super(s);
    }
}
