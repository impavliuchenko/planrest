package com.planrest.dao.impl;

import com.planrest.dao.interfaces.UserDAO;
import com.planrest.entities.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class UserDAOImpl extends CrudDAOImpl<User, Integer> implements Serializable, UserDAO {

    private static final long serialVersionUID = 1L;

    @Override
    public User getUserByLogin(String login){
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.login LIKE login").uniqueResult();
    }

    @Override
    public List<User> getFriendsByUserId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM Friend f INNER JOIN f.friendId u WHERE f.userId = :id");
        query.setParameter("id", id);
        List<User> user = (List<User>) query.list();
        return user;
    }

    @Override
    public List<User> getUserWallsByRestaurantWallId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT uw FROM Userwall uw " +
                        "INNER JOIN uw.restaurantWallId rw " +
                        "WHERE rw.id = :id");
        query.setParameter("id", id);

        return (List<User>) query.list();
    }

    @Override
    public List<User> getVisitorsByRestaurantId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT DISTINCT uw.userId FROM Userwall uw " +
                        "INNER JOIN uw.restaurantWallId rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE r.id = :id ");
        query.setParameter("id", id);
        return (List<User>) query.list();
    }
}
