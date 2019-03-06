package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="piece")
public class Piece {
	/////////////CHAMPS ENTITY/////////	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native", strategy= "native")
	private Long id;

	@Column(name="reference",length=50, nullable=false)
	private String reference;

	@Column(name= "libelle", length=200, nullable=false)
	private String libelle;

	@Column(name="prixUnitaire", nullable=false)
	private Double prixUnitaire;
	
	@OneToOne(mappedBy="piece")
	private ItemDevis itemDevis;
	

	////////////CONSTRUCTEURS///////////

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Piece() {}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Piece(Long id, String reference, String libelle, Double prixUnitaire) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
	}
	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */	

	public Piece(String reference, String libelle, Double prixUnitaire) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
	}
	////////GETTERS ET SETTERS////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	///////////////////TO STRING/////////////
	@Override
	public String toString() {
		return "Piece id = " + id +
				" reference = " + reference +
				" libelle = " + libelle +
				" prixUnitaire = "+ prixUnitaire;
	}
	////////////////////////////////////






}
