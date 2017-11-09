package com.planrest.services;

import com.planrest.entities.Restaurantwall;
import com.planrest.entities.User;
import com.planrest.entities.Userwall;
import com.planrest.entities.UserwallRestaurantwall;
import com.planrest.objects.RestaurantPageComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserWallService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RestaurantPageComponent restaurantPageComponent;

    @Transactional
    public void addUserWallByRestaurantWall(Restaurantwall restaurantWall, User user, String repostComment){

        Userwall userwall = new Userwall();
        UserwallRestaurantwall userwallRestaurantwall = new UserwallRestaurantwall();
        Session session = sessionFactory.getCurrentSession();

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        userwall.setDate(formatForDateNow.format(date));
        userwall.setComment(repostComment);
        userwall.setUserId(user);

        int userWallId = (int) session.save(userwall);
        session.flush();

        userwall = session.get(Userwall.class, userWallId);

        userwallRestaurantwall.setRestaurantWallId(restaurantWall);
        userwallRestaurantwall.setUserWallId(userwall);

        session.save(userwallRestaurantwall);
        session.flush();

        restaurantPageComponent.setRepostComment("");

    }

    @Transactional
    public void deleteUserWallbyUserWallIdAndRestaurantWallId(int userWallId, int restaurantWallId){
        Session session = sessionFactory.getCurrentSession();

        Userwall userwall = new Userwall();
        userwall.setId(userWallId);

        UserwallRestaurantwall userwallRestaurantwall = new UserwallRestaurantwall();
        userwallRestaurantwall.setId(restaurantWallId);

        session.delete(userwallRestaurantwall);
        session.delete(userwall);
    }
}
