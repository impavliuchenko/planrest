package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Userwall implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String date;
    private String comment;
    private byte[] image;
    private User userId;
    private Restaurantwall restaurantWallId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "comment", nullable = true, length = 255)
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
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userByUserId) {
        this.userId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_wall_id", referencedColumnName = "id", nullable = false)
    public Restaurantwall getRestaurantWallId() {
        return restaurantWallId;
    }

    public void setRestaurantWallId(Restaurantwall restaurantWallId) {
        this.restaurantWallId = restaurantWallId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userwall userwall = (Userwall) o;

        if (id != userwall.id) return false;
        if (userId != userwall.userId) return false;
        if (date != null ? !date.equals(userwall.date) : userwall.date != null) return false;
        if (comment != null ? !comment.equals(userwall.comment) : userwall.comment != null) return false;
        if (!Arrays.equals(image, userwall.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId.getId();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

}
