package tn.esprit.feresski.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste ;
    private String nomPiste;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private  int longueur;
    private  int pente;
    @OneToMany(mappedBy = "Skieur")

    private Set<Skieur> skieurSet;

}
