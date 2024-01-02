package com.studor.orientation_student.manager.service.suggestionCour;

import java.util.List;

public class Vente {
    private String clientId;
    private List<String> produitsAchetes;
    public Vente(String clientId, List<String> produitsAchetes) {
        this.clientId = clientId;
        this.produitsAchetes = produitsAchetes;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public List<String> getProduitsAchetes() {
        return produitsAchetes;
    }
    public void setProduitsAchetes(List<String> produitsAchetes) {
        this.produitsAchetes = produitsAchetes;
    }

    // Getters, setters, constructeur
    
}
