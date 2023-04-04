package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.feresski.entities.Cours;

public interface CoursRepository extends JpaRepository <Cours,Integer> {

     Cours findByNumCours(Long numCours);

     @Query("select c from Cours c order by c.Inscriptions.size ")
     Cours getCoursByNumberInscriptionJPQL (Long numCours);
}
