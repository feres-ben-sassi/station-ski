package tn.esprit.feresski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.feresski.entities.Moniteur;
import tn.esprit.feresski.services.IMoniteurService;

@RestController
public class MoniteurRestControllers {
    @Autowired
    IMoniteurService iMoniteurService ;
    @PostMapping("/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse (@RequestBody Moniteur moniteur, @PathVariable long numCourse){
        return iMoniteurService.addInstructorAndAssignToCourse(moniteur,numCourse) ;
    }
}
