package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Dialogue implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private User userCompanionId;
    private User userId;
    private Collection<Message> messagesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_companion_id", referencedColumnName = "id", nullable = false)
    public User getUserCompanionId() {
        return userCompanionId;
    }

    public void setUserCompanionId(User userByUserCompanionId) {
        this.userCompanionId = userByUserCompanionId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @OneToMany(mappedBy = "dialogueId")
    public Collection<Message> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<Message> messagesById) {
        this.messagesById = messagesById;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dialogue dialogue = (Dialogue) o;

        if (id != dialogue.id) return false;
        if (userCompanionId != dialogue.userCompanionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userCompanionId.getId();
        return result;
    }

}
