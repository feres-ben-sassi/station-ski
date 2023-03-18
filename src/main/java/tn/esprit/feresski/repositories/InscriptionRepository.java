package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.feresski.entities.Inscription;

public interface InscriptionRepository extends JpaRepository <Inscription,Integer> {
}
