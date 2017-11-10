package com.planrest.dao.interfaces;

import com.planrest.entities.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User, Integer> {
    User getUserByLogin(String login);
    List<User> getFriendsByUserId(int id);
    List<User> getUsersByRestaurantWallId(int id);
}
