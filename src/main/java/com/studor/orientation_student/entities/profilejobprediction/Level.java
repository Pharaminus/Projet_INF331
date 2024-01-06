package com.studor.orientation_student.entities.profilejobprediction;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Level {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    @ManyToOne
    private Option option;

    @OneToMany(mappedBy = "level")
    private List<Matter> matters;

    public Level(String code, Option option, List<Matter> matters) {
        this.code = code;
        this.option = option;
        this.matters = matters;
    }

    public Level() {
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public List<Matter> getMatters() {
        return matters;
    }

    public void setMatters(List<Matter> matters) {
        this.matters = matters;
    }
}
