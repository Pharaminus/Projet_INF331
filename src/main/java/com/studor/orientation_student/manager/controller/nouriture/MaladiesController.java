package com.studor.orientation_student.manager.controller.nouriture;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.nutrition.Maladies;
import com.studor.orientation_student.entities.nutrition.Repas;
import com.studor.orientation_student.manager.repository.nutrition.MaladiesRepository;
import com.studor.orientation_student.manager.service.nouriture.MaladiesService;

@RestController
@RequestMapping("/maladies")
public class MaladiesController {

    private final MaladiesService maladieService;
    private final MaladiesRepository maladiesRepository;

    public MaladiesController(MaladiesService maladieService, MaladiesRepository maladiesRepository) {
        this.maladieService = maladieService;
        this.maladiesRepository = maladiesRepository;
    }

    @PostMapping("/predictMaladie")
    public ResponseEntity<String> predictMaladies(@RequestBody List<Repas> repasConsommes) {
        String maladie = maladieService.predictMaladies(repasConsommes);
        return new ResponseEntity<>(maladie, HttpStatus.OK);
    }

    @GetMapping("/{nomMaladie}/medicaments")
    public ResponseEntity<String> getMedicamentsByMaladie(@PathVariable String nomMaladie) {
        Optional<Maladies> maladieOptional = maladiesRepository.findByNom(nomMaladie);
        if (maladieOptional.isPresent()) {
            Maladies maladie = maladieOptional.get();
            String medicaments = maladie.getMedicament();
            return ResponseEntity.ok(medicaments);
        }
        return ResponseEntity.notFound().build();
    }
    // Operation de CRUD sur une maladie Administrateur

    @PostMapping
    public ResponseEntity<Maladies> createMaladie(@RequestBody Maladies maladie) {
        Maladies nouvelleMaladie = maladiesRepository.save(maladie);
        return ResponseEntity.ok(nouvelleMaladie);
    }

    @GetMapping("/{nom}")
    public ResponseEntity<Maladies> getMaladie(@PathVariable String nom) {
        Optional<Maladies> maladieOptional = maladiesRepository.findByNom(nom);
        if (maladieOptional.isPresent()) {
            Maladies maladie = maladieOptional.get();
            return ResponseEntity.ok(maladie);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("modification/{nom}")
    public ResponseEntity<Maladies> updateMaladie(@PathVariable String nom, @RequestBody Maladies maladie) {
        if (!maladiesRepository.existsByNom(nom)) {
            return ResponseEntity.notFound().build();
        }
        maladie.setNom(nom);
        Maladies maladieMiseAJour = maladiesRepository.save(maladie);
        return ResponseEntity.ok(maladieMiseAJour);
    }

    @DeleteMapping("/{nom}")
    public ResponseEntity<Void> deleteMaladie(@PathVariable String nom) {
        if (!maladiesRepository.existsByNom(nom)) {
            return ResponseEntity.notFound().build();
        }
        maladiesRepository.deleteByNom(nom);
        return ResponseEntity.noContent().build();
    }
}
