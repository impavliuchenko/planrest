package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Restaurantaddress implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String addressName;
    private Restaurantlocation restaurantLocationId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "address_name", nullable = false, length = 255)
    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
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

        Restaurantaddress that = (Restaurantaddress) o;

        if (id != that.id) return false;
        if (restaurantLocationId != that.restaurantLocationId) return false;
        if (addressName != null ? !addressName.equals(that.addressName) : that.addressName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + restaurantLocationId.getId();
        result = 31 * result + (addressName != null ? addressName.hashCode() : 0);
        return result;
    }

}
