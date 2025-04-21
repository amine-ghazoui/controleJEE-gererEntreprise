package org.example.controlejeegererentreprise.web;

import lombok.AllArgsConstructor;
import org.example.controlejeegererentreprise.repositories.ReservationRepository;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ReservationController {

    ReservationRepository reservationRepository;



}
