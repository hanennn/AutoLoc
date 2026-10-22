package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Employe;

import java.util.Set;

public interface IEmploye {
    Employe addEmploye(Employe employe);
    void deleteEmploye(Long id);
    Set<Employe> retrieveEmploye();
    Employe retrieveEmployeById(Long id);
    Employe updateEmploye(Employe employe);
}