package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Maintenance;
import java.util.Set;

public interface IMaintenance {
    Maintenance addMaintenance(Maintenance maintenance);
    void deleteMaintenance(Long id);
    Set<Maintenance> retrieveMaintenance();
    Maintenance retrieveMaintenanceById(Long id);
    Maintenance updateMaintenance(Maintenance maintenance);
}