package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="statut_cloture")
public class StatutCloture {

	/////////////CHAMPS ENTITY/////////	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native", strategy= "native")
	private Long id;


	@Column(name="libelle")
	private String libelle;


	/////////////CONSTRUCTEURS\\\\\\\\\\\\\\\\\\\
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public StatutCloture() {
		
	}
	
	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	
	public StatutCloture(String libelle) {
		super();
		this.libelle = libelle;

	}	
	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */		

	public StatutCloture(Long id, String libelle) {		
		this.id = id;
		this.libelle = libelle;
	}

	/////////////GETTERS ET SETTERS\\\\\\\\\\\\\\\\\\\
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	

	
	/////////////TO STRING\\\\\\\\\\\\\\\\\\\
	@Override
	public String toString() {
		return "StatutCloture id = " + id +
				" libelle = " + libelle;
	}





}
