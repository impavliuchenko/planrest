package com.planrest.dao.interfaces;

import com.planrest.entities.Restauranttype;

import java.util.List;

public interface RestaurantTypeDAO extends CrudDAO<Restauranttype, Integer>{
    Restauranttype getRestaurantTypeByRestaurantId(int id);
    List<String> getAllRestaurantTypes();
}
