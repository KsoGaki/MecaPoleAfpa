package fr.afpa.formation.mecanique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afpa.formation.mecanique.service.OrdreReparationService;

@Controller
@RequestMapping("/ordreReparation")
public class OrdreReparationController {

	@Autowired
	OrdreReparationService ordreReparationService;

	
	@GetMapping("")
	public String getOrdreReparation(Model model) throws Exception {	
		model.addAttribute("ordreReparation", ordreReparationService.findAll());	
		return "ordreReparation";
	}
	
	@GetMapping("/{id}")
	public String getOrdreReparationById(@PathVariable("id") Long id, Model model) throws Exception {	
		model.addAttribute("ordreReparation", ordreReparationService);	
		return "fiche_ordreReparation";
	}
	
	@GetMapping("/nouveau")
	public String createOrdreReparation() throws Exception {	
		return "newOrdreReparation";
	}
	
	

}
