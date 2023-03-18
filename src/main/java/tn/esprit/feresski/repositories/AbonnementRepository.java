package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.feresski.entities.Abonnement;

public interface AbonnementRepository extends JpaRepository <Abonnement,Integer> {
}
