package com.planrest.dao.impl;

import com.planrest.dao.interfaces.RestaurantTypeDAO;
import com.planrest.entities.Restauranttype;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
@Repository
public class RestaurantTypeDAOImpl extends CrudDAOImpl<Restauranttype, Integer> implements Serializable, RestaurantTypeDAO {
    @Override
    public Restauranttype getRestaurantTypeByRestaurantId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT rt FROM RestaurantRestauranttype rrt " +
                        "INNER JOIN rrt.restaurantTypeId rt " +
                        "INNER JOIN rrt.restaurantId r " +
                        "WHERE r.id = :id");
        query.setParameter("id", id);
        return (Restauranttype) query.uniqueResult();
    }
}
