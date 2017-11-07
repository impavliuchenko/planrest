package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_dialogue", schema = "planrest")
public class UserDialogue implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private User userId;
    private Dialogue dialogueId;

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
    @JoinColumn(name = "dialogue_id", referencedColumnName = "id", nullable = false)
    public Dialogue getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(Dialogue dialogueByDialogueId) {
        this.dialogueId = dialogueByDialogueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDialogue that = (UserDialogue) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (dialogueId != that.dialogueId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId.getId();
        result = 31 * result + dialogueId.getId();
        return result;
    }

}
