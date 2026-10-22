package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Equipement;
import java.util.Set;

public interface IEquipement {
    Equipement addEquipement(Equipement equipement);
    void deleteEquipement(Long id);
    Set<Equipement> retrieveEquipement();
    Equipement retrieveEquipementById(Long id);
    Equipement updateEquipement(Equipement equipement);
}