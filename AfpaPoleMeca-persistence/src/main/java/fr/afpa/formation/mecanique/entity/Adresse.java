package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="adresse")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column(length = 200, nullable=false)
	private String adresse;
	@Column(length = 500, nullable=false)
	private String complement;
	@Column(length = 5, nullable=true)
	private String codePostal;
	@Column(length = 150, nullable=false)
	private String localite;
	
	public Adresse() {
		
	}

	public Adresse(Long id, String adresse, String complement, String codePostal, String localite) {
		
		this.id = id;
		this.adresse = adresse;
		this.complement = complement;
		this.codePostal = codePostal;
		this.localite = localite;
	}

	public Long getId() {
		return id;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getComplement() {
		return complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getLocalite() {
		return localite;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}


	@Override
	public String toString() {
		return "Adresse [id=" + id + ", adresse=" + adresse + ", complement=" + complement + ", codePostal="
				+ codePostal + ", localite=" + localite;
	}

}
