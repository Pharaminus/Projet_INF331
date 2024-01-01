package com.studor.orientation_student.manager.service.suggestionCour;

public class MyData {
    private String niveau;
    private String difficulte;
    private String nomNiveau;
    private String moyenne;
    public MyData() {
    }
    public MyData(String niveau, String difficulte, String nomNiveau, String moyenne) {
        this.niveau = niveau;
        this.difficulte = difficulte;
        this.nomNiveau = nomNiveau;
        this.moyenne = moyenne;
    }
    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public String getDifficulte() {
        return difficulte;
    }
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }
    public String getNomNiveau() {
        return nomNiveau;
    }
    public void setNomNiveau(String nomNiveau) {
        this.nomNiveau = nomNiveau;
    }
    public String getMoyenne() {
        return moyenne;
    }
    public void setMoyenne(String moyenne) {
        this.moyenne = moyenne;
    }

    
}
