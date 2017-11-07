package com.planrest.dao.interfaces;

import com.planrest.dao.impl.CrudDAOImpl;
import com.planrest.entities.Restaurantlocation;

public interface RestaurantLocationDAO extends CrudDAO<Restaurantlocation, Integer> {
    Restaurantlocation getRestaurantLocationByRestaurantId(int id);
}
