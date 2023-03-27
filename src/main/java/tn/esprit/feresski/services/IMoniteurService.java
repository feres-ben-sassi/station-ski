package tn.esprit.feresski.services;

import tn.esprit.feresski.entities.Moniteur;

public interface IMoniteurService {

     Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, long numCourse) ;
}
