package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Friend implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int status;
    private int userId;
    private User friendId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userByUserId) {
        this.userId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "id", nullable = false)
    public User getFriendId() {
        return friendId;
    }

    public void setFriendId(User userByFriendId) {
        this.friendId = userByFriendId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (id != friend.id) return false;
        if (userId != friend.userId) return false;
        if (friendId != friend.friendId) return false;
        if (status != friend.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + friendId.getId();
        result = 31 * result + status;
        return result;
    }

}
