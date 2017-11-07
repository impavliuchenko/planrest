package com.planrest.dao.impl;

import com.planrest.dao.interfaces.RestaurantLocationDAO;
import com.planrest.entities.Restaurantlocation;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
@Repository
public class RestaurantLocationDAOImpl extends CrudDAOImpl<Restaurantlocation, Integer> implements Serializable, RestaurantLocationDAO {
    private static final long serialVersionUID = 1L;
    @Override
    public Restaurantlocation getRestaurantLocationByRestaurantId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT rl FROM RestaurantRestaurantlocation rrl INNER JOIN  rrl.restaurantId r " +
                        "INNER JOIN rrl.restaurantLocationId rl WHERE r.id = :id");
        query.setParameter("id", id);
        return (Restaurantlocation) query.uniqueResult();
    }
}
