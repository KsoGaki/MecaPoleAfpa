package fr.afpa.formation.mecanique.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cloture")
public class Cloture {
	/////////////CHAMPS ENTITY/////////	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native", strategy= "native")
	private Long id;

	@Column(name="date")
	private Date date;

	@ManyToOne
	@JoinColumn(name="id_StatutCloture")
	private StatutCloture statutCloture;

	////////////CONSTRUCTEURS///////////
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Cloture() {}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	
	public Cloture(Long id, Date date, StatutCloture statutCloture) {
		super();
		this.id = id;
		this.date = date;
		this.statutCloture = statutCloture;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */		
	public Cloture(Date date, StatutCloture statutCloture) {
		super();
		this.date = date;
		this.statutCloture = statutCloture;
	}
	
	
	/////////////GETTERS SETTERS\\\\\\\\\\\\\\\\\\\\\\\\

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StatutCloture getStatutCloture() {
		return statutCloture;
	}

	public void setStatutCloture(StatutCloture statutCloture) {
		this.statutCloture = statutCloture;
	}

	@Override
	public String toString() {
		return "Cloture id = " + id + " date = " + date + " statutCloture = " + statutCloture;
	}

	

	


}
