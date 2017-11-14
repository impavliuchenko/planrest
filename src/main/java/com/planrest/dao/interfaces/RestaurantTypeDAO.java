package com.planrest.dao.interfaces;

import com.planrest.entities.Restauranttype;

import java.util.List;

public interface RestaurantTypeDAO extends CrudDAO<Restauranttype, Integer>{
    List<String> getAllRestaurantTypeNames();
}
