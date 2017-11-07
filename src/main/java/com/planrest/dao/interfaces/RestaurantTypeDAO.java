package com.planrest.dao.interfaces;

import com.planrest.entities.Restauranttype;

public interface RestaurantTypeDAO extends CrudDAO<Restauranttype, Integer>{
    Restauranttype getRestaurantTypeByRestaurantId(int id);
}
