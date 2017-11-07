package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "restaurant_restaurantlocation", schema = "planrest")
public class RestaurantRestaurantlocation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Restaurant restaurantId;
    private Restaurantlocation restaurantLocationId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantId = restaurantByRestaurantId;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_location_id", referencedColumnName = "id", nullable = false)
    public Restaurantlocation getRestaurantLocationId() {
        return restaurantLocationId;
    }

    public void setRestaurantLocationId(Restaurantlocation restaurantlocationByRestaurantLocationId) {
        this.restaurantLocationId = restaurantlocationByRestaurantLocationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantRestaurantlocation that = (RestaurantRestaurantlocation) o;

        if (id != that.id) return false;
        if (restaurantId != that.restaurantId) return false;
        if (restaurantLocationId != that.restaurantLocationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + restaurantId.getId();
        result = 31 * result + restaurantLocationId.getId();
        return result;
    }

}
