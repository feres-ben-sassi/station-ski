package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.feresski.entities.Cours;

public interface CoursRepository extends JpaRepository <Cours,Integer> {

     Cours findByNumCours(Long numCours);
}
