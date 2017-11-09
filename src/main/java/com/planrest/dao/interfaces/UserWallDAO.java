package com.planrest.dao.interfaces;

import com.planrest.entities.Userwall;
import com.planrest.entities.UserwallRestaurantwall;

import java.util.List;

public interface UserWallDAO extends CrudDAO <Userwall, Integer>{
    List<UserwallRestaurantwall> getUserWallPostsByUserId(int id);
    List<UserwallRestaurantwall> getUserwallRestaurantwallsByUserId(int id);
}
