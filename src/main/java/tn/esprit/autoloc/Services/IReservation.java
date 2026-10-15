package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Reservation;
import java.util.Set;

public interface IReservation {
    Reservation addReservation(Reservation reservation);
    void deleteReservation(Long id);
    Set<Reservation> retrieveReservation();
    Reservation retrieveById(Long id);
    Reservation updateReservation(Reservation reservation);
}