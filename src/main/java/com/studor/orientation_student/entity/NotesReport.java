package com.studor.orientation_student.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class NotesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mention;
    private String Type;
    private double moyenne;

    @OneToMany(mappedBy = "notesReport", cascade = CascadeType.ALL)
    // @JoinColumn(name = "matiere")
    private List<Matter> matiere;

    public NotesReport(){}
    public NotesReport(String mention, String Type, double moyenne, List<Matter> matiere) {
        this.mention = mention;
        this.Type = Type;
        this.moyenne = moyenne;
        this.matiere = matiere;
    }

    public double getNotes() {
        return this.moyenne;
    }

    public void setNotes(double moyenne) {
        this.moyenne = moyenne;
    }
    
    public String getMention() {
        return this.mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
}
