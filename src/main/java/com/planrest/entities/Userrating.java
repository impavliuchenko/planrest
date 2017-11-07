package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Userrating implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int rating;
    private User userReceivingId;
    private User userSendingId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @ManyToOne
    @JoinColumn(name = "user_receiving_id", referencedColumnName = "id", nullable = false)
    public User getUserReceivingId() {
        return userReceivingId;
    }

    public void setUserReceivingId(User userByUserReceivingId) {
        this.userReceivingId = userByUserReceivingId;
    }

    @ManyToOne
    @JoinColumn(name = "user_sending_id", referencedColumnName = "id", nullable = false)
    public User getUserSendingId() {
        return userSendingId;
    }

    public void setUserSendingId(User userByUserSendingId) {
        this.userSendingId = userByUserSendingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userrating that = (Userrating) o;

        if (id != that.id) return false;
        if (userReceivingId != that.userReceivingId) return false;
        if (userSendingId != that.userSendingId) return false;
        if (rating != that.rating) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userReceivingId.getId();
        result = 31 * result + userSendingId.getId();
        result = 31 * result + rating;
        return result;
    }

}
