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
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours ;
    private int niveau ;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    private Support support;
    private  float prix;
    private  int creneau;


}
