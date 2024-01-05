package com.studor.orientation_student.entities.profilejobprediction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Notes 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double note;

    @ManyToOne
    private NotesReport notesReport;

    @ManyToOne
    private Matter matter;

    public Notes(double note, NotesReport notesReport, Matter matter) {
        this.note = note;
        this.notesReport = notesReport;
        this.matter = matter;
    }

    public Notes() {
    }

    public Long getId() {
        return id;
    }

    public double getNote() {
        return note;
    }
    public void setNote(double note) {
        this.note = note;
    }

    public NotesReport getNotesReport() {
        return notesReport;
    }
    public void setNotesReport(NotesReport notesReport) {
        this.notesReport = notesReport;
    }

    public Matter getMatter() {
        return matter;
    }
    public void setMatter(Matter matter) {
        this.matter = matter;
    }
}
