package com.studor.orientation_student.entities.profilejobprediction;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class NotesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mention;
    private double moyenne;

    @OneToMany(mappedBy = "notesReport", cascade = CascadeType.ALL)
    // @JoinColumn(name = "notes")
    private List<Notes> notes;

    @OneToOne
    private Profil profil;

    public NotesReport(String mention, double moyenne, List<Notes> notes, Profil profil) {
        this.mention = mention;
        this.moyenne = moyenne;
        this.notes = notes;
        this.profil = profil;
    }

    public NotesReport(){}

    public Long getId() {
        return id;
    }
    
    public String getMention() {
        return this.mention;
    }
    public void setMention(String mention) {
        this.mention = mention;
    }

    public double getMoyenne() {
        return moyenne;
    }
    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
    
    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
    public List<Notes> getNotes() {
        return notes;
    }
    
    public Profil getProfil() {
        return profil;
    }
    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
