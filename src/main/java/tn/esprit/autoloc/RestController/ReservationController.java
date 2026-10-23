package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Services.IReservation;
import java.util.Set;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
@Tag(name = "Réservations", description = "Gestion des réservations")
public class ReservationController {

    private final IReservation reservationService;

    @GetMapping
    @Operation(summary = "Lister les réservations")
    public Set<Reservation> findAll() {
        return reservationService.retrieveReservation();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter une réservation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Réservation trouvée"),
            @ApiResponse(responseCode = "404", description = "Réservation introuvable")
    })
    public Reservation findById(@PathVariable Long id) {
        return reservationService.retrieveReservationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer une réservation")
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une réservation")
    public Reservation update(
            @PathVariable Long id,
            @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une réservation")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}