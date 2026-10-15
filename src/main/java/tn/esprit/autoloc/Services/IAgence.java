package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Agence;

import java.util.Set;

public interface IAgence {
    Agence addAgence(Agence agence);
    void deleteAgence(Long id);
    Set<Agence> retrieveAgence();
    Agence retrieveById(Long id);
    Agence updateAgence(Agence agence);

}
