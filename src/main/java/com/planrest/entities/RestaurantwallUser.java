package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userwall_user", schema = "planrest")
public class RestaurantwallUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Restaurantwall restaurantWallId;
    private User userId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_wall_id", referencedColumnName = "id", nullable = false)
    public Restaurantwall getRestaurantWallId() {
        return restaurantWallId;
    }

    public void setRestaurantWallId(Restaurantwall restaurantwallByRestaurantWallId) {
        this.restaurantWallId = restaurantwallByRestaurantWallId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userByUserId) {
        this.userId = userByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantwallUser that = (RestaurantwallUser) o;

        if (id != that.id) return false;
        if (restaurantWallId != that.restaurantWallId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + restaurantWallId.getId();
        result = 31 * result + userId.getId();
        return result;
    }

}
