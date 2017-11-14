package com.planrest.dao.impl;

import com.planrest.dao.interfaces.RestaurantWallDAO;
import com.planrest.entities.Restaurantwall;
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
    public List<Restaurantwall> getRestaurantWallsByRestaurantId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT rw FROM Restaurantwall rw " +
                        "INNER JOIN rw.restaurantId r " +
                        "WHERE r.id = :id ORDER BY rw.date DESC");
        query.setParameter("id", id);
        return (List<Restaurantwall>) query.list();
    }
}
