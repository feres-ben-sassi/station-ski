package tn.esprit.feresski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    Long numSkieur;
    String nomS;
    String prenomS;
    LocalDate dateNaissance;
    String ville;
//@JsonIgnore
@ManyToMany(mappedBy = "skieurs")
Set <Piste>pistes;

@OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement;
@OneToMany(mappedBy = "skieur" , fetch = FetchType.EAGER)
    Set<Inscription>inscriptions;

}
