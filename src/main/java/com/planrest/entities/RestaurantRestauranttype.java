package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "restaurant_restauranttype", schema = "planrest")
public class RestaurantRestauranttype implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private Restaurant restaurantId;
    private Restauranttype restaurantTypeId;

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

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public Restauranttype getRestaurantTypeId() {
        return restaurantTypeId;
    }

    public void setRestaurantTypeId(Restauranttype restaurantTypeId) {
        this.restaurantTypeId = restaurantTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantRestauranttype that = (RestaurantRestauranttype) o;

        if (id != that.id) return false;
        if (!restaurantId.equals(that.restaurantId)) return false;
        if (!restaurantTypeId.equals(that.restaurantTypeId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =  id;
        result = 31 * result + restaurantId.getId();
        result = 31 * result + restaurantTypeId.getId();
        return result;
    }
}
