package fr.afpa.formation.mecanique.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ControleQualite")
public class ControleQualite {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_ControleQualite")
	private Long id;

	@Column(name="dateDebut", nullable = false)
	private Date dateDebut;

	@Column(name="kilometrageFin", nullable = false)
	private Double kilometrageFin;

	@Column(name="observation", nullable = false, length = 500)
	private String observation;

	@OneToOne
    @JoinColumn(name="id_Pneumatique", nullable= false)
	private Pneumatique pneumatique;

	@OneToOne
    @JoinColumn(name="id_Eclairage", nullable= false)
	private Eclairage eclairage;

	@OneToOne
    @JoinColumn(name="id_Visibilite", nullable= false)
	private Visibilite visibilite;
	
	@OneToOne
    @JoinColumn(name="id_Niveau", nullable= false)
	private Niveau niveau;

	
	/**
	 * 
	 * <b>Constructeur vide</b>
	 * 
	 */
	public ControleQualite() {}
	
	/**
	 * 
	 * <b>Constructeur avec tous les paramètres</b>
	 * 
	 * 
	 * @param id
	 * @param dateDebut
	 * @param kilometrageFin
	 * @param observation
	 * @param pneumatique
	 * @param eclairage
	 * @param visibilite
	 * @param niveau
	 */
	public ControleQualite(Long id, Date dateDebut, Double kilometrageFin, String observation, Pneumatique pneumatique,
			Eclairage eclairage, Visibilite visibilite, Niveau niveau) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.kilometrageFin = kilometrageFin;
		this.observation = observation;
		this.pneumatique = pneumatique;
		this.eclairage = eclairage;
		this.visibilite = visibilite;
		this.niveau = niveau;
	}
	
	/**
	 * 
	 * <b>Constructeur avec tous les paramètres sauf 'id'</b>
	 * 
	 * 
	 * @param dateDebut
	 * @param kilometrageFin
	 * @param observation
	 * @param pneumatique
	 * @param eclairage
	 * @param visibilite
	 * @param niveau
	 */
	public ControleQualite(Date dateDebut, Double kilometrageFin, String observation, Pneumatique pneumatique,
			Eclairage eclairage, Visibilite visibilite, Niveau niveau) {
		super();
		this.dateDebut = dateDebut;
		this.kilometrageFin = kilometrageFin;
		this.observation = observation;
		this.pneumatique = pneumatique;
		this.eclairage = eclairage;
		this.visibilite = visibilite;
		this.niveau = niveau;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Double getKilometrageFin() {
		return kilometrageFin;
	}

	public void setKilometrageFin(Double kilometrageFin) {
		this.kilometrageFin = kilometrageFin;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Pneumatique getPneumatique() {
		return pneumatique;
	}

	public void setPneumatique(Pneumatique pneumatique) {
		this.pneumatique = pneumatique;
	}

	public Eclairage getEclairage() {
		return eclairage;
	}

	public void setEclairage(Eclairage eclairage) {
		this.eclairage = eclairage;
	}

	public Visibilite getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}

	public Niveau getNiveaux() {
		return niveau;
	}

	public void setNiveaux(Niveau niveau) {
		this.niveau = niveau;
	}
	

}
