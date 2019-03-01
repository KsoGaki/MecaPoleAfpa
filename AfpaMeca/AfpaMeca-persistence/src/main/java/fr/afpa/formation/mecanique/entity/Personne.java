package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * 
 * Abstract EVITE LA POSSIBILITE DE CREER UN OBJET PERSONE
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
/*
 * PERMET D'EVITER 
 */
@DiscriminatorColumn(name="PERSONNE_TYPE", discriminatorType= DiscriminatorType.STRING, length=3)
public abstract class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nom;
	private String prenom;
	private String telephone;
	
	@Column(unique=true, length=50)
	private String mail;
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Personne() {}
	
	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Personne(String nom, String prenom, String telephone, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Personne(Long id, String nom, String prenom, String telephone, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
	}

	public Long   getId       () { return this.id;        }
	public String getNom      () { return this.nom;       }
	public String getPrenom   () { return this.prenom;    }
	public String getTelephone() { return this.telephone; }
	public String getMail     () { return this.mail;      }
	
	
	public void setId       (Long   id       ) { this.id        = id;        }
	public void setNom      (String nom      ) { this.nom       = nom;       }
	public void setPrenom   (String prenom   ) { this.prenom    = prenom;    }
	public void setTelephone(String telephone) { this.telephone = telephone; }
	public void setMail     (String mail     ) { this.mail      = mail;      }
	
	@Override
	public String toString() {
		String description = "Personne{"
											    + "id"        + ":" + this.id 
									+ "," + " " + "nom"       + ":" + this.nom 
									+ "," + " " + "prenom"    + ":" + this.prenom 
									+ "," + " " + "telephone" + ":" + this.telephone 
									+ "," + " " + "mail"      + ":" + this.mail
									+ "}";
		return description;
	}
}
