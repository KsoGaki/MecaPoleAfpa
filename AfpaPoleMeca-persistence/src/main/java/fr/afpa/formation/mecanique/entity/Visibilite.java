package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Visibilite")
public class Visibilite {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Visibilite")
	private Long id;

	@Column(name="pareBrise", nullable = false)
	private Boolean pareBrise;

	@Column(name="vitrage", nullable = false)
	private Boolean vitrage;

	@Column(name="essuieGlaceAvant", nullable = false)
	private Boolean essuieGlaceAvant;

	@Column(name="essuieGlaceArriere", nullable = false)
	private Boolean essuieGlaceArriere;

	@Column(name="laveGlace", nullable = false)
	private Boolean laveGlace;

	@Column(name="lavePhare", nullable = false)
	private Boolean lavePhare;

	@Column(name="retroInterieur", nullable = false)
	private Boolean retroInterieur;

	@Column(name="retroExterieur", nullable = false)
	private Boolean retroExterieur;

	@Column(name="immatriculation", nullable = false)
	private Boolean immatriculation;
	
	/**
	 * 
	 * <b>Constructeur vide</b>
	 * 
	 */
	public Visibilite() {}

	/**
	 * 
	 * <b>Constructeur avec tous les paramètres</b>
	 * 
	 * 
	 * @param id
	 * @param pareBrise
	 * @param vitrage
	 * @param essuieGlaceAvant
	 * @param essuieGlaceArriere
	 * @param laveGlace
	 * @param lavePhare
	 * @param retroInterieur
	 * @param retroExterieur
	 * @param immatriculation
	 */
	public Visibilite(Long id, Boolean pareBrise, Boolean vitrage, Boolean essuieGlaceAvant, Boolean essuieGlaceArriere,
			Boolean laveGlace, Boolean lavePhare, Boolean retroInterieur, Boolean retroExterieur,
			Boolean immatriculation) {
		super();
		this.id = id;
		this.pareBrise = pareBrise;
		this.vitrage = vitrage;
		this.essuieGlaceAvant = essuieGlaceAvant;
		this.essuieGlaceArriere = essuieGlaceArriere;
		this.laveGlace = laveGlace;
		this.lavePhare = lavePhare;
		this.retroInterieur = retroInterieur;
		this.retroExterieur = retroExterieur;
		this.immatriculation = immatriculation;
	}

	/**
	 * 
	 * <b>Constructeur avec tous les paramètres sauf 'id'</b>
	 * 
	 * 
	 * @param pareBrise
	 * @param vitrage
	 * @param essuieGlaceAvant
	 * @param essuieGlaceArriere
	 * @param laveGlace
	 * @param lavePhare
	 * @param retroInterieur
	 * @param retroExterieur
	 * @param immatriculation
	 */
	public Visibilite(Boolean pareBrise, Boolean vitrage, Boolean essuieGlaceAvant, Boolean essuieGlaceArriere,
			Boolean laveGlace, Boolean lavePhare, Boolean retroInterieur, Boolean retroExterieur,
			Boolean immatriculation) {
		super();
		this.pareBrise = pareBrise;
		this.vitrage = vitrage;
		this.essuieGlaceAvant = essuieGlaceAvant;
		this.essuieGlaceArriere = essuieGlaceArriere;
		this.laveGlace = laveGlace;
		this.lavePhare = lavePhare;
		this.retroInterieur = retroInterieur;
		this.retroExterieur = retroExterieur;
		this.immatriculation = immatriculation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPareBrise() {
		return pareBrise;
	}

	public void setPareBrise(Boolean pareBrise) {
		this.pareBrise = pareBrise;
	}

	public Boolean getVitrage() {
		return vitrage;
	}

	public void setVitrage(Boolean vitrage) {
		this.vitrage = vitrage;
	}

	public Boolean getEssuieGlaceAvant() {
		return essuieGlaceAvant;
	}

	public void setEssuieGlaceAvant(Boolean essuieGlaceAvant) {
		this.essuieGlaceAvant = essuieGlaceAvant;
	}

	public Boolean getEssuieGlaceArriere() {
		return essuieGlaceArriere;
	}

	public void setEssuieGlaceArriere(Boolean essuieGlaceArriere) {
		this.essuieGlaceArriere = essuieGlaceArriere;
	}

	public Boolean getLaveGlace() {
		return laveGlace;
	}

	public void setLaveGlace(Boolean laveGlace) {
		this.laveGlace = laveGlace;
	}

	public Boolean getLavePhare() {
		return lavePhare;
	}

	public void setLavePhare(Boolean lavePhare) {
		this.lavePhare = lavePhare;
	}

	public Boolean getRetroInterieur() {
		return retroInterieur;
	}

	public void setRetroInterieur(Boolean retroInterieur) {
		this.retroInterieur = retroInterieur;
	}

	public Boolean getRetroExterieur() {
		return retroExterieur;
	}

	public void setRetroExterieur(Boolean retroExterieur) {
		this.retroExterieur = retroExterieur;
	}

	public Boolean getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(Boolean immatriculation) {
		this.immatriculation = immatriculation;
	}

}
