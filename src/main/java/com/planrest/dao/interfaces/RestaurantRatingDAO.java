package com.planrest.dao.interfaces;

import com.planrest.entities.Restaurantrating;

public interface RestaurantRatingDAO extends CrudDAO<Restaurantrating, Integer> {
    Restaurantrating getRestaurantRatingByRestaurantId(int id);
    double getAverageRestaurantRatingByRestaurantId(int id);
}
