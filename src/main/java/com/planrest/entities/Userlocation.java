package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Userlocation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String locationName;
    private Collection<UserUserlocation> userUserlocationsById;

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

        Userlocation that = (Userlocation) o;

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
    public Collection<UserUserlocation> getUserUserlocationsById() {
        return userUserlocationsById;
    }

    public void setUserUserlocationsById(Collection<UserUserlocation> userUserlocationsById) {
        this.userUserlocationsById = userUserlocationsById;
    }
}
