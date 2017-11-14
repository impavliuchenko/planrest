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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserWallService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RestaurantPageComponent restaurantPageComponent;

    @Autowired
    UserPageComponent userPageComponent;

    @Transactional
    public void addUserWallByRestaurantWall(Restaurantwall restaurantWall, User user, String repostComment){

        Session session = sessionFactory.getCurrentSession();

        Userwall userwall = new Userwall();

        Query query = session
                .createQuery("SELECT uw FROM Userwall uw " +
                "WHERE uw.restaurantWallId = :restaurantWallId " +
                        "AND uw.userId = :userId");
        query.setParameter("restaurantWallId", restaurantWall);
        query.setParameter("userId", user);

        Userwall checkRepost = (Userwall) query.uniqueResult();

        if (checkRepost==null) {

            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");

            userwall.setDate(formatForDateNow.format(date));
            userwall.setComment(repostComment);
            userwall.setUserId(user);
            userwall.setRestaurantWallId(restaurantWall);

            session.save(userwall);
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

        Userwall userwall = new Userwall();
        userwall.setId(userWallId);
        session.delete(userwall);

        Query query2 = session.createQuery("DELETE Userwall uw " +
                "WHERE uw.restaurantWallId.id = :restaurantWallId " +
                "AND uw.userId.id = :userId");
        query2.setParameter("restaurantWallId", restaurantWallId);
        query2.setParameter("userId", userId);
        query2.executeUpdate();
    }

    @Transactional
    public List<Userwall> getUserwallsDoneByUserId(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT uw FROM Userwall uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND uw.restaurantWallId.date <= :currentDate " +
                        "ORDER BY uw.date DESC");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (List<Userwall>) query.list();
    }

    @Transactional
    public List<Userwall> getUserwallsPlanByUserId(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT uw FROM Userwall uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND uw.restaurantWallId.date > :currentDate " +
                        "ORDER BY uw.date DESC");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (List<Userwall>) query.list();
    }

    @Transactional
    public long getUserwallsDoneByUserIdCount(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM Userwall uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND uw.restaurantWallId.date <= :currentDate ");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (long) query.uniqueResult();
    }

    @Transactional
    public long getUserwallsPlanByUserIdCount(int id) {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = formatForDateNow.format(date);

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM Userwall uw " +
                        "INNER JOIN uw.userId u " +
                        "WHERE u.id = :id AND uw.restaurantWallId.date > :currentDate");
        query.setParameter("id", id);
        query.setParameter("currentDate", currentDate);

        return (long) query.uniqueResult();
    }

    public void setUserWallImagesByList(List<Userwall> userwalls){
        List<byte[]> images = new ArrayList<>();
        for (Userwall uw: userwalls){
            images.add(uw.getRestaurantWallId().getImage());
        }
        userPageComponent.setUserWallImages(images);
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
