package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userwall_restaurantwall", schema = "planrest")
public class UserwallRestaurantwall implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Userwall userWallId;
    private Restaurantwall restaurantWallId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne
    @JoinColumn(name = "user_wall_id", referencedColumnName = "id", nullable = false)
    public Userwall getUserWallId() {
        return userWallId;
    }

    public void setUserWallId(Userwall userwallByUserWallId) {
        this.userWallId = userwallByUserWallId;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_wall_id", referencedColumnName = "id", nullable = false)
    public Restaurantwall getRestaurantWallId() {
        return restaurantWallId;
    }

    public void setRestaurantWallId(Restaurantwall restaurantwallByRestaurantWallId) {
        this.restaurantWallId = restaurantwallByRestaurantWallId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserwallRestaurantwall that = (UserwallRestaurantwall) o;

        if (id != that.id) return false;
        if (userWallId != that.userWallId) return false;
        if (restaurantWallId != that.restaurantWallId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userWallId.getId();
        result = 31 * result + restaurantWallId.getId();
        return result;
    }

}
