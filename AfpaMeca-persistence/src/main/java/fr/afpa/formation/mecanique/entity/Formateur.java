package fr.afpa.formation.mecanique.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FOR")
public class Formateur extends Utilisateur {

	public Formateur() {

	}

	public Formateur(Long id, String mail, String nom, String prenom, String telephone, String identifiant,
			String motDePasse, Date dateInscription, Date dateRadiation) {
		super(id, mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		// TODO Auto-generated constructor stub
	}

	public Formateur(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation) {
		super(mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Formateur []";
	}

}
