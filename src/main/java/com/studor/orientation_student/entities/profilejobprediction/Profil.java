package com.studor.orientation_student.entities.profilejobprediction;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

import com.studor.orientation_student.entities.establishmentsuggestion.Establishment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profil")
public class Profil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String sexe;
    private String loisirs;
    private String metierDuPere;
    private String metierDeLaMere;
    private String religion;
    private String sport;

    @Lob
    private Blob photoProfile;

    @ManyToOne
    private Job job;

    @OneToOne(mappedBy = "profil")
    private NotesReport notesReport;

    @OneToOne(mappedBy = "profil")
    private User user;

    @OneToMany(mappedBy = "profil")
    private List<Establishment> establishments;

    public Profil(String nom, String prenom, LocalDate dateDeNaissance, String sexe, String loisirs,
            String metierDuPere, String metierDeLaMere, String religion, String sport, Blob photoProfile, Job job,
            NotesReport notesReport, User user, List<Establishment> establishments) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.loisirs = loisirs;
        this.metierDuPere = metierDuPere;
        this.metierDeLaMere = metierDeLaMere;
        this.religion = religion;
        this.sport = sport;
        this.photoProfile = photoProfile;
        this.job = job;
        this.notesReport = notesReport;
        this.user = user;
        this.establishments = establishments;
    }

    public Profil() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getLoisirs() {
        return loisirs;
    }

    public void setLoisirs(String loisirs) {
        this.loisirs = loisirs;
    }

    public String getMetierDuPere() {
        return metierDuPere;
    }

    public void setMetierDuPere(String metierDuPere) {
        this.metierDuPere = metierDuPere;
    }

    public String getMetierDeLaMere() {
        return metierDeLaMere;
    }

    public void setMetierDeLaMere(String metierDeLaMere) {
        this.metierDeLaMere = metierDeLaMere;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Blob getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(Blob photoProfile) {
        this.photoProfile = photoProfile;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public NotesReport getNotesReport() {
        return notesReport;
    }

    public void setNotesReport(NotesReport notesReport) {
        this.notesReport = notesReport;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }
}
