package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.MaintenanceRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class MaintenanceServiceImpl implements IMaintenance {

    private final MaintenanceRepo maintenanceRepo;

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    public void deleteMaintenance(Long id) {
        maintenanceRepo.deleteById(id);
    }

    @Override
    public Set<Maintenance> retrieveMaintenance() {
        return new HashSet<>(maintenanceRepo.findAll());
    }

    @Override
    public Maintenance retrieveMaintenanceById(Long id) {
        return maintenanceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("maintenance", id));
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }
}