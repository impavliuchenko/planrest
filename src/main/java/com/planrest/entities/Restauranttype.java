package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Restauranttype implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String typeName;
    private Collection<RestaurantRestauranttype> restaurantRestaurantTypeById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "type_name", nullable = false, length = 255)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restauranttype that = (Restauranttype) o;

        if (id != that.id) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "restaurantTypeId")
    public Collection<RestaurantRestauranttype> getRestaurantRestaurantTypeById() {
        return restaurantRestaurantTypeById;
    }

    public void setRestaurantRestaurantTypeById(Collection<RestaurantRestauranttype> restaurantRestaurantTypeById) {
        this.restaurantRestaurantTypeById = restaurantRestaurantTypeById;
    }
}
