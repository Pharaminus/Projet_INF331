package com.studor.orientation_student.entity.profilejobprediction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Matter 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int coef;
    private double notes;

    @ManyToOne
    private NotesReport notesReport;

    public double getNotes() {
        return notes;
    }

    public void setNotes(double notes) {
        this.notes = notes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public NotesReport getNotesReport() {
        return notesReport;
    }

    public void setNotesReport(NotesReport notesReport) {
        this.notesReport = notesReport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
