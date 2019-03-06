package fr.afpa.formation.mecanique.repository;

import org.springframework.data.repository.CrudRepository;


import fr.afpa.formation.mecanique.entity.Piece;

public interface PieceRepository extends CrudRepository<Piece, Long> {

}
