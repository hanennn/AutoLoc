package tn.esprit.autoloc.Services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.AgenceRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgence {

    private final AgenceRepo agenceRepo;

    @Override
    public Agence addAgence(Agence agence) {
        return  agenceRepo.save(agence);
    }

    @Override
    public void deleteAgence(Long id) {
        agenceRepo.deleteById(id);

    }

    @Override
    public Set<Agence> retrieveAgence() {
        return new HashSet<>(agenceRepo.findAll());
    }

    @Override
    public Agence retrieveById(Long id) {
        return agenceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("agence", id));
    }

    @Override
    public Agence updateAgence(Agence agence) {
        return agenceRepo.save(agence);
    }
}
