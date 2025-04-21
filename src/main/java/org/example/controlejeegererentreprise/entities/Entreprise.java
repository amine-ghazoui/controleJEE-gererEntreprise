package org.example.controlejeegererentreprise.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Entreprise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String domaine;
    private String username;

    @OneToMany(mappedBy = "entreprise", fetch = FetchType.EAGER)
    private Collection<Reservation> reservations;
}
