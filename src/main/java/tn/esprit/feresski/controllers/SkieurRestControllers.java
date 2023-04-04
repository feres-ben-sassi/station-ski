package tn.esprit.feresski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.feresski.entities.Skieur;
import tn.esprit.feresski.entities.TypeAbonnement;
import tn.esprit.feresski.services.ISkieurService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/skieur")
public class SkieurRestControllers {
//    @Autowired
private final ISkieurService iSkieurService;
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
    @PutMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable int numSkieur, @PathVariable int numPiste){
        return iSkieurService.assignSkierToPiste(numSkieur,numPiste);}
    @GetMapping("/abonnement/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return iSkieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }

    }
