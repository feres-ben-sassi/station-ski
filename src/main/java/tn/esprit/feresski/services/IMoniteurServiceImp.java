package tn.esprit.feresski.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.feresski.entities.Cours;
import tn.esprit.feresski.entities.Inscription;
import tn.esprit.feresski.entities.Moniteur;
import tn.esprit.feresski.entities.Support;
import tn.esprit.feresski.repositories.CoursRepository;
import tn.esprit.feresski.repositories.MoniteurRepository;

import java.util.*;
import java.util.stream.Collectors;

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
    @Override
    public Map<Cours, List<Integer>> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        Moniteur mon = moniteurRepository.findByNumMoniteur(numInstructor);
        Set<Cours> lc=  mon.getCours();
        Map<Long,Integer> finallist = new HashMap<>();
        lc.forEach(cours -> {
            if (cours.getSupport() == support) {
//                Inscription si = cours.getInscriptions().stream().findAny().get();

                finallist.put(cours,
                     cours.getInscriptions()
                             .stream()
                             .map(Inscription::getNumSemaine)
                             .collect(Collectors.toList()
                             ));
            }
        });
        return finallist;
    }

    public Map<Cours, List<Integer>> numWeeksCourseOfInstructorBySupport2 (Long numInstructor, Support support) {
        return moniteurRepository.findByNumMoniteur(numInstructor).getCours()
                .stream()
                .filter(cours -> cours.getSupport()==support)
                .map(Cours::getInscriptions)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Inscription::getCours,
                        Collectors.mapping(Inscription::getNumSemaine,Collectors.toList())
                ));
    }
}