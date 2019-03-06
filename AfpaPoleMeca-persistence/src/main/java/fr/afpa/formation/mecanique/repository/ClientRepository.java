package fr.afpa.formation.mecanique.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
