package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_userlocation", schema = "planrest")
public class UserUserlocation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private User userId;
    private Userlocation locationId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    public Userlocation getLocationId() {
        return locationId;
    }

    public void setLocationId(Userlocation userlocationByLocationId) {
        this.locationId = userlocationByLocationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserUserlocation that = (UserUserlocation) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (locationId != that.locationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId.getId();
        result = 31 * result + locationId.getId();
        return result;
    }


}
