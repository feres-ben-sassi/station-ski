package tn.esprit.feresski.services;

import tn.esprit.feresski.entities.Skieur;
import tn.esprit.feresski.entities.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Integer numSkieur);

//    Skieur assignSkieurToPiste(int numSkieur, int numPiste);

    Skieur retrieveSkieur (Integer numSkieur);
    Skieur updateSkieur (Skieur skieur);
    Skieur assignSkierToPiste(int numSkieur, int numPiste);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);


}
