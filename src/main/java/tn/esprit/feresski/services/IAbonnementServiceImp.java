package tn.esprit.feresski.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.feresski.entities.Abonnement;
import tn.esprit.feresski.entities.TypeAbonnement;
import tn.esprit.feresski.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor

public class IAbonnementServiceImp implements IAbonnementService{
    private final AbonnementRepository abonnementRepository;

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbonnement) {
        return abonnementRepository.findAllByTypeAbon(typeAbonnement);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findAllByDateDebutEqualsAndDateFinEquals(startDate,endDate);
    }
}
