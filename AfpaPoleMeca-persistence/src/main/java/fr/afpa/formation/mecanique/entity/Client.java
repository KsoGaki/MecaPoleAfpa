package fr.afpa.formation.mecanique.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "CLI")
@Table(name = "Client")
public class Client extends Personne {

	@Column(unique = true, length = 25)
	private String numero;

	@Column(unique = true, length = 25)
	private String numeroCarteAfpa;

	private Date dateInscription;

	@Column(length = 1)
	private String statut;

	/**
	 * CARDINALITE AVEC ADRESSE
	 */
	@ManyToOne
	@JoinColumn(name = "id_adresse")
	private Adresse adresse;
	/**
	 * CARDINALITE AVEC VEHICULE
	 */

	@OneToMany(mappedBy="client",fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	private Set<Vehicule> vehicules = new HashSet<Vehicule>();

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Client() {
		super();
	}

	public Client(Adresse adresse) {
		super();
		this.adresse = adresse;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Client(String mail, String nom, String prenom, String telephone, String numero, String numeroCarteAfpa,
			Date dateInscription, String statut, Adresse adresse) {
		super(mail, nom, prenom, telephone);
		this.numero = numero;
		this.numeroCarteAfpa = numeroCarteAfpa;
		this.dateInscription = dateInscription;
		this.statut = statut;
		this.adresse = adresse;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Client(Long id, String mail, String nom, String prenom, String telephone, String numero,
			String numeroCarteAfpa, Date dateInscription, String statut, Adresse adresse) {
		super(id, mail, nom, prenom, telephone);
		this.numero = numero;
		this.numeroCarteAfpa = numeroCarteAfpa;
		this.dateInscription = dateInscription;
		this.statut = statut;
		this.adresse = adresse;

	}

	public String getNumero() {
		return numero;
	}

	public String getNumeroCarteAfpa() {
		return numeroCarteAfpa;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public String getStatut() {
		return statut;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public Set<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setNumeroCarteAfpa(String numeroCarteAfpa) {
		this.numeroCarteAfpa = numeroCarteAfpa;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setVehicules(Set<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	@Override
	public String toString() {
		return "Client [numero=" + numero + ", numeroCarteAfpa=" + numeroCarteAfpa + ", dateInscription="
				+ dateInscription + ", statut=" + statut + ", adresse=" + adresse + ", vehicules=" + vehicules + "]";
	}

}