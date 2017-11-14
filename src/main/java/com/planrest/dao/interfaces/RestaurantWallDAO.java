package com.planrest.dao.interfaces;

import com.planrest.entities.Restaurantwall;

import java.util.List;

public interface RestaurantWallDAO extends CrudDAO<Restaurantwall, Integer> {
    List<Restaurantwall> getRestaurantWallsByRestaurantId(int id);
}
