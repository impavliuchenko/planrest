package com.planrest.services;

import com.planrest.entities.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class UserService implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;

    private Restaurant restaurant;

    private List<UserwallRestaurantwall> userwallRestaurantwall;

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

    public List<UserwallRestaurantwall> getUserwallRestaurantwall() {
        return userwallRestaurantwall;
    }

    public void setUserwallRestaurantwall(List<UserwallRestaurantwall> userwallRestaurantwall) {
        this.userwallRestaurantwall = userwallRestaurantwall;
    }
}
