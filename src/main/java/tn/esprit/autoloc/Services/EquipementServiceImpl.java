package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.EquipementRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipement {

    private final EquipementRepo equipementRepo;

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepo.save(equipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        equipementRepo.deleteById(id);
    }

    @Override
    public Set<Equipement> retrieveEquipement() {
        return new HashSet<>(equipementRepo.findAll());
    }

    @Override
    public Equipement retrieveById(Long id) {
        return equipementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("equipement", id));
    }

    @Override
    public Equipement updateEquipement(Equipement equipement) {
        return equipementRepo.save(equipement);
    }
}