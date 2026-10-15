package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.VehiculeRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehicule {

    private final VehiculeRepo vehiculeRepo;

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepo.deleteById(id);
    }

    @Override
    public Set<Vehicule> retrieveVehicule() {
        return new HashSet<>(vehiculeRepo.findAll());
    }

    @Override
    public Vehicule retrieveById(Long id) {
        return vehiculeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("vehicule", id));
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }
}