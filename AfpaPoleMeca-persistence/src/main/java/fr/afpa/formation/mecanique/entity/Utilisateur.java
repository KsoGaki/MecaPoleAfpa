package fr.afpa.formation.mecanique.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public abstract class Utilisateur extends Personne {

	@Column(unique = true, length = 25)
	private String identifiant;

	@Column(unique = true, length = 25)
	private String motDePasse;

	private Date dateInscription;

	private Date dateRadiation;

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Utilisateur(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation) {
		super(mail, nom, prenom, telephone);
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.dateRadiation = dateRadiation;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Utilisateur(Long id, String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation) {
		super(id, mail, nom, prenom, telephone);
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.dateRadiation = dateRadiation;
	}

	public String getIdentifiant() { return identifiant; }

	public String getMotDePasse() { return motDePasse; }

	public Date getDateInscription() { return dateInscription; }

	public Date getDateRadiation() { return dateRadiation; }

	public void setIdentifiant(String identifiant) { this.identifiant = identifiant;
}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public void setDateRadiation(Date dateRadiation) {
		this.dateRadiation = dateRadiation;
	}

	@Override
	public String toString() {
		return "Utilisateur [identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", dateInscription="
				+ dateInscription + ", dateRadiation=" + dateRadiation + "]";
	}


}
