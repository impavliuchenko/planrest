package com.planrest.dao.impl;

import com.planrest.dao.interfaces.RestaurantDAO;
import com.planrest.entities.Restaurant;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class RestaurantDAOImpl extends CrudDAOImpl <Restaurant, Integer> implements Serializable, RestaurantDAO {
    private static final long serialVersionUID = 1L;

}
