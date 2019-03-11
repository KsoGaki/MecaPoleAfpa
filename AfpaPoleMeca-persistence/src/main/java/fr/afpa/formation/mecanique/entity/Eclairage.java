package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Eclairage")
public class Eclairage {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Eclairage")
	private Long id;
	
	@Column(name="feuxPosition", nullable = true)
	private Boolean feuxPosition;
	
	@Column(name="eclairageImmatriculation", nullable = true)
	private Boolean eclairageImmatriculation;
	
	@Column(name="feuxCroisement", nullable = true)
	private Boolean feuxCroisement;
	
	@Column(name="feuxRoute", nullable = true)
	private Boolean feuxRoute;
	
	@Column(name="indicationDirectionFeuxDetresse", nullable = true)
	private Boolean indicationDirectionFeuxDetresse;
	
	@Column(name="feuxStop", nullable = true)
	private Boolean feuxStop;
	
	@Column(name="feuxAntiBrouillard", nullable = true)
	private Boolean feuxAntiBrouillard;
	
	@Column(name="feuxRecul", nullable = true)
	private Boolean feuxRecul;
		
	/**
	 * 
	 * <b>Constructeur vide</b>
	 * 
	 */
	public Eclairage() {}

	/**
	 * 
	 * <b>Constructeur avec tous les paramètres</b>
	 * 
	 * 
	 * @param id
	 * @param feuxPosition
	 * @param eclairageImmatriculation
	 * @param feuxCroisement
	 * @param feuxRoute
	 * @param indicationDirectionFeuxDetresse
	 * @param feuxStop
	 * @param feuxAntiBrouillard
	 * @param feuxRecul
	 * @param controleQualite
	 */
	public Eclairage(Long id, Boolean feuxPosition, Boolean eclairageImmatriculation, Boolean feuxCroisement,
			Boolean feuxRoute, Boolean indicationDirectionFeuxDetresse, Boolean feuxStop, Boolean feuxAntiBrouillard,
			Boolean feuxRecul) {
		super();
		this.id = id;
		this.feuxPosition = feuxPosition;
		this.eclairageImmatriculation = eclairageImmatriculation;
		this.feuxCroisement = feuxCroisement;
		this.feuxRoute = feuxRoute;
		this.indicationDirectionFeuxDetresse = indicationDirectionFeuxDetresse;
		this.feuxStop = feuxStop;
		this.feuxAntiBrouillard = feuxAntiBrouillard;
		this.feuxRecul = feuxRecul;
	}
	
	/**
	 * 
	 * <b>Constructeur avec tous les paramètres sauf 'id'</b>
	 * 
	 * 
	 * @param feuxPosition
	 * @param eclairageImmatriculation
	 * @param feuxCroisement
	 * @param feuxRoute
	 * @param indicationDirectionFeuxDetresse
	 * @param feuxStop
	 * @param feuxAntiBrouillard
	 * @param feuxRecul
	 * @param controleQualite
	 */
	public Eclairage(Boolean feuxPosition, Boolean eclairageImmatriculation, Boolean feuxCroisement,
			Boolean feuxRoute, Boolean indicationDirectionFeuxDetresse, Boolean feuxStop, Boolean feuxAntiBrouillard,
			Boolean feuxRecul) {
		super();
		this.feuxPosition = feuxPosition;
		this.eclairageImmatriculation = eclairageImmatriculation;
		this.feuxCroisement = feuxCroisement;
		this.feuxRoute = feuxRoute;
		this.indicationDirectionFeuxDetresse = indicationDirectionFeuxDetresse;
		this.feuxStop = feuxStop;
		this.feuxAntiBrouillard = feuxAntiBrouillard;
		this.feuxRecul = feuxRecul;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getFeuxPosition() {
		return feuxPosition;
	}

	public void setFeuxPosition(Boolean feuxPosition) {
		this.feuxPosition = feuxPosition;
	}

	public Boolean getEclairageImmatriculation() {
		return eclairageImmatriculation;
	}

	public void setEclairageImmatriculation(Boolean eclairageImmatriculation) {
		this.eclairageImmatriculation = eclairageImmatriculation;
	}

	public Boolean getFeuxCroisement() {
		return feuxCroisement;
	}

	public void setFeuxCroisement(Boolean feuxCroisement) {
		this.feuxCroisement = feuxCroisement;
	}

	public Boolean getFeuxRoute() {
		return feuxRoute;
	}

	public void setFeuxRoute(Boolean feuxRoute) {
		this.feuxRoute = feuxRoute;
	}

	public Boolean getIndicationDirectionFeuxDetresse() {
		return indicationDirectionFeuxDetresse;
	}

	public void setIndicationDirectionFeuxDetresse(Boolean indicationDirectionFeuxDetresse) {
		this.indicationDirectionFeuxDetresse = indicationDirectionFeuxDetresse;
	}

	public Boolean getFeuxStop() {
		return feuxStop;
	}

	public void setFeuxStop(Boolean feuxStop) {
		this.feuxStop = feuxStop;
	}

	public Boolean getFeuxAntiBrouillard() {
		return feuxAntiBrouillard;
	}

	public void setFeuxAntiBrouillard(Boolean feuxAntiBrouillard) {
		this.feuxAntiBrouillard = feuxAntiBrouillard;
	}

	public Boolean getFeuxRecul() {
		return feuxRecul;
	}

	public void setFeuxRecul(Boolean feuxRecul) {
		this.feuxRecul = feuxRecul;
	}
		
}
