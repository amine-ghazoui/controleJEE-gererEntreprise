package org.example.controlejeegererentreprise.repositories;

import org.example.gererreservationentreprise.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
