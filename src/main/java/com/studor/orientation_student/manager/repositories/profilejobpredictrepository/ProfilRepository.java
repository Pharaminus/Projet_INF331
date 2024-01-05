package com.studor.orientation_student.manager.repositories.profilejobpredictrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.profilejobprediction.Jobs;
import com.studor.orientation_student.entities.profilejobprediction.NotesReport;
import com.studor.orientation_student.entities.profilejobprediction.Profil;
import com.studor.orientation_student.entities.profilejobprediction.User;

import java.time.LocalDate;
import java.sql.Blob;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long>{
    List<Profil> findByDateDeNaissance(LocalDate dateDeNaissance);
    List<Profil> findByJobs(Jobs jobs);
    List<Profil> findByLoisirs(String loisirs);
    List<Profil> findByNom(String nom);
    List<Profil> findByPhotoProfile(Blob photoProfile);
    Profil findByNotesReport(NotesReport notesReport);
    List<Profil> findByReligion(String religion);
    Profil findByUser(User user);
}
