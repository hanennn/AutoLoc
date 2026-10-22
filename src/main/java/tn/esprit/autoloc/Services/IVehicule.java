package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Vehicule;

import java.util.Set;

public interface IVehicule {
    Vehicule addVehicule(Vehicule vehicule);
    void deleteVehicule(Long id);
    Set<Vehicule> retrieveVehicule();
    Vehicule retrieveVehiculeById(Long id);
    Vehicule updateVehicule(Vehicule vehicule);
}