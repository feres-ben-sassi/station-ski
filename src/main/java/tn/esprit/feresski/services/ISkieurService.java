package tn.esprit.feresski.services;

import tn.esprit.feresski.entities.Skieur;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Integer numSkieur);
    Skieur retrieveSkieur (Integer numSkieur);
    Skieur updateSkieur (Skieur skieur);

}
