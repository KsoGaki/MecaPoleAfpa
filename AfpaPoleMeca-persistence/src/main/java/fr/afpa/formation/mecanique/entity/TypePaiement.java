package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TypePaiement")
public class TypePaiement {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_TypePaiement")
	private Long id;

	@Column(name="type", nullable=false)
	private String type;
	
	public TypePaiement() {}
	
	/**
	 * @param id
	 * @param type
	 */
	public TypePaiement(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	/**
	 * @param type
	 */
	public TypePaiement(String type) {
		super();
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
