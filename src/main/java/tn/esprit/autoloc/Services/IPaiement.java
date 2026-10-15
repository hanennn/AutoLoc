package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Paiement;
import java.util.Set;

public interface IPaiement {
    Paiement addPaiement(Paiement paiement);
    void deletePaiement(Long id);
    Set<Paiement> retrievePaiement();
    Paiement retrieveById(Long id);
    Paiement updatePaiement(Paiement paiement);
}