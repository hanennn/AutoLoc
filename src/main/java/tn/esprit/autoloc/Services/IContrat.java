package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Contrat;
import java.util.Set;

public interface IContrat {
    Contrat addContrat(Contrat contrat);
    void deleteContrat(Long id);
    Set<Contrat> retrieveContrat();
    Contrat retrieveById(Long id);
    Contrat updateContrat(Contrat contrat);
}