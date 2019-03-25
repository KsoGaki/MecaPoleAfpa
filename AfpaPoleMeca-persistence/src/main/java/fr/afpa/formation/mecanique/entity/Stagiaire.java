package fr.afpa.formation.mecanique.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="STA")
public class Stagiaire extends Utilisateur {

	@Column(unique = true, length = 25)
	private String numeroCarte; 
	
	@ManyToOne
	@JoinColumn(name="id_Filiere")
	private Filiere filiere;	
	

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Stagiaire() {
		super();
	}
	
	
			
	public Stagiaire(Long id, String mail, String nom, String prenom, String telephone, String identifiant,
			String motDePasse, Date dateInscription, Date dateRadiation, RoleUtilisateur roleUtilisateur,
			String numeroCarte, Filiere filiere) {
		super(id, mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation,
				roleUtilisateur);
		this.numeroCarte = numeroCarte;
		this.filiere = filiere;
	}

	public Stagiaire(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation, RoleUtilisateur roleUtilisateur, String numeroCarte,
			Filiere filiere) {
		super(mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation, roleUtilisateur);
		this.numeroCarte = numeroCarte;
		this.filiere = filiere;
	}
	

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	@Override
	public String toString() {
		return "Stagiaire [numeroCarte=" + numeroCarte + "]";
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
}
