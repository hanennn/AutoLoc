package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Services.IAgence;
import java.util.Set;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
@Tag(name = "Agences", description = "Gestion des agences")
public class AgenceController {

    private final IAgence agenceService;

    @GetMapping
    @Operation(summary = "Lister les agences")
    public Set<Agence> findAll() {
        return agenceService.retrieveAgence();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence trouvée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    public Agence findById(@PathVariable Long id) {
        return agenceService.retrieveAgenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Agence créée"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Agence create(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence modifiée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Agence update(
            @PathVariable Long id,
            @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une agence")
    public void deleteById(@PathVariable Long id) {
        agenceService.deleteAgence(id);
    }
}