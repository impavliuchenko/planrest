package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String locationName;
    private Collection<Restaurant> restaurantsById;
    private Collection<User> usersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "location_name", nullable = false, length = 255)
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location that = (Location) o;

        if (id != that.id) return false;
        if (locationName != null ? !locationName.equals(that.locationName) : that.locationName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (locationName != null ? locationName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "locationId")
    public Collection<Restaurant> getRestaurantsById() {
        return restaurantsById;
    }

    public void setRestaurantsById(Collection<Restaurant> restaurantsById) {
        this.restaurantsById = restaurantsById;
    }

    @OneToMany(mappedBy = "locationId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
