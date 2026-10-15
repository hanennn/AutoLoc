package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.ReservationRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepo reservationRepo;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }

    @Override
    public Set<Reservation> retrieveReservation() {
        return new HashSet<>(reservationRepo.findAll());
    }

    @Override
    public Reservation retrieveById(Long id) {
        return reservationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("reservation", id));
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
}