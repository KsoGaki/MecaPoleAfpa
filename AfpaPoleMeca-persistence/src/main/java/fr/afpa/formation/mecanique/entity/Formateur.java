package fr.afpa.formation.mecanique.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue(value = "FOR")
public class Formateur extends Utilisateur {
	
	@ManyToMany(fetch = FetchType.EAGER,cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="formateur_filiere",joinColumns=@JoinColumn(name="id_Formateur"),inverseJoinColumns=@JoinColumn(name="id_Filiere"))
	private Set<Filiere> listFiliere = new HashSet<Filiere>();

	public Formateur() {

	}

	public Formateur(Long id, String mail, String nom, String prenom, String telephone, String identifiant, RoleUtilisateur roleUtilisateur,
			String motDePasse, Date dateInscription, Date dateRadiation) {
		super(id, mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation, roleUtilisateur);
		// TODO Auto-generated constructor stub
	}

	public Formateur(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse, RoleUtilisateur roleUtilisateur,
			Date dateInscription, Date dateRadiation) {
		super(mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation, roleUtilisateur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Formateur []";
	}

	public Set<Filiere> getListFiliere() {
		return listFiliere;
	}

	public void setListFiliere(Set<Filiere> listFiliere) {
		this.listFiliere = listFiliere;
	}
	
	

}
