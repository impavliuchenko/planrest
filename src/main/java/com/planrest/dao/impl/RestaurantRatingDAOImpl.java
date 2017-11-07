package com.planrest.dao.impl;

import com.planrest.dao.interfaces.RestaurantRatingDAO;
import com.planrest.entities.Restaurantrating;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Transactional
@Repository
public class RestaurantRatingDAOImpl extends CrudDAOImpl<Restaurantrating, Integer> implements Serializable, RestaurantRatingDAO {
    private static final long serialVersionUID = 1L;

    @Override
    public Restaurantrating getRestaurantRatingByRestaurantId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT rr FROM Restaurantrating rr INNER JOIN rr.restaurantId r WHERE r.id = :id");
        query.setParameter("id", id);
        return (Restaurantrating) query.uniqueResult();
    }

    @Override
    public double getAverageRestaurantRatingByRestaurantId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT AVG(rr.rating) FROM Restaurantrating rr INNER JOIN rr.restaurantId r " +
                        "WHERE r.id = :id GROUP BY r.id");
        query.setParameter("id", id);
        return (double) query.uniqueResult();
    }
}
