package com.studor.orientation_student.entities;

import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.studor.orientation_student.entities.suggestionCourEntities.Discipline;
import com.studor.orientation_student.entities.suggestionCourEntities.NiveauAcademique;
import com.studor.orientation_student.entities.suggestionCourEntities.ObjectifUtilisateur;
import com.studor.orientation_student.entities.suggestionCourEntities.Programme;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String motDePasse;
    private String email;
    private String nom;
    private String prenom;
   
    
    @ManyToOne
    @JoinColumn(name = "profil_id")
    private Profil profil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProgramme")
    private Programme programme;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idNiveau")
    private NiveauAcademique niveauAcademique;

    @OneToOne
    @JoinColumn(name = "idObjectif", referencedColumnName = "idObjectif")
    private ObjectifUtilisateur objectifUtilisateur;

    




    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public NiveauAcademique getNiveauAcademique() {
        return niveauAcademique;
    }

    public void setNiveauAcademique(NiveauAcademique niveauAcademique) {
        this.niveauAcademique = niveauAcademique;
    }

    public ObjectifUtilisateur getObjectifUtilisateur() {
        return objectifUtilisateur;
    }

    public void setObjectifUtilisateur(ObjectifUtilisateur objectifUtilisateur) {
        this.objectifUtilisateur = objectifUtilisateur;
    }

    public User() {
    }

    public User(String email, String nom, String prenom, String motDePasse) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
    
}
