package com.studor.orientation_student.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studor.orientation_student.entity.profilejobprediction.Profil;
import com.studor.orientation_student.manager.repository.ProfilRepository;

@Service
public class CrudService {
    
    @Autowired
    private ProfilRepository appRepo;

    // public void create(Profil profil){
    //     appRepo.save(profil);
    // }

    public List<Profil> read(){
        List<Profil> list = new ArrayList<>();
        appRepo.findAll().forEach(list::add);
        return list;
    }

    // public void update(Profil profil){
    //     appRepo.save(profil);
    // }

    // public void delete(long id){
    //     appRepo.deleteById(id);
    // }
}
