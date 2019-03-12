package fr.afpa.formation.mecanique.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="devis")
public class Devis {

	/////////////CHAMPS ENTITY/////////	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native", strategy= "native")
	private Long id;
	
	@Column(name="dateCreation", nullable=false)
	private Date dateCreation;
	
	@Column(length=50, nullable=false)
	private String numero;
	
	@Column(name="datePaiement", nullable=false)
	private Date datePaiement;
	
	@OneToMany(mappedBy="devis",fetch = FetchType.LAZY,cascade= CascadeType.ALL)
    private Set<ItemDevis> listItemDevis = new HashSet<ItemDevis>() ;
	
	@ManyToOne
	@JoinColumn(name="id_Devis")
	private Fournisseur fournisseur;

	////////////CONSTRUCTEURS///////////
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Devis() {}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Devis(Long id, Date dateCreation, String numero, Date datePaiement, Fournisseur fournisseur) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.numero = numero;
		this.datePaiement = datePaiement;
		this.fournisseur = fournisseur;
	}	

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */	
	public Devis(Date dateCreation, String numero, Date datePaiement, Fournisseur fournisseur) {
		super();
		this.dateCreation = dateCreation;
		this.numero = numero;
		this.datePaiement = datePaiement;
		this.fournisseur = fournisseur;
	}

	
	////////GETTERS ET SETTERS////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Set<ItemDevis> getListeItemDevis() {
		return listItemDevis;
	}

	public void setListeItemDevis(Set<ItemDevis> listeItemDevis) {
		this.listItemDevis = listeItemDevis;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	///////////////////TO STRING/////////////
	@Override
	public String toString() {
		return "Devis id = " + id + " dateCreation = " + dateCreation + " numero = " + numero + " datePaiement = "
				+ datePaiement + " listeItemDevis = " + listItemDevis + " fournisseur = " + fournisseur;
	}
	////////////////////////////////////

	
	
	
	
}
