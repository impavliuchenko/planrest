package com.planrest.services;

import com.planrest.dao.interfaces.LocationDAO;
import com.planrest.entities.Location;
import com.planrest.entities.Role;
import com.planrest.entities.User;
import com.planrest.entities.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    LocationDAO locationDAO;

    public User createEmptyUser(){
        return new User();
    }

    @Transactional
    public void createNewUser(User user, String locationName){

        Session session =  sessionFactory.getCurrentSession();
        Location location = null;

        if (locationName == "<location>"){
            //TODO
        }else{
            location  = locationDAO.getLocationByLocationName(locationName);
        }
        user.setLocationId(location);
        user.setBirthday(Date.valueOf("1997-12-12"));
        user.setSex("male");
        user.setEnabled(1);

        int id = (int) session.save(user);
        session.flush();

        UserRole userRole = new UserRole();
        Role role = new Role();
        role.setId(2);
        User saveUser = new User();
        saveUser.setId(4);

        userRole.setRoleId(role);
        userRole.setUserId(saveUser);

        session.save(userRole);
        session.flush();

    }

    public List<String> getAllLocations(){
        List <String> list = new ArrayList<>();
        list.add("<location>");
        list.addAll(locationDAO.getAllLocationNames());
        return list;
    }
}
