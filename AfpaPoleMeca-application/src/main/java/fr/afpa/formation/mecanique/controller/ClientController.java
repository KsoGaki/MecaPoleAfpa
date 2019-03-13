package fr.afpa.formation.mecanique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.afpa.formation.mecanique.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;

	
	@GetMapping("/client")
	public String getClients(Model model) throws Exception {	
		model.addAttribute("clients", clientService.findAll());	
		return "client";
	}
	
	@GetMapping("/client/{id}/")
	public String getClientById(@PathVariable("id") Long id, Model model) throws Exception {	
		model.addAttribute("clients", clientService.findById(id));	
		return "fiche_client";
	}
	
	

}
