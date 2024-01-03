package com.studor.orientation_student.manager.controller.nouriture;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.nutrition.Repas;
import com.studor.orientation_student.manager.repository.nutrition.RepasRepository;

@RestController
@RequestMapping("/repas")
public class RepasController {

    private final RepasRepository repasRepository;

    public RepasController(RepasRepository repasRepository) {
        this.repasRepository = repasRepository;
    }

    @GetMapping("/{nom}")
    public ResponseEntity<List<Repas>> getRepasByNom(@PathVariable String nom) {
        List<Repas> repasList = repasRepository.findByNom(nom);
        if (repasList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(repasList, HttpStatus.OK);
    }

    @GetMapping("/recherche")
    public ResponseEntity<List<Repas>> getRepasByNomAndPrix(@RequestParam String nom, @RequestParam double prix) {
        List<Repas> repasList = repasRepository.findByNomAndPrix(nom, prix);
        if (repasList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(repasList, HttpStatus.OK);
    }

    @GetMapping("/prix/{prix}")
    public ResponseEntity<List<Repas>> getRepasByPrix(@PathVariable double prix) {
        List<Repas> repasList = repasRepository.findByPrix(prix);
        if (repasList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(repasList, HttpStatus.OK);
    }

    // Operation de CRUD sur la classe repas 

    @PostMapping
    public ResponseEntity<Repas> createRepas(@RequestBody Repas repas) {
        Repas nouveauRepas = repasRepository.save(repas);
        return ResponseEntity.ok(nouveauRepas);
    }

    // @GetMapping("/{nom}")
    // public ResponseEntity<List<Repas>> getRepasByNom(@PathVariable String nom) {
    //     List<Repas> repasList = repasRepository.findByNom(nom);
    //     if (!repasList.isEmpty()) {
    //         return ResponseEntity.ok(repasList);
    //     }
    //     return ResponseEntity.notFound().build();
    // }

    @PutMapping("/{nom}")
    public ResponseEntity<Repas> updateRepas(@PathVariable String nom, @RequestBody Repas repas) {
        List<Repas> repasList = repasRepository.findByNom(nom);
        if (!repasList.isEmpty()) {
            Repas repasExistant = repasList.get(0); 
            repasExistant.setNom(repas.getNom());
            repasExistant.setConstituant(repas.getConstituant());
            repasExistant.setDescription(repas.getDescription());
            repasExistant.setApportEnergetique(repas.getApportEnergetique());
            repasExistant.setPrix(repas.getPrix());
            Repas repasMiseAJour = repasRepository.save(repasExistant);
            return ResponseEntity.ok(repasMiseAJour);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{nom}")
    public ResponseEntity<Void> deleteRepas(@PathVariable String nom) {
        List<Repas> repasList = repasRepository.findByNom(nom);
        if (!repasList.isEmpty()) {
            Repas repas = repasList.get(0); 
            repasRepository.delete(repas);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
