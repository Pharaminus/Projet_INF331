package com.studor.orientation_student.manager.controllers.establimentsuggestioncontroller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.manager.services.establishmentsuggestionservices.EstablishmentSuggestService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/establishment")
public class EstablishmentSuggestionRestController {

    @Autowired
    private EstablishmentSuggestService establishmentSuggestService;  

    @GetMapping("/suggested")
    public Map<String, Object> establishmentSuggested(HttpSession session) {
        return establishmentSuggestService.getEstablishmentOnJob(session);
    }
}
