package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Restaurantwall implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String date;
    private String comment;
    private byte[] image;
    private Restaurant restaurantId;
    private Collection<UserwallRestaurantwall> userwallRestaurantwallsById;
    private Collection<RestaurantwallUser> restaurantwallUsersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "date", nullable = false, length = 255)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

        Restaurantwall that = (Restaurantwall) o;

        if (id != that.id) return false;
        if (restaurantId != that.restaurantId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (!Arrays.equals(image, that.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + restaurantId.getId();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }


    @OneToMany(mappedBy = "restaurantWallId")
    public Collection<UserwallRestaurantwall> getUserwallRestaurantwallsById() {
        return userwallRestaurantwallsById;
    }

    public void setUserwallRestaurantwallsById(Collection<UserwallRestaurantwall> userwallRestaurantwallsById) {
        this.userwallRestaurantwallsById = userwallRestaurantwallsById;
    }

    @OneToMany(mappedBy = "restaurantWallId")
    public Collection<RestaurantwallUser> getRestaurantwallUsersById() {
        return restaurantwallUsersById;
    }

    public void setRestaurantwallUsersById(Collection<RestaurantwallUser> restaurantwallUsersById) {
        this.restaurantwallUsersById = restaurantwallUsersById;
    }
}
