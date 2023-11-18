package com.studor.orientation_student.entity;

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
    
    public Matter(String nom, int coef, double notes, NotesReport notesReport) {
        this.nom = nom;
        this.coef = coef;
        this.notes = notes;
        this.notesReport = notesReport;
    }

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
}
