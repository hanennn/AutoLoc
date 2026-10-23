package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Services.IEmploye;
import java.util.Set;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
@Tag(name = "Employés", description = "Gestion des employés")
public class EmployeController {

    private final IEmploye employeService;

    @GetMapping
    @Operation(summary = "Lister les employés")
    public Set<Employe> findAll() {
        return employeService.retrieveEmploye();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un employé")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employé trouvé"),
            @ApiResponse(responseCode = "404", description = "Employé introuvable")
    })
    public Employe findById(@PathVariable Long id) {
        return employeService.retrieveEmployeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un employé")
    public Employe create(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un employé")
    public Employe update(
            @PathVariable Long id,
            @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        return employeService.updateEmploye(employe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un employé")
    public void deleteById(@PathVariable Long id) {
        employeService.deleteEmploye(id);
    }
}