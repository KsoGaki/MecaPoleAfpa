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
	private Utilisateur Utilisateur;
	
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
		Utilisateur = utilisateur;
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
		Utilisateur = utilisateur;
	}
	
	
	
	
	
}
