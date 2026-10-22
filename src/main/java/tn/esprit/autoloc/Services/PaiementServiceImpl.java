package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.PaiementRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiement {

    private final PaiementRepo paiementRepo;

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepo.save(paiement);
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepo.deleteById(id);
    }

    @Override
    public Set<Paiement> retrievePaiement() {
        return new HashSet<>(paiementRepo.findAll());
    }

    @Override
    public Paiement retrievePaiementById(Long id) {
        return paiementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("paiement", id));
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        return paiementRepo.save(paiement);
    }
}