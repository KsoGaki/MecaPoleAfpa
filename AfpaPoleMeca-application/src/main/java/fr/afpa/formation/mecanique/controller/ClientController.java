package fr.afpa.formation.mecanique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.afpa.formation.mecanique.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService service;

	
	@GetMapping("/client")
	public String getClients(Model model) throws Exception {
		
		model.addAttribute("clients", service.findAll());
		
		return "client";
	}
	

}
