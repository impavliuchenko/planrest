package com.planrest.dao.impl;

import com.planrest.dao.interfaces.RestaurantWallDAO;
import com.planrest.entities.Restaurantwall;
import com.planrest.entities.UserwallRestaurantwall;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class RestaurantWallDAOImpl extends CrudDAOImpl<Restaurantwall, Integer> implements Serializable, RestaurantWallDAO {
    private static final long serialVersionUID = 1L;

    @Override
    public List<UserwallRestaurantwall> getUserwallRestaurantwallByRestaurantId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT uwrw FROM UserwallRestaurantwall uwrw " +
                        "INNER JOIN uwrw.restaurantWallId rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE r.id = :id");
        query.setParameter("id", id);
        return (List<UserwallRestaurantwall>) query.list();
    }
}
