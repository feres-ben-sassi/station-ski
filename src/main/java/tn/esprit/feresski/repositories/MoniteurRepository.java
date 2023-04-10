package tn.esprit.feresski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.feresski.entities.Moniteur;
import tn.esprit.feresski.entities.Skieur;
import tn.esprit.feresski.entities.Support;

import java.util.List;

public interface MoniteurRepository extends JpaRepository<Moniteur,Integer> {
    Moniteur findByNumMoniteur(Long numMoniteur);
   @Query("select m from Moniteur m where m.numMoniteur = ?1 and m.nomM = ?2 ")
    Moniteur findByNumMoniteurJPQL(Long numMoniteur, String nomM);
    @Query("select m from Moniteur m where m.numMoniteur = :numMoniteur and m.nomM = :nomM ")
    Moniteur findByNumMoniteurJPQL2(@Param("numMoniteur") Long numMoniteur, @Param("numM") String nomM);
    @Query(value = "select m from Moniteur m where m.numMoniteur = :numMoniteur and m.nomM = :nomM ", nativeQuery = true)
    Moniteur findByNumMoniteurSQL(@Param("numMoniteur") Long numMoniteur, @Param("numM") String nomM);

//    @Query("select i.numSemaine  from Inscription i join Moniteur  m on where i.cours = m.cours where ")
//    Moniteur findByNumMoniteurJPQL3(@Param("support") Support support);
    @Query(value = "SELECT * from moniteur m ORDER BY (SELECT count(*) from moniteur_cours mc where mc.moniteur_id = m.id )", nativeQuery = true)
    List<Moniteur> findAllOrderByCoursNumberSQL();
    @Query("SELECT m from Moniteur m ORDER BY m.cours.size ")
    List<Moniteur> findAllOrderByCoursNumberJPQL();
    @Query(value = "SELECT *" +
            "        FROM skieur s" +
            "        join inscription i on i.skieur_id = s.id" +
            "        join cours c on c.id = i.cours_id" +
            "        JOIN moniteur_cours mc on mc.cours_id = c.id" +
            "        JOIN moniteur m on mc.moniteur_id = m.id" +
            "        WHERE m.nomm = :nomN and  c.support = :support ",nativeQuery = true)
    List<Skieur> findSkieurByMoniteurCoursSupportSQL(@Param("nomM") String nomM ,@Param("support") Enum support );
    @Query("SELECT s" +
            "        FROM Skieur s" +
            "        join Inscription i on i.skieur = s" +
            "        JOIN Moniteur m on i.cours member of m.cours" +
            "        WHERE m.nomM = :nomM and  i.cours.support = :support ")
    List<Skieur> findSkieurByMoniteurCoursSupportJPQL(@Param("nomM") String nomM ,@Param("support") Enum support );
}
