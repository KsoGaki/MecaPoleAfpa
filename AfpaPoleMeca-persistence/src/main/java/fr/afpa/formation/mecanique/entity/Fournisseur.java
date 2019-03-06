package fr.afpa.formation.mecanique.entity;

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
@Table(name="fournisseur")
public class Fournisseur {

	/////////////CHAMPS ENTITY/////////	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native", strategy= "native")
	private Long id;

	@Column(name="code",length=20, nullable=false)
	private String code;

	@Column(name="nom",length=50, nullable=false)
	private String nom;
	
	@OneToMany(mappedBy="fournisseur",fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	private Set<Devis> listDevis= new HashSet<Devis>();

	////////////CONSTRUCTEURS///////////
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Fournisseur() {}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Fournisseur(Long id, String code, String nom) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */	

	public Fournisseur(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}

	////////GETTERS ET SETTERS////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	///////////////////TO STRING/////////////
	@Override
	public String toString() {
		return "Fournisseur id = " + id +
				" code = " + code + 
				" nom = " + nom;
	}
	////////////////////////////////////
	
	






}
