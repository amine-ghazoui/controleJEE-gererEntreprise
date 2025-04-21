package org.example.controlejeegererentreprise.web;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.example.controlejeegererentreprise.entities.Reservation;
import org.example.controlejeegererentreprise.repositories.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ReservationController {

    private final ReservationRepository reservationRepository;

    @GetMapping("/reservation")
    public String reservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }

    @PostMapping("/saveReservation")
    public String saveReservation(Model model, @Valid Reservation reservation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reservation";
        }
        reservationRepository.save(reservation);
        return "redirect:/reservation";
    }
}