package com.planrest.dao.interfaces;

import com.planrest.dao.impl.CrudDAOImpl;
import com.planrest.entities.Restaurantlocation;

import java.util.List;

public interface RestaurantLocationDAO extends CrudDAO<Restaurantlocation, Integer> {
    Restaurantlocation getRestaurantLocationByRestaurantId(int id);
    List<String> getAllRestaurantLocations();
}
