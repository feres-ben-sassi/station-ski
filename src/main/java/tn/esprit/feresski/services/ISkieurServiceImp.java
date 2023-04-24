package tn.esprit.feresski.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.feresski.entities.Piste;
import tn.esprit.feresski.entities.Skieur;
import tn.esprit.feresski.entities.TypeAbonnement;
import tn.esprit.feresski.repositories.PisteRepository;
import tn.esprit.feresski.repositories.SkieurRepository;

import java.util.List;
// cette annotation "Service" permet de creer une instance ( Java Bean / Spring Bean )
// dans le contexte/container Spring Container


@Slf4j
// THIS ANNOTATION Create Log
@RequiredArgsConstructor
@Service
public class ISkieurServiceImp implements ISkieurService {
//    @Autowired
    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        log.info("");
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Integer numSkieur) {
        skieurRepository.deleteById(numSkieur);

    }
    @Transactional
    @Override
    public Skieur assignSkierToPiste(int numSkieur, int numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null) ;
        Piste piste = pisteRepository.findById(numPiste).orElse(null) ;
        if (skieur != null && piste != null) {
            piste.getSkieurs().add(skieur);
//            pisteRepository.save(piste);
        }
        return skieur ;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return null;
    }



    @Override
    public Skieur retrieveSkieur(Integer numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

//    @Scheduled (fixedDelay = 10000)
    @Override
    public void schedulerFixedDelay() throws InterruptedException {
        Thread.sleep(30000);
        log.info("scheduler Fixed Delay ");
    }

    @Scheduled (fixedRate = 10000)
    @Override
    public void schedulerFixedRate() throws InterruptedException {
//        Thread.sleep(30000);
        skieurRepository.findAll().forEach(
                skieur -> log.info("Nbr "+ skieur.getInscriptions().size())
        );
        log.info("scheduler Fixed Rate ");
    }

}
