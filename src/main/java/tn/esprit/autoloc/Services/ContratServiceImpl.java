package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.ContratRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContrat {

    private final ContratRepo contratRepo;

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepo.save(contrat);
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepo.deleteById(id);
    }

    @Override
    public Set<Contrat> retrieveContrat() {
        return new HashSet<>(contratRepo.findAll());
    }

    @Override
    public Contrat retrieveContratById(Long id) {
        return contratRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("contrat", id));
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepo.save(contrat);
    }
}