package com.planrest.dao.interfaces;

import com.planrest.entities.Restaurantwall;
import com.planrest.entities.UserwallRestaurantwall;

import java.util.List;

public interface RestaurantWallDAO extends CrudDAO<Restaurantwall, Integer> {
    List<UserwallRestaurantwall> getUserwallRestaurantwallByRestaurantId(int id);
}
