package com.planrest.services;

import com.planrest.entities.Restaurantwall;
import com.planrest.entities.UserwallRestaurantwall;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RestaurantWallService {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Restaurantwall> getRestaurantWallsDoneByRestaurantId(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT rw FROM Restaurantwall rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE r.id = :id AND rw.date <= :currentDate " +
                        "ORDER BY rw.date DESC");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (List<Restaurantwall>) query.list();
    }

    @Transactional
    public List<Restaurantwall> getRestaurantWallsPlanByRestaurantId(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT rw FROM Restaurantwall rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE r.id = :id AND rw.date > :currentDate " +
                        "ORDER BY rw.date DESC");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (List<Restaurantwall>) query.list();
    }

    @Transactional
    public long getRestaurantWallsDoneByRestaurantIdCount(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM Restaurantwall rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE r.id = :id AND rw.date <= :currentDate ");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (long) query.uniqueResult();
    }

    @Transactional
    public long getRestaurantWallsPlanByRestaurantIdCount(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM Restaurantwall rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE r.id = :id AND rw.date > :currentDate ");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (long) query.uniqueResult();
    }
}
