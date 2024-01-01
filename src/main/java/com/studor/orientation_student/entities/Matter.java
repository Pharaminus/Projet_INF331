package com.studor.orientation_student.entities;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int coef;

    // @OneToMany
    // @JoinColumn(name = "noteReport")
    // private NotesReport notesReport;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    private List<NotesReport> notesReports;

    public String getNom() {
        return nom;
    }

    public Matter(String nom, int coef, List<NotesReport> notesReports) {
        this.nom = nom;
        this.coef = coef;
        this.notesReports = notesReports;
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
