package fr.afpa.formation.mecanique.controller;

import java.util.ArrayList;
import java.util.List;

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

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	
	@GetMapping("")
	public String getClients(Model model) throws Exception {	
		model.addAttribute("clients", clientService.findAll());	
		return "client";
	}
	
	@GetMapping("/{id}")
	public String getClientById(@PathVariable("id") Long id, Model model) throws Exception {	
		Client client = clientService.findById(id);
		List<OrdreReparation> listOrdreReparation = new ArrayList<OrdreReparation>();
		for(Vehicule vehicule : client.getVehicules()) {
			listOrdreReparation.addAll(vehicule.getListOrdreReparation());
		}
		model.addAttribute("client", client);	
		model.addAttribute("listOrdreReparation", listOrdreReparation);	
		return "fiche/fiche_client";
	}
	
	@RequestMapping("/nouveau")
	public String createClients(@ModelAttribute("client") Client client, Model model) throws Exception {	
		return "new/newClient";
	}
	
	

}
