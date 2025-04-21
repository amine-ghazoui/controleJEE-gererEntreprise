package org.example.controlejeegererentreprise.repositories;


import org.example.controlejeegererentreprise.entities.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

    List<Entreprise> findByNomContaining(String keyword);
    List<Entreprise> findByDomaine(String domaine);
    Page<Entreprise> findByNomContains(String keyword, Pageable pageable);
    void deleteById(Long id);
}
