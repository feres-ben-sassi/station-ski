package tn.esprit.feresski.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAbon ;
    private  int numSemaine;
    @Temporal(TemporalType.DATE)
    private Date dateDebut ;
    @Temporal(TemporalType.DATE)
    private Date dateFin ;
    private float prixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;
}
