package com.planrest.dao.impl;

import com.planrest.dao.interfaces.UserWallDAO;
import com.planrest.entities.Userwall;
import com.planrest.entities.UserwallRestaurantwall;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class UserWallDAOImpl extends CrudDAOImpl<Userwall, Integer> implements Serializable, UserWallDAO {

    private static final long serialVersionUID = 1L;

    @Override
    public List<UserwallRestaurantwall> getUserWallPostsByUserId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT uwrw FROM UserwallRestaurantwall uwrw " +
                        "INNER JOIN uwrw.userWallId uw " +
                        "INNER JOIN uwrw.restaurantWallId rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE uw.userId = :id");
        query.setParameter("id", id);
        List<?> list = query.getResultList();
        return null;
    }

}
