package fr.afpa.formation.mecanique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afpa.formation.mecanique.entity.OrdreReparation;

public interface OrdreReparationRepository extends JpaRepository<OrdreReparation, Long> {

}
