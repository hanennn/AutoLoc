package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.Agence;

public interface AgenceRepo extends JpaRepository<Agence,Long> {
}
