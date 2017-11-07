package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Restaurantrating implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int rating;
    private User userId;
    private Restaurant restaurantId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userByUserId) {
        this.userId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantId = restaurantByRestaurantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurantrating that = (Restaurantrating) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (restaurantId != that.restaurantId) return false;
        if (rating != that.rating) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId.getId();
        result = 31 * result + restaurantId.getId();
        result = 31 * result + rating;
        return result;
    }

}
