package fr.afpa.formation.mecanique.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.afpa.formation.mecanique.entity.Client;
import fr.afpa.formation.mecanique.entity.Vehicule;
import fr.afpa.formation.mecanique.service.VehiculeService;

@Controller
@RequestMapping(value="/vehicule")
public class VehiculeController {

	@Autowired
	VehiculeService service;


	@RequestMapping(value="/nouveau", method=RequestMethod.POST)
	public String getvehicules(@ModelAttribute("client") Client client, 
			@ModelAttribute("vehicule") Vehicule vehicule, HttpSession httpSession) throws Exception {
		httpSession.setAttribute("client", client);
		return "new/newVehicule";
	}

}
