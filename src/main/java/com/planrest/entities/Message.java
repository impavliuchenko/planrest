package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
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

        Message message = (Message) o;

        if (id != message.id) return false;
        if (dialogueId != message.dialogueId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + dialogueId.getId();
        return result;
    }

}
