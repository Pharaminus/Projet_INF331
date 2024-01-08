package com.studor.orientation_student.entities.suggestionCourEntities.profilejobprediction;

import com.studor.orientation_student.entities.suggestionCourEntities.ObjectifUtilisateur;
import com.studor.orientation_student.entities.suggestionCourEntities.Programme;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nom;
    private String motDePasse;
    
    @OneToOne
    @JoinColumn(name = "idObjectif", referencedColumnName = "idObjectif")
    private ObjectifUtilisateur objectifUtilisateur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profil_id")
    private Profil profil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProgramme")
    private Programme programme;
    
    
    public User() {
    }

    
    public User(String email, String nom, String motDePasse, Profil profil) {
        this.email = email;
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.profil = profil;
    }

        public ObjectifUtilisateur getObjectifUtilisateur() {
            return objectifUtilisateur;
        }

        public void setObjectifUtilisateur(ObjectifUtilisateur objectifUtilisateur) {
            this.objectifUtilisateur = objectifUtilisateur;
        }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }
}
