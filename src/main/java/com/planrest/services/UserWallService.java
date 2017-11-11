package com.planrest.services;

import com.planrest.entities.*;
import com.planrest.objects.RestaurantPageComponent;
import com.planrest.objects.UserPageComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserWallService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RestaurantPageComponent restaurantPageComponent;

    @Transactional
    public void addUserWallByRestaurantWall(Restaurantwall restaurantWall, User user, String repostComment){

        Session session = sessionFactory.getCurrentSession();

        Userwall userwall = new Userwall();
        UserwallRestaurantwall userwallRestaurantwall = new UserwallRestaurantwall();
        RestaurantwallUser restaurantwallUser = new RestaurantwallUser();

        Query query = session
                .createQuery("SELECT rwu FROM RestaurantwallUser rwu " +
                "WHERE rwu.restaurantWallId = :restaurantWallId " +
                        "AND rwu.userId = :userId");
        query.setParameter("restaurantWallId", restaurantWall);
        query.setParameter("userId", user);

        RestaurantwallUser checkRepost = (RestaurantwallUser) query.uniqueResult();

        if (checkRepost==null) {

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

            restaurantwallUser.setUserId(user);
            restaurantwallUser.setRestaurantWallId(restaurantWall);

            session.save(restaurantwallUser);
            session.flush();

            restaurantPageComponent.setRepostComment("");

            okRepostingDialog();

        } else {
            restaurantPageComponent.setRepostComment("");
            errorRepostingDialog();
        }

    }

    @Transactional
    public void deleteUserWallbyUserWallIdAndRestaurantWallId(int userWallId, int restaurantWallId, int userId){
        Session session = sessionFactory.getCurrentSession();

        Query query1 = session.createQuery("DELETE UserwallRestaurantwall uwrw " +
                "WHERE uwrw.userWallId.id = :userWallId " +
                "AND uwrw.restaurantWallId.id = :restaurantWallId");
        query1.setParameter("userWallId", userWallId);
        query1.setParameter("restaurantWallId", restaurantWallId);
        query1.executeUpdate();

        Userwall userwall = new Userwall();
        userwall.setId(userWallId);
        session.delete(userwall);

        Query query2 = session.createQuery("DELETE RestaurantwallUser rwu " +
                "WHERE rwu.restaurantWallId.id = :restaurantWallId " +
                "AND rwu.userId.id = :userId");
        query2.setParameter("restaurantWallId", restaurantWallId);
        query2.setParameter("userId", userId);
        query2.executeUpdate();
    }

    @Transactional
    public List<UserwallRestaurantwall> getUserwallRestaurantwallsDoneByUserId(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT uwrw FROM UserwallRestaurantwall uwrw " +
                        "INNER JOIN uwrw.restaurantWallId rw " +
                        "INNER JOIN uwrw.userWallId uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND rw.date <= :currentDate " +
                        "ORDER BY uw.date DESC");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (List<UserwallRestaurantwall>) query.list();
    }

    @Transactional
    public List<UserwallRestaurantwall> getUserwallRestaurantwallsPlanByUserId(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT uwrw FROM UserwallRestaurantwall uwrw " +
                        "INNER JOIN uwrw.restaurantWallId rw " +
                        "INNER JOIN uwrw.userWallId uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND rw.date > :currentDate " +
                        "ORDER BY uw.date DESC");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (List<UserwallRestaurantwall>) query.list();
    }

    @Transactional
    public long getUserwallRestaurantwallsDoneByUserIdCount(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM UserwallRestaurantwall uwrw " +
                        "INNER JOIN uwrw.restaurantWallId rw " +
                        "INNER JOIN uwrw.userWallId uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND rw.date <= :currentDate ");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (long) query.uniqueResult();
    }

    @Transactional
    public long getUserwallRestaurantwallsPlanByUserIdCount(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM UserwallRestaurantwall uwrw " +
                        "INNER JOIN uwrw.restaurantWallId rw " +
                        "INNER JOIN uwrw.userWallId uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND rw.date > :currentDate ");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (long) query.uniqueResult();
    }

    public void splitDialog() {
        RequestContext.getCurrentInstance().execute("userUsersDialog.show()");
    }

    public void errorRepostingDialog() {
        RequestContext.getCurrentInstance().execute("errorRepostingDialog.show()");
    }

    public void okRepostingDialog() {
        RequestContext.getCurrentInstance().execute("okRepostingDialog.show()");
    }


}
