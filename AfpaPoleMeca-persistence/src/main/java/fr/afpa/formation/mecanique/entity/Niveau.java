package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Niveau")
public class Niveau {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Eclairage")
	private Long id;
	
	@Column(name="liquideRefroidissement", nullable = true)
	private Boolean liquideRefroidissement;
	
	@Column(name="laveGlace", nullable = true)
	private Boolean laveGlace;
	
	@Column(name="huileMoteur", nullable = true)
	private Boolean huileMoteur;
	
	@Column(name="liquideFrein", nullable = true)
	private Boolean liquideFrein;
	
	@Column(name="huileDirectionAssistee", nullable = true)
	private Boolean huileDirectionAssistee;
	
	
	/**
	 * 
	 * <b>Constructeur vide</b>
	 * 
	 */
	public Niveau() {}

	/**
	 * 
	 * <b>Constructeur avec tous les paramètres</b>
	 * 
	 * 
	 * @param id
	 * @param liquideRefroidissement
	 * @param laveGlace
	 * @param huileMoteur
	 * @param liquideFrein
	 * @param huileDirectionAssistee
	 */
	public Niveau(Long id, Boolean liquideRefroidissement, Boolean laveGlace, Boolean huileMoteur,
			Boolean liquideFrein, Boolean huileDirectionAssistee) {
		super();
		this.id = id;
		this.liquideRefroidissement = liquideRefroidissement;
		this.laveGlace = laveGlace;
		this.huileMoteur = huileMoteur;
		this.liquideFrein = liquideFrein;
		this.huileDirectionAssistee = huileDirectionAssistee;
	}
	
	/**
	 * 
	 * <b>Constructeur avec tous les paramètres sauf 'id'</b>
	 * 
	 * 
	 * @param id
	 * @param liquideRefroidissement
	 * @param laveGlace
	 * @param huileMoteur
	 * @param liquideFrein
	 * @param huileDirectionAssistee
	 */
	public Niveau(Boolean liquideRefroidissement, Boolean laveGlace, Boolean huileMoteur,
			Boolean liquideFrein, Boolean huileDirectionAssistee) {
		super();
		this.liquideRefroidissement = liquideRefroidissement;
		this.laveGlace = laveGlace;
		this.huileMoteur = huileMoteur;
		this.liquideFrein = liquideFrein;
		this.huileDirectionAssistee = huileDirectionAssistee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getLiquideRefroidissement() {
		return liquideRefroidissement;
	}

	public void setLiquideRefroidissement(Boolean liquideRefroidissement) {
		this.liquideRefroidissement = liquideRefroidissement;
	}

	public Boolean getLaveGlace() {
		return laveGlace;
	}

	public void setLaveGlace(Boolean laveGlace) {
		this.laveGlace = laveGlace;
	}

	public Boolean getHuileMoteur() {
		return huileMoteur;
	}

	public void setHuileMoteur(Boolean huileMoteur) {
		this.huileMoteur = huileMoteur;
	}

	public Boolean getLiquideFrein() {
		return liquideFrein;
	}

	public void setLiquideFrein(Boolean liquideFrein) {
		this.liquideFrein = liquideFrein;
	}

	public Boolean getHuileDirectionAssistee() {
		return huileDirectionAssistee;
	}

	public void setHuileDirectionAssistee(Boolean huileDirectionAssistee) {
		this.huileDirectionAssistee = huileDirectionAssistee;
	}
		
}
