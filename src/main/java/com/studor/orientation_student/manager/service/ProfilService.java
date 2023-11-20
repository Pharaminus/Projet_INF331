package com.studor.orientation_student.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studor.orientation_student.entity.Profil;
import com.studor.orientation_student.manager.repository.ProfilRepository;

@Service
public class ProfilService {
    
    @Autowired
    private ProfilRepository profilRepo;

    public List<Profil> read(){
        List<Profil> list = new ArrayList<>();
        profilRepo.findAll().forEach(list::add);
        return list;
    }
}
