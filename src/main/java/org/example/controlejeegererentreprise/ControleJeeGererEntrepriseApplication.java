package org.example.controlejeegererentreprise;

import org.example.controlejeegererentreprise.entities.Entreprise;
import org.example.controlejeegererentreprise.entities.EtatReservation;
import org.example.controlejeegererentreprise.entities.Reservation;
import org.example.controlejeegererentreprise.entities.TypeReservation;
import org.example.controlejeegererentreprise.repositories.EntrepriseRepository;
import org.example.controlejeegererentreprise.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ControleJeeGererEntrepriseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleJeeGererEntrepriseApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(EntrepriseRepository entrepriseRepository, ReservationRepository reservationRepository) {
        return args -> {
            // ajout des entreprises

            Entreprise entreprise1 = Entreprise.builder()
                    .nom("Test Builder")
                    .email("builder@test.com")
                    .domaine("Construction")
                    .username("builder123")
                    .reservations(new ArrayList<>())
                    .build();
            entrepriseRepository.save(entreprise1);


            Entreprise entreprise2 = Entreprise.builder()
                    .nom("Tech Solutions")
                    .email("contact@tech.com")
                    .domaine("Informatique")
                    .username("techsol")
                    .reservations(new ArrayList<>())
                    .build();
            entrepriseRepository.save(entreprise2);

            Entreprise entreprise3 = Entreprise.builder()
                    .nom("Business Corp")
                    .email("info@business.com")
                    .domaine("Consulting")
                    .username("bizcorp")
                    .reservations(new ArrayList<>())
                    .build();
            entrepriseRepository.save(entreprise3);

            // ajout Reservation

            Reservation res1 = Reservation.builder()
                    .dateReservation(new Date())
                    .type(TypeReservation.CENTRE_CALCUL)
                    .duree(3)
                    .cout(450.0)
                    .etat(EtatReservation.VALIDATED)
                    .entreprise(entreprise1)
                    .build();
            reservationRepository.save(res1);

            Reservation res2 = Reservation.builder()
                    .dateReservation(new Date())
                    .type(TypeReservation.SALLE_REUNION)
                    .duree(2)
                    .cout(200.0)
                    .etat(EtatReservation.PENDING)
                    .entreprise(entreprise1)
                    .build();
            reservationRepository.save(res2);

            Reservation res3 = Reservation.builder()
                    .dateReservation(new Date())
                    .type(TypeReservation.SALLE_CONFERENCE)
                    .duree(8)
                    .cout(1200.0)
                    .etat(EtatReservation.REJECTED)
                    .entreprise(entreprise2)
                    .build();
            reservationRepository.save(res3);
        };
    }
}
