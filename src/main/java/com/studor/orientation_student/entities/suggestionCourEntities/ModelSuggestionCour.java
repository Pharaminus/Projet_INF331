package com.studor.orientation_student.entities.suggestionCourEntities;

import com.studor.orientation_student.entities.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ModelSuggestionCour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;
    private String StatuProfessionnel;
    private String moyenne;

    @OneToOne
    @JoinColumn(name = "nomEmploiTemps", referencedColumnName = "nomEmploiTemps")
    private EmploiTemps emploiTemps;

    public ModelSuggestionCour() {
    }

    public ModelSuggestionCour(String statuProfessionnel) {
        StatuProfessionnel = statuProfessionnel;
    }

    public Long getIdModel() {
        return idModel;
    }

    public void setIdModel(Long idModel) {
        this.idModel = idModel;
    }

    public String getStatuProfessionnel() {
        return StatuProfessionnel;
    }

    public void setStatuProfessionnel(String statuProfessionnel) {
        StatuProfessionnel = statuProfessionnel;
    }

    public EmploiTemps getEmploiTemps() {
        return emploiTemps;
    }

    public void setEmploiTemps(EmploiTemps emploiTemps) {
        this.emploiTemps = emploiTemps;
    }

    public String getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(String moyenne) {
        this.moyenne = moyenne;
    }
}
