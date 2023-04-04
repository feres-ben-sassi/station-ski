package tn.esprit.feresski.services;

import tn.esprit.feresski.entities.Cours;
import tn.esprit.feresski.entities.Moniteur;
import tn.esprit.feresski.entities.Support;

import java.util.List;
import java.util.Map;

public interface IMoniteurService {

     Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, long numCourse) ;
     Map<Cours, List<Integer>> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
