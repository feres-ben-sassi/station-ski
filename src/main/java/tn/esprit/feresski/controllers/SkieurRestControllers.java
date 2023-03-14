package tn.esprit.feresski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.feresski.entities.Skieur;
import tn.esprit.feresski.services.ISkieurService;
@RestController
@RequestMapping("/skieur")
public class SkieurRestControllers {
    @Autowired
    ISkieurService iSkieurService;
    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur){
        return iSkieurService.addSkieur(skieur);
    }
    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return iSkieurService.updateSkieur(skieur);
    }

        @GetMapping("/{numSkieur}")
    public Skieur retrieveSkieur(@PathVariable Integer numSkieur) {
        return iSkieurService.retrieveSkieur(numSkieur);
    }
}
