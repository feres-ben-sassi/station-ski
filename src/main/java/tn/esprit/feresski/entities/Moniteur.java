package tn.esprit.feresski.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    Long numMoniteur;
    String nomM;
    String prenomM;
    LocalDate dateRecru;
    @OneToMany
    Set<Cours> cours;
}
