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
}