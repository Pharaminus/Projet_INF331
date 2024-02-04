package com.studor.orientation_student.entities.profilejobprediction;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

import com.studor.orientation_student.entities.establishmentsuggestion.Establishment;
import com.studor.orientation_student.entities.suggestionCourEntities.NiveauAcademique;
import com.studor.orientation_student.entities.suggestionCourEntities.ObjectifUtilisateur;
import com.studor.orientation_student.entities.suggestionCourEntities.Programme;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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

    @OneToMany(mappedBy = "profil")
    private List<NotesReport> notesReports;

    @OneToOne(mappedBy = "profil")
    private User user;

    @ManyToMany
    private List<Establishment> establishments;

    @OneToMany(mappedBy = "profil", cascade = CascadeType.ALL)
    private List<Programme> programmes;

    @OneToOne
    @JoinColumn(name = "idObjectif", referencedColumnName = "idObjectif")
    private ObjectifUtilisateur objectifProfil;

    @OneToMany(mappedBy = "profil")
    private List<NiveauAcademique> niveauAcademiques;

    public Profil(String nom, String prenom, LocalDate dateDeNaissance, String sexe, String loisirs,
            String metierDuPere, String metierDeLaMere, String religion, String sport, Blob photoProfile, Job job,
            List<NotesReport> notesReports, User user, List<Establishment> establishments, List<Programme> programmes,
            ObjectifUtilisateur objectifProfil, List<NiveauAcademique> niveauAcademiques) {
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
        this.notesReports = notesReports;
        this.user = user;
        this.establishments = establishments;
        this.programmes = programmes;
        this.objectifProfil = objectifProfil;
        this.niveauAcademiques = niveauAcademiques;
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

    public ObjectifUtilisateur getObjectifUtilisateur() {
        return objectifProfil;
    }

    public void setObjectifUtilisateur(ObjectifUtilisateur objectifProfil) {
        this.objectifProfil = objectifProfil;
    }

    public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

    public ObjectifUtilisateur getObjectifProfil() {
        return objectifProfil;
    }

    public void setObjectifProfil(ObjectifUtilisateur objectifProfil) {
        this.objectifProfil = objectifProfil;
    }

    public List<NiveauAcademique> getNiveauAcademiques() {
        return niveauAcademiques;
    }

    public void setNiveauAcademiques(List<NiveauAcademique> niveauAcademiques) {
        this.niveauAcademiques = niveauAcademiques;
    }

    public List<NotesReport> getNotesReports() {
        return notesReports;
    }

    public void setNotesReports(List<NotesReport> notesReports) {
        this.notesReports = notesReports;
    }
}
