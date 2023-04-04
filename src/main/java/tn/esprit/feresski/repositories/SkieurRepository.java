package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.feresski.entities.Skieur;
import tn.esprit.feresski.entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Integer> {

    Skieur findByNumSkieur (Long numSkieur);
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);

}
