package com.planrest.dao.impl;

import com.planrest.dao.interfaces.RestaurantTypeDAO;
import com.planrest.entities.Restauranttype;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class RestaurantTypeDAOImpl extends CrudDAOImpl<Restauranttype, Integer> implements Serializable, RestaurantTypeDAO {

    @Override
    public List<String> getAllRestaurantTypeNames() {
        return (List<String>) sessionFactory.getCurrentSession()
                .createQuery("SELECT rt.typeName FROM Restauranttype rt").list();
    }
}
