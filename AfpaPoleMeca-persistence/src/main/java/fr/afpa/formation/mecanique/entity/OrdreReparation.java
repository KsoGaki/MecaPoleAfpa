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
@Table(name="OrdreReparation")
public class OrdreReparation {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_OrdreReparation")
	private Long id;
	
	@Column(unique=true, nullable=false, name="numero")
	private String numero;
	
	@Column(name="dateCreation")
	private Date dateCreation;
	
	@Column(name="dateEntree")
	private Date dateEntree;
	
	@Column(name="dateSortie")
	private Date dateSortie;

	@Column(name="symptomesClient")
	private String symptomesClient;
	
	@Column(name="interventionARealiser")
	private String interventionARealiser;
	
	@Column(name="interventionRealisee")
	private String interventionRealisee;
	
	@Column(name="futursTravaux")
	private String futursTravaux;
	
	@ManyToOne
	@JoinColumn(name="id_Vehicule")
	private Vehicule vehicule;
	
	@ManyToOne
	@JoinColumn(name="id_StatutOrdreReparation")
	private StatutOrdreReparation statutOrdreReparation;
	
	@ManyToOne
	@JoinColumn(name="id_Utilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="id_Utilisateur_Cloturer")
	private Utilisateur utilisateurCloturer;
	
	@ManyToOne
	@JoinColumn(name="id_Formateur")
	private Utilisateur formateur;
	
	/**
	 * 
	 * <b>Constructeur vide</b>
	 * 
	 */
	public OrdreReparation() {}

	/**
	 * 
	 * <b>Constructeur avec tous les paramètres</b>
	 * 
	 * 
	 * @param id
	 * @param numero
	 * @param dateCreation
	 * @param dateEntree
	 * @param dateSortie
	 * @param symptomesClient
	 * @param interventionARealiser
	 * @param interventionRealisee
	 * @param futursTravaux
	 * @param vehicule
	 * @param statutOrdreReparation
	 * @param utilisateur
	 */
	public OrdreReparation(Long id, String numero, Date dateCreation, Date dateEntree, Date dateSortie,
			String symptomesClient, String interventionARealiser, String interventionRealisee, String futursTravaux,
			Vehicule vehicule, StatutOrdreReparation statutOrdreReparation,
			Utilisateur utilisateur) {
		super();
		this.id = id;
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.symptomesClient = symptomesClient;
		this.interventionARealiser = interventionARealiser;
		this.interventionRealisee = interventionRealisee;
		this.futursTravaux = futursTravaux;
		this.vehicule = vehicule;
		this.statutOrdreReparation = statutOrdreReparation;
		this.utilisateur = utilisateur;
	}
	
	/**
	 * 
	 * <b>Constructeur avec tous les paramètres sauf 'id'</b>
	 * 
	 * 
	 * @param numero
	 * @param dateCreation
	 * @param dateEntree
	 * @param dateSortie
	 * @param symptomesClient
	 * @param interventionARealiser
	 * @param interventionRealisee
	 * @param futursTravaux
	 * @param vehicule
	 * @param statutOrdreReparation
	 * @param utilisateur
	 */
	public OrdreReparation(String numero, Date dateCreation, Date dateEntree, Date dateSortie,
			String symptomesClient, String interventionARealiser, String interventionRealisee, String futursTravaux,
			Vehicule vehicule, StatutOrdreReparation statutOrdreReparation,
			Utilisateur utilisateur) {
		super();
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.symptomesClient = symptomesClient;
		this.interventionARealiser = interventionARealiser;
		this.interventionRealisee = interventionRealisee;
		this.futursTravaux = futursTravaux;
		this.vehicule = vehicule;
		this.statutOrdreReparation = statutOrdreReparation;
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getSymptomesClient() {
		return symptomesClient;
	}

	public void setSymptomesClient(String symptomesClient) {
		this.symptomesClient = symptomesClient;
	}

	public String getInterventionARealiser() {
		return interventionARealiser;
	}

	public void setInterventionARealiser(String interventionARealiser) {
		this.interventionARealiser = interventionARealiser;
	}

	public String getInterventionRealisee() {
		return interventionRealisee;
	}

	public void setInterventionRealisee(String interventionRealisee) {
		this.interventionRealisee = interventionRealisee;
	}

	public String getFutursTravaux() {
		return futursTravaux;
	}

	public void setFutursTravaux(String futursTravaux) {
		this.futursTravaux = futursTravaux;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public StatutOrdreReparation getStatutOrdreReparation() {
		return statutOrdreReparation;
	}

	public void setStatutOrdreReparation(StatutOrdreReparation statutOrdreReparation) {
		this.statutOrdreReparation = statutOrdreReparation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateurCloturer() {
		return utilisateurCloturer;
	}

	public void setUtilisateurCloturer(Utilisateur utilisateurCloturer) {
		this.utilisateurCloturer = utilisateurCloturer;
	}

	public Utilisateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Utilisateur formateur) {
		this.formateur = formateur;
	}
		
}
