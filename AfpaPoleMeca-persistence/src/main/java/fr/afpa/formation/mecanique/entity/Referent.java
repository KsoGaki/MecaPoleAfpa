
package fr.afpa.formation.mecanique.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "REF")
public class Referent extends Utilisateur {

	public Referent() {
		// TODO Auto-generated constructor stub
	}

	public Referent(Long id, String mail, String nom, String prenom, String telephone, String identifiant, RoleUtilisateur roleUtilisateur,
			String motDePasse, Date dateInscription, Date dateRadiation) {
		super(id, mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation, roleUtilisateur);
		// TODO Auto-generated constructor stub
	}

	public Referent(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse, RoleUtilisateur roleUtilisateur,
			Date dateInscription, Date dateRadiation) {
		super(mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation, roleUtilisateur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Referent []";
	}

}

