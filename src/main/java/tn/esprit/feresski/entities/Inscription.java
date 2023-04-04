package tn.esprit.feresski.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
