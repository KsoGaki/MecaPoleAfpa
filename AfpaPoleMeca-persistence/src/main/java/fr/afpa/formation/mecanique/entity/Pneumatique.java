package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Pneumatique")
public class Pneumatique {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Pneumatique")
	private Long id;

	@Column(name="etatPneuAvantGauche", nullable = false)
	private Integer etatPneuAvantGauche;

	@Column(name="etatPneuAvantDroit", nullable = false)
	private Integer etatPneuAvantDroit;

	@Column(name="etatPneuArriereGauche", nullable = false)
	private Integer etatPneuArriereGauche;

	@Column(name="etatPneuArriereDroit", nullable = false)
	private Integer etatPneuArriereDroit;
	
	@Column(name="etatPneuSecours", nullable = false)
	private Integer etatPneuSecours;

	@Column(name="pressionPneuAvantGauche", nullable = false)
	private Integer pressionPneuAvantGauche;

	@Column(name="pressionPneuAvantDroit", nullable = false)
	private Integer pressionPneuAvantDroit;

	@Column(name="pressionPneuArriereGauche", nullable = false)
	private Integer pressionPneuArriereGauche;

	@Column(name="pressionPneuArriereDroit", nullable = false)
	private Integer pressionPneuArriereDroit;
	
	@Column(name="pressionPneuSecours", nullable = false)
	private Integer pressionPneuSecours;
	
	/**
	 * 
	 * <b>Constructeur vide</b>
	 * 
	 */
	public Pneumatique() {}
	
	/**
	 * 
	 * <b>Constructeur avec tous les paramètres</b>
	 * 
	 * 
	 * @param id
	 * @param etatPneuAvantGauche
	 * @param etatPneuAvantDroit
	 * @param etatPneuArriereGauche
	 * @param etatPneuArriereDroit
	 * @param etatPneuSecours
	 * @param pressionPneuAvantGauche
	 * @param pressionPneuAvantDroit
	 * @param pressionPneuArriereGauche
	 * @param pressionPneuArriereDroit
	 * @param pressionPneuSecours
	 */
	public Pneumatique(Long id, Integer etatPneuAvantGauche, Integer etatPneuAvantDroit, Integer etatPneuArriereGauche,
			Integer etatPneuArriereDroit, Integer etatPneuSecours, Integer pressionPneuAvantGauche,
			Integer pressionPneuAvantDroit, Integer pressionPneuArriereGauche, Integer pressionPneuArriereDroit,
			Integer pressionPneuSecours) {
		super();
		this.id = id;
		this.etatPneuAvantGauche = etatPneuAvantGauche;
		this.etatPneuAvantDroit = etatPneuAvantDroit;
		this.etatPneuArriereGauche = etatPneuArriereGauche;
		this.etatPneuArriereDroit = etatPneuArriereDroit;
		this.etatPneuSecours = etatPneuSecours;
		this.pressionPneuAvantGauche = pressionPneuAvantGauche;
		this.pressionPneuAvantDroit = pressionPneuAvantDroit;
		this.pressionPneuArriereGauche = pressionPneuArriereGauche;
		this.pressionPneuArriereDroit = pressionPneuArriereDroit;
		this.pressionPneuSecours = pressionPneuSecours;
	}	
	
	/**
	 * 
	 * <b>Constructeur avec tous les paramètres sauf 'id'</b>
	 * 
	 * 
	 * @param etatPneuAvantGauche
	 * @param etatPneuAvantDroit
	 * @param etatPneuArriereGauche
	 * @param etatPneuArriereDroit
	 * @param etatPneuSecours
	 * @param pressionPneuAvantGauche
	 * @param pressionPneuAvantDroit
	 * @param pressionPneuArriereGauche
	 * @param pressionPneuArriereDroit
	 * @param pressionPneuSecours
	 */
	public Pneumatique(Integer etatPneuAvantGauche, Integer etatPneuAvantDroit, Integer etatPneuArriereGauche,
			Integer etatPneuArriereDroit, Integer etatPneuSecours, Integer pressionPneuAvantGauche,
			Integer pressionPneuAvantDroit, Integer pressionPneuArriereGauche, Integer pressionPneuArriereDroit,
			Integer pressionPneuSecours) {
		super();
		this.etatPneuAvantGauche = etatPneuAvantGauche;
		this.etatPneuAvantDroit = etatPneuAvantDroit;
		this.etatPneuArriereGauche = etatPneuArriereGauche;
		this.etatPneuArriereDroit = etatPneuArriereDroit;
		this.etatPneuSecours = etatPneuSecours;
		this.pressionPneuAvantGauche = pressionPneuAvantGauche;
		this.pressionPneuAvantDroit = pressionPneuAvantDroit;
		this.pressionPneuArriereGauche = pressionPneuArriereGauche;
		this.pressionPneuArriereDroit = pressionPneuArriereDroit;
		this.pressionPneuSecours = pressionPneuSecours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEtatPneuAvantGauche() {
		return etatPneuAvantGauche;
	}

	public void setEtatPneuAvantGauche(Integer etatPneuAvantGauche) {
		this.etatPneuAvantGauche = etatPneuAvantGauche;
	}

	public Integer getEtatPneuAvantDroit() {
		return etatPneuAvantDroit;
	}

	public void setEtatPneuAvantDroit(Integer etatPneuAvantDroit) {
		this.etatPneuAvantDroit = etatPneuAvantDroit;
	}

	public Integer getEtatPneuArriereGauche() {
		return etatPneuArriereGauche;
	}

	public void setEtatPneuArriereGauche(Integer etatPneuArriereGauche) {
		this.etatPneuArriereGauche = etatPneuArriereGauche;
	}

	public Integer getEtatPneuArriereDroit() {
		return etatPneuArriereDroit;
	}

	public void setEtatPneuArriereDroit(Integer etatPneuArriereDroit) {
		this.etatPneuArriereDroit = etatPneuArriereDroit;
	}

	public Integer getEtatPneuSecours() {
		return etatPneuSecours;
	}

	public void setEtatPneuSecours(Integer etatPneuSecours) {
		this.etatPneuSecours = etatPneuSecours;
	}

	public Integer getPressionPneuAvantGauche() {
		return pressionPneuAvantGauche;
	}

	public void setPressionPneuAvantGauche(Integer pressionPneuAvantGauche) {
		this.pressionPneuAvantGauche = pressionPneuAvantGauche;
	}

	public Integer getPressionPneuAvantDroit() {
		return pressionPneuAvantDroit;
	}

	public void setPressionPneuAvantDroit(Integer pressionPneuAvantDroit) {
		this.pressionPneuAvantDroit = pressionPneuAvantDroit;
	}

	public Integer getPressionPneuArriereGauche() {
		return pressionPneuArriereGauche;
	}

	public void setPressionPneuArriereGauche(Integer pressionPneuArriereGauche) {
		this.pressionPneuArriereGauche = pressionPneuArriereGauche;
	}

	public Integer getPressionPneuArriereDroit() {
		return pressionPneuArriereDroit;
	}

	public void setPressionPneuArriereDroit(Integer pressionPneuArriereDroit) {
		this.pressionPneuArriereDroit = pressionPneuArriereDroit;
	}

	public Integer getPressionPneuSecours() {
		return pressionPneuSecours;
	}

	public void setPressionPneuSecours(Integer pressionPneuSecours) {
		this.pressionPneuSecours = pressionPneuSecours;
	}
		
}
