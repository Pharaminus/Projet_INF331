// package com.studor.orientation_student.manager.repository;

package com.studor.orientation_student.manager.repositories.profilejobpredictrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.profilejobprediction.NotesReport;
import com.studor.orientation_student.entities.profilejobprediction.Profil;

import java.util.List;

@Repository
public interface NotesReportRepository extends JpaRepository<NotesReport, Long>{
    List<NotesReport> findByMention(String mention);
    List<NotesReport> findByMoyenne(double moyenne);
    List<NotesReport> findByProfil(Profil profil);
}
