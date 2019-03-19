package fr.afpa.formation.mecanique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.afpa.formation.mecanique.service.VehiculeService;

@Controller
public class VehiculeController {

	@Autowired
	VehiculeService service;

	@GetMapping("/vehicule")
	public String getvehicules(Model model) throws Exception {
		
		model.addAttribute("vehicules", service.findAll());
		
		return "vehicule";
	}

}
