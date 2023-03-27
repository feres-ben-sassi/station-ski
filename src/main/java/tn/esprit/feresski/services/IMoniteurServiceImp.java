package tn.esprit.feresski.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.feresski.entities.Cours;
import tn.esprit.feresski.entities.Moniteur;
import tn.esprit.feresski.repositories.CoursRepository;
import tn.esprit.feresski.repositories.MoniteurRepository;

import java.util.HashSet;

@Service
public class IMoniteurServiceImp implements IMoniteurService {
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    MoniteurRepository moniteurRepository ;
    @Transactional
    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, long numCourse){
        Cours cours = coursRepository.findByNumCours(numCourse) ;
        moniteurRepository.saveAndFlush(moniteur) ;
        if ( cours != null){
            if (moniteur.getCours()==null){
                moniteur.setCours(new HashSet<Cours>());
            }
            moniteur.getCours().add(cours);
        }
        return moniteur ;
    }
}