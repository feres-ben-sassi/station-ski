package tn.esprit.feresski.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    long numPiste;
    String nomPiste;
    @Enumerated(EnumType.STRING)
    Couleur couleur;
    int longeur;
    int pente;
    @ManyToMany
    Set<Skieur> skieurs;
}
