package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Paiement;

public interface PaiementRepo extends JpaRepository<Paiement, Long> {
}