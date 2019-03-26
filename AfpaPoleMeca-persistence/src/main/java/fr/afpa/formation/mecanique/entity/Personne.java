package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * Abstract EVITE LA POSSIBILITE DE CREER UN OBJET PERSONNE
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
/*
 * PERMET D'EVITER 
 */
@DiscriminatorColumn(name="PERSONNE_TYPE", discriminatorType= DiscriminatorType.STRING, length=3)
@Table(name = "Personne")
public abstract class Personne {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Personne")
	private Long id;

	private String nom;
	private String prenom;
	private String telephone;

	@Column(unique=true, length=50)
	private String mail;

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Personne() {}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Personne(String nom, String prenom, String telephone, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Personne(Long id, String nom, String prenom, String telephone, String mail) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		String description = "Personne{"
				+ "id"        + ":" + this.id 
				+ "," + " " + "nom"       + ":" + this.nom 
				+ "," + " " + "prenom"    + ":" + this.prenom 
				+ "," + " " + "telephone" + ":" + this.telephone 
				+ "," + " " + "mail"      + ":" + this.mail
				+ "}";
		return description;
	}
}
