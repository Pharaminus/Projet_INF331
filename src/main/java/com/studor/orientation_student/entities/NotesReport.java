package com.studor.orientation_student.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class NotesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mention;
    private String type;
    private float notes;

    @ManyToOne
    @JoinColumn(name = "matiere")
    private Matter matiere;
    // @OneToMany(mappedBy = "notesReport", cascade = CascadeType.ALL)
    // private List<Matter> matters;

    public float getNotes() {
        return notes;
    }

    public void setNotes(float notes) {
        this.notes = notes;
    }
    
    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
