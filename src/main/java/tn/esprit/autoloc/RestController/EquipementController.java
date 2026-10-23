package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Services.IEquipement;
import java.util.Set;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
@Tag(name = "Équipements", description = "Gestion des équipements")
public class EquipementController {

    private final IEquipement equipementService;

    @GetMapping
    @Operation(summary = "Lister les équipements")
    public Set<Equipement> findAll() {
        return equipementService.retrieveEquipement();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Équipement trouvé"),
            @ApiResponse(responseCode = "404", description = "Équipement introuvable")
    })
    public Equipement findById(@PathVariable Long id) {
        return equipementService.retrieveEquipementById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un équipement")
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un équipement")
    public Equipement update(
            @PathVariable Long id,
            @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        return equipementService.updateEquipement(equipement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un équipement")
    public void deleteById(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
    }
}