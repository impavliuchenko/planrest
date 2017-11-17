package com.planrest.services;

import com.planrest.dao.interfaces.UserDAO;
import com.planrest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    UserDAO userDAO;

    public User getUserByLogin() {
        UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDAO.getUserByLogin(ud.getUsername());
    }
}
