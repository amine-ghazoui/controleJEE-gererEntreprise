package org.example.controlejeegererentreprise.repositories;

import org.example.gererreservationentreprise.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
