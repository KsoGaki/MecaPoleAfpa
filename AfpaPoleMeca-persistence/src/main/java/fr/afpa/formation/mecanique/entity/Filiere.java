package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Filiere")
public class Filiere {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Filiere")
	private Long id;

	@Column(name="nom", nullable=false)
	private String nom;

	public Filiere() {}
	
	/**
	 * @param id
	 * @param nom
	 */
	public Filiere(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * @param nom
	 */
	public Filiere(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
