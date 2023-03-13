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
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur ;
    private String nomS ;
    private String prenomS ;
    private String ville ;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;

    @OneToOne(cascade = CascadeType.ALL)

    private Abonnement abonnementSkieur;
    @OneToMany(cascade = CascadeType.ALL)

    private Set<Piste> pisteSet;

    @OneToMany(mappedBy = "skieur")
    Set<Inscription> inscriptions ;


}
