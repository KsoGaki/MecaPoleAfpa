package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="StatutOrdreReparation")
public class StatutOrdreReparation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_StatutOrdreReparation")
	private Long id;
	
	@Column(name="statut", nullable=false)
	private String statut;

	public StatutOrdreReparation() {}
	
	/**
	 * @param id
	 * @param statut
	 */
	public StatutOrdreReparation(Long id, String statut) {
		super();
		this.id = id;
		this.statut = statut;
	}

	/**
	 * @param statut
	 */
	public StatutOrdreReparation(String statut) {
		super();
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
