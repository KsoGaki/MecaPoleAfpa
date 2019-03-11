package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="item_devis")
public class ItemDevis {
	/////////////CHAMPS ENTITY/////////	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native", strategy= "native")
	private Long id;

	@Column(name="quantite", nullable=false)
	private Integer quantite;
	
	@ManyToOne
	@JoinColumn(name="id_Devis")
	private Devis devis;	
	
	@OneToOne
	private Piece piece;	
	
	//////////CONSTRUCTEURS/////////
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public ItemDevis() {}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public ItemDevis(Long id, Integer quantite, Devis devis, Piece piece) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.devis = devis;
		this.piece = piece;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */	
	public ItemDevis(Integer quantite, Devis devis, Piece piece) {
		super();
		this.quantite = quantite;
		this.devis = devis;
		this.piece = piece;
	}
	
	

	

	////////GETTERS ET SETTERS////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	
	
	///////////TO STRING//////////////
	
	@Override
	public String toString() {
		return "ItemDevis id = " + id + " quantite = " + quantite + " devis = " + devis + " piece = " + piece;
	}
		




}
