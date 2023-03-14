package tn.esprit.feresski.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    Long numCours;
    int niveau;
    Float prix;
    int creneau;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours;
    @Enumerated(EnumType.STRING)
    Support support;
    @OneToMany(mappedBy = "cours")
    Set<Inscription> Inscriptions;

}
