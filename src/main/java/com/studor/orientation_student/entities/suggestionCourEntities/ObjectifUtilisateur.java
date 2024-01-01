package com.studor.orientation_student.entities.suggestionCourEntities;

import com.studor.orientation_student.entities.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity

public class ObjectifUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjectif;
    private String difficulte;
    private Double moyenne;
    private String statuVise;
    private String description;


    @OneToOne(mappedBy = "objectifUtilisateur", cascade = CascadeType.ALL)
    private User user;

    
    public ObjectifUtilisateur() {
    }


    public ObjectifUtilisateur(String difficulte, Double moyenne, String statuVise, String description) {
        this.difficulte = difficulte;
        this.moyenne = moyenne;
        this.statuVise = statuVise;
        this.description = description;
    }


    public Long getIdObjectif() {
        return idObjectif;
    }


    public void setIdObjectif(Long idObjectif) {
        this.idObjectif = idObjectif;
    }


    public String getDifficulte() {
        return difficulte;
    }


    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }


    public Double getMoyenne() {
        return moyenne;
    }


    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }


    public String getStatuVise() {
        return statuVise;
    }


    public void setStatuVise(String statuVise) {
        this.statuVise = statuVise;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


   

    
}