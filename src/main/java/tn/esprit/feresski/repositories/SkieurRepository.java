package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.feresski.entities.Skieur;

public interface SkieurRepository extends JpaRepository<Skieur,Integer> {

    Skieur findByNumSkieur (Long numSkieur);

}
