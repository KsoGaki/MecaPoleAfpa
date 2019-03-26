package fr.afpa.formation.mecanique.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afpa.formation.mecanique.entity.Filiere;
import fr.afpa.formation.mecanique.entity.RoleUtilisateur;
import fr.afpa.formation.mecanique.entity.Stagiaire;
import fr.afpa.formation.mecanique.service.FiliereService;
import fr.afpa.formation.mecanique.service.RoleUtilisateurService;
import fr.afpa.formation.mecanique.service.StagiaireService;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {
	
	@Autowired
	StagiaireService stagiaireService;
	@Autowired
	FiliereService filiereService;
	@Autowired
	RoleUtilisateurService roleUtilisateurService;
	
	@GetMapping("")
	public String getStagiaires(Model model) throws Exception {
		List<Stagiaire> stagiaires = stagiaireService.findAll();
		model.addAttribute("stagiaires", stagiaires);
		return "stagiaire";
	}
	

	@GetMapping("/form")
	public String goToStagiaireForm (Model model) throws Exception {
		List<Filiere> filieres = filiereService.findAll();
		Stagiaire st = new Stagiaire();
		model.addAttribute("filiereList", filieres);
		model.addAttribute("stagiaire", st);
		return "newStagiaire";
	}
	
	@PostMapping("/create")
	public String CreateStagiaire (Stagiaire stagiaire) throws Exception {
		List<RoleUtilisateur> ruList = roleUtilisateurService.findAll();
		if(ruList.get(0).getRole().equals("STA")) {
			stagiaire.setRoleUtilisateur(ruList.get(0));
			stagiaire.setDateInscription(new Date());
			stagiaire.setDateRadiation(new Date());
			stagiaireService.create(stagiaire);
		}
			
		
		return "redirect:/stagiaire";
		
	}
}