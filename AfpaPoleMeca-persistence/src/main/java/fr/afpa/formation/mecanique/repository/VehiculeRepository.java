package fr.afpa.formation.mecanique.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.entity.Vehicule;

public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

}
