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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Vehicule")
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column(length = 50)
	private String marque;
	@Column(length = 50)
	private String modele;
	private Double kilometrage;
	@Column(length = 200)
	private String numeroCarteGrise;
	@Column(length = 200)
	private String numeroAssurance;
	@Column(unique = true, length = 10)
	private String immatriculation;
	@Column(length = 17)
	private String vin;
	@DateTimeFormat (pattern="MM-dd-YYYY")
	private Date dateMiseCirculation;

	@OneToMany(mappedBy="vehicule",fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	private Set<OrdreReparation> listOrdreReparation = new HashSet<OrdreReparation>() ;

	/**
	 * CARDINALITE AVEC CLIENT
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client")
	private Client client;

	public Vehicule() {
		super();
	}

	public Vehicule(Long id, String marque, String modele, Double kilometrage, String numeroCarteGrise,
			String numeroAssurance, String immatriculation, String vin, Date dateMiseCirculation, Client client) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.kilometrage = kilometrage;
		this.numeroCarteGrise = numeroCarteGrise;
		this.numeroAssurance = numeroAssurance;
		this.immatriculation = immatriculation;
		this.vin = vin;
		this.dateMiseCirculation = dateMiseCirculation;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public String getMarque() {
		return marque;
	}

	public String getModele() {
		return modele;
	}

	public Double getKilometrage() {
		return kilometrage;
	}

	public String getNumeroCarteGrise() {
		return numeroCarteGrise;
	}

	public String getNumeroAssurance() {
		return numeroAssurance;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public String getVin() {
		return vin;
	}

	public Date getDateMiseCirculation() {
		return dateMiseCirculation;
	}

	public Client getClient() {
		return client;
	}

	public Set<OrdreReparation> getListOrdreReparation() {
		return listOrdreReparation;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public void setNumeroCarteGrise(String numeroCarteGrise) {
		this.numeroCarteGrise = numeroCarteGrise;
	}

	public void setNumeroAssurance(String numeroAssurance) {
		this.numeroAssurance = numeroAssurance;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setDateMiseCirculation(Date dateMiseCirculation) {
		this.dateMiseCirculation = dateMiseCirculation;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setListOrdreReparation(Set<OrdreReparation> listOrdreReparation) {
		this.listOrdreReparation = listOrdreReparation;
	}

}
