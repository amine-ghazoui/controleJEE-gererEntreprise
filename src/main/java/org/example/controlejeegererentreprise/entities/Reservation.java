package org.example.controlejeegererentreprise.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateReservation;
    private TypeReservation type;
    private int duree;
    private double cout;
    private EtatReservation etat;

    @ManyToOne(fetch = FetchType.EAGER)
    private Entreprise entreprise;

}
