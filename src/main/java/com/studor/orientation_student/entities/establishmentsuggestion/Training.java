package com.studor.orientation_student.entities.establishmentsuggestion;

import java.util.List;

import com.studor.orientation_student.entities.profilejobprediction.Job;
import com.studor.orientation_student.entities.profilejobprediction.Matter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int duree;
    private double cout;

    @ManyToMany
    private List<Establishment> establishments;

    @OneToOne(mappedBy = "training")
    private Job job;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Matter> matters;

    public Training(String nom, int duree, double cout, List<Establishment> establishments, Job job,
            List<Matter> matters) {
        this.nom = nom;
        this.duree = duree;
        this.cout = cout;
        this.establishments = establishments;
        this.job = job;
        this.matters = matters;
    }

    public Training() {
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public List<Matter> getMatters() {
        return matters;
    }

    public void setMatters(List<Matter> matters) {
        this.matters = matters;
    }

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
