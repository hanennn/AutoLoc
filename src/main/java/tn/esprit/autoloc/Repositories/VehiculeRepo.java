package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Vehicule;

public interface VehiculeRepo extends JpaRepository<Vehicule,Long> {
}
