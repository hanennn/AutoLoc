package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.Services.IContrat;
import java.util.Set;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
@Tag(name = "Contrats", description = "Gestion des contrats")
public class ContratController {

    private final IContrat contratService;

    @GetMapping
    @Operation(summary = "Lister les contrats")
    @ApiResponse(responseCode = "200", description = "Liste récupérée")
    public Set<Contrat> findAll() {
        return contratService.retrieveContrat();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un contrat")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat trouvé"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable")
    })
    public Contrat findById(
            @Parameter(description = "Identifiant du contrat")
            @PathVariable Long id) {
        return contratService.retrieveContratById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un contrat")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Contrat créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un contrat")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat modifié"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Contrat update(
            @Parameter(description = "Identifiant du contrat")
            @PathVariable Long id,
            @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un contrat")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Contrat supprimé"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable")
    })
    public void deleteById(@PathVariable Long id) {
        contratService.deleteContrat(id);
    }
}