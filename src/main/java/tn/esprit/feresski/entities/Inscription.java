package tn.esprit.feresski.entities;

import javax.persistence.*;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    Long numInscription;
    int numSemaine;
    @ManyToOne
    Skieur skieur;
    @ManyToOne
    Cours cours;
}
