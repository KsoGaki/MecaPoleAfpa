package fr.afpa.formation.mecanique.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afpa.formation.mecanique.entity.Client;
import fr.afpa.formation.mecanique.entity.OrdreReparation;
import fr.afpa.formation.mecanique.entity.Vehicule;
import fr.afpa.formation.mecanique.service.ClientService;
import fr.afpa.formation.mecanique.service.OrdreReparationService;
import fr.afpa.formation.mecanique.service.VehiculeService;

@Controller
@RequestMapping("/ordreReparation")
public class OrdreReparationController {

	@Autowired
	ClientService clientService;

	@Autowired
	VehiculeService vehiculeService;

	@Autowired
	OrdreReparationService ordreReparationService;


	@GetMapping("")
	public String getOrdreReparation(Model model) throws Exception {	
		model.addAttribute("listOrdreReparation", ordreReparationService.findAll());	
		return "ordreReparation";
	}

	@GetMapping("/{id}")
	public String getOrdreReparationById(@PathVariable("id") Long id, Model model) throws Exception {	
		OrdreReparation ordreReparation =  ordreReparationService.findById(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateCirculation = simpleDateFormat.format(ordreReparation.getVehicule().getDateMiseCirculation());
		String dateEntree = simpleDateFormat.format(ordreReparation.getDateEntree());

		model.addAttribute("dateCirculation", dateCirculation);	
		model.addAttribute("dateEntree", dateEntree);	
		model.addAttribute("ordreReparation", ordreReparation);	
		return "fiche/fiche_ordreReparation";
	}

	@RequestMapping(value="/nouveau")
	public String newOrdreReparation(@ModelAttribute("vehicule") Vehicule vehicule,
			@ModelAttribute("ordreReparation") OrdreReparation ordreReparation, HttpSession httpSession) throws Exception {
		httpSession.setAttribute("vehicule", vehicule);
		ordreReparation.setVehicule(vehicule);
		return "new/newOrdreReparation";
	}

	@RequestMapping(value="/create")
	public String createOrdreReparation(@ModelAttribute("ordreReparation") OrdreReparation ordreReparation, HttpSession httpSession) throws Exception {
		Client client = (Client) httpSession.getAttribute("client");
		clientService.create(client);
		httpSession.removeAttribute("client");

		Vehicule vehicule = (Vehicule) httpSession.getAttribute("vehicule");
		vehicule.setClient(client);
		vehiculeService.create(vehicule);
		httpSession.removeAttribute("vehicule");

		ordreReparation.setVehicule(vehicule);
		ordreReparationService.create(ordreReparation);

		return "redirect:/ordreReparation";
	}


}
