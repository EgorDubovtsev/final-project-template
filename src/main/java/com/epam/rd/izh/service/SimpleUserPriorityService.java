package com.epam.rd.izh.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SimpleUserPriorityService implements UserPriorityService {

    @Override
    public String checkPriority() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().toArray()[0].toString();
    }

}
