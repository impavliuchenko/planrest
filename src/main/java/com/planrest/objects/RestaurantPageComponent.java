package com.planrest.objects;

import com.planrest.entities.Restaurant;
import com.planrest.entities.Restaurantwall;
import com.planrest.entities.User;
import com.planrest.entities.UserwallRestaurantwall;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class RestaurantPageComponent implements Serializable{
    private static final long serialVersionUID = 1L;

    private User user;
    private Restaurant restaurant;
    private List<UserwallRestaurantwall> userwallRestaurantwalls;
    private Restaurantwall restaurantRepostingWall;
    private List<Restaurantwall> restaurantWalls;
    private String repostComment;
    private int restaurantWallId;

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

    public Restaurantwall getRestaurantRepostingWall() {
        return restaurantRepostingWall;
    }

    public void setRestaurantRepostingWall(Restaurantwall restaurantRepostingWall) {
        this.restaurantRepostingWall = restaurantRepostingWall;
    }

    public List<Restaurantwall> getRestaurantWalls() {
        return restaurantWalls;
    }

    public void setRestaurantWalls(List<Restaurantwall> restaurantWalls) {
        this.restaurantWalls = restaurantWalls;
    }

    public String getRepostComment() {
        return repostComment;
    }

    public void setRepostComment(String repostComment) {
        this.repostComment = repostComment;
    }

    public int getRestaurantWallId() {
        return restaurantWallId;
    }

    public void setRestaurantWallId(int restaurantWallId) {
        this.restaurantWallId = restaurantWallId;
    }
}
