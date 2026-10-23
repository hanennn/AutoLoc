package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Services.IMaintenance;
import java.util.Set;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
@Tag(name = "Maintenances", description = "Gestion des maintenances")
public class MaintenanceController {

    private final IMaintenance maintenanceService;

    @GetMapping
    @Operation(summary = "Lister les maintenances")
    public Set<Maintenance> findAll() {
        return maintenanceService.retrieveMaintenance();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter une maintenance")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Maintenance trouvée"),
            @ApiResponse(responseCode = "404", description = "Maintenance introuvable")
    })
    public Maintenance findById(@PathVariable Long id) {
        return maintenanceService.retrieveMaintenanceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer une maintenance")
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une maintenance")
    public Maintenance update(
            @PathVariable Long id,
            @RequestBody Maintenance maintenance) {
        maintenance.setIdMaintenance(id);
        return maintenanceService.updateMaintenance(maintenance);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une maintenance")
    public void deleteById(@PathVariable Long id) {
        maintenanceService.deleteMaintenance(id);
    }
}