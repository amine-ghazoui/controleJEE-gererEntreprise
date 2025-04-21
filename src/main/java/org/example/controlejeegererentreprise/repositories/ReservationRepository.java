package org.example.controlejeegererentreprise.repositories;


import org.example.controlejeegererentreprise.entities.EtatReservation;
import org.example.controlejeegererentreprise.entities.Reservation;
import org.example.controlejeegererentreprise.entities.TypeReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByEntrepriseId(Long entrepriseId);
    List<Reservation> findByEtat(EtatReservation etat);
}
