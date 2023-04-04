package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.feresski.entities.Moniteur;
import tn.esprit.feresski.entities.Support;

public interface MoniteurRepository extends JpaRepository<Moniteur,Integer> {
    Moniteur findByNumMoniteur(Long numMoniteur);
   @Query("select m from Moniteur m where m.numMoniteur = ?1 and m.nomM = ?2 ")
    Moniteur findByNumMoniteurJPQL(Long numMoniteur, String nomM);
    @Query("select m from Moniteur m where m.numMoniteur = :numMoniteur and m.nomM = :nomM ")
    Moniteur findByNumMoniteurJPQL2(@Param("numMoniteur") Long numMoniteur, @Param("numM") String nomM);
    @Query(value = "select m from Moniteur m where m.numMoniteur = :numMoniteur and m.nomM = :nomM ", nativeQuery = true)
    Moniteur findByNumMoniteurSQL(@Param("numMoniteur") Long numMoniteur, @Param("numM") String nomM);

    @Query("select i.numSemaine  from Inscription i join Moniteur  m on where i.cours m.cours where ")
    Moniteur findByNumMoniteurJPQL3(@Param("support") Support support);

}
