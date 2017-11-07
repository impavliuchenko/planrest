package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role", schema = "planrest")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private User userId;
    private Role roleId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userByUserId) {
        this.userId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleByRoleId) {
        this.roleId = roleByRoleId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (id != userRole.id) return false;
        if (userId != userRole.userId) return false;
        if (roleId != userRole.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId.getId();
        result = 31 * result + roleId.getId();
        return result;
    }
}
