package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Services.IVehicule;
import java.util.Set;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
@Tag(name = "Véhicules", description = "Gestion des véhicules")
public class VehiculeController {

    private final IVehicule vehiculeService;

    @GetMapping
    @Operation(summary = "Lister les véhicules")
    public Set<Vehicule> findAll() {
        return vehiculeService.retrieveVehicule();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public Vehicule findById(@PathVariable Long id) {
        return vehiculeService.retrieveVehiculeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un véhicule")
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un véhicule")
    public Vehicule update(
            @PathVariable Long id,
            @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un véhicule")
    public void deleteById(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
    }
}