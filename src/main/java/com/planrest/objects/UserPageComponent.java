package com.planrest.objects;

import com.planrest.entities.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class UserPageComponent implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;
    private Restaurant restaurant;
    private List<UserwallRestaurantwall> userwallRestaurantwalls;
    private int userWallId;
    private int userWallRestaurantWallId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<UserwallRestaurantwall> getUserwallRestaurantwalls() {
        return userwallRestaurantwalls;
    }

    public void setUserwallRestaurantwalls(List<UserwallRestaurantwall> userwallRestaurantwalls) {
        this.userwallRestaurantwalls = userwallRestaurantwalls;
    }

    public int getUserWallId() {
        return userWallId;
    }

    public void setUserWallId(int userWallId) {
        this.userWallId = userWallId;
    }

    public int getUserWallRestaurantWallId() {
        return userWallRestaurantWallId;
    }

    public void setUserWallRestaurantWallId(int userWallRestaurantWallId) {
        this.userWallRestaurantWallId = userWallRestaurantWallId;
    }
}
