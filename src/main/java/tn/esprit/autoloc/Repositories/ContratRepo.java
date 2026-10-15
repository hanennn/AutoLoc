package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Contrat;

public interface ContratRepo extends JpaRepository<Contrat,Long> {
}
