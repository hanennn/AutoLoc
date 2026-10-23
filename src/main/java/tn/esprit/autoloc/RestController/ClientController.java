package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Services.IClient;
import java.util.Set;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Tag(name = "Clients", description = "Gestion des clients")
public class ClientController {

    private final IClient clientService;

    @GetMapping
    @Operation(summary = "Lister les clients")
    public Set<Client> findAll() {
        return clientService.retrieveClient();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    public Client findById(@PathVariable Long id) {
        return clientService.retrieveClientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un client")
    public Client create(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un client")
    public Client update(
            @PathVariable Long id,
            @RequestBody Client client) {
        client.setIdClient(id);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un client")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}