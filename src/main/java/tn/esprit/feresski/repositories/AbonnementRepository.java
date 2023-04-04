package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.feresski.entities.Abonnement;
import tn.esprit.feresski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository <Abonnement,Integer> {
    Set<Abonnement> findAllByTypeAbon (TypeAbonnement typeAbonnement);
    List<Abonnement> findAllByDateDebutEqualsAndDateFinEquals(LocalDate startDate, LocalDate endDate);
}
