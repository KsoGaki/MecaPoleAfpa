package fr.afpa.formation.mecanique.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afpa.formation.mecanique.entity.ControleQualite;
import fr.afpa.formation.mecanique.entity.Eclairage;
import fr.afpa.formation.mecanique.entity.Niveau;
import fr.afpa.formation.mecanique.entity.Pneumatique;
import fr.afpa.formation.mecanique.entity.Visibilite;
import fr.afpa.formation.mecanique.service.ControleQualiteService;
import fr.afpa.formation.mecanique.service.EclairageService;
import fr.afpa.formation.mecanique.service.NiveauService;
import fr.afpa.formation.mecanique.service.PneumatiqueService;
import fr.afpa.formation.mecanique.service.VisibiliteService;

@Controller
@RequestMapping("/controlequalite")
public class ControleQualiteController {

	@Autowired
	ControleQualiteService service;
	
	@Autowired
	PneumatiqueService pnService;
	
	@Autowired
	EclairageService ecService;
	
	@Autowired
	NiveauService nvService;
	
	@Autowired
	VisibiliteService vsService;
	

	@GetMapping("/{id}")
	public String getControleQualite(Model model, @PathVariable(name="id") long id) throws Exception {
		ControleQualite cq = service.findById(id);
		
		model.addAttribute("cq", cq);
		
		
		
		
		return "controleQualite";
	}
	
	@GetMapping("")
	public String goToControleQualiteForm(Model model) {
		Pneumatique pn = new Pneumatique(50, 50, 50, 50, 50, 0, 0, 0, 0, 0);
		Niveau nv = new Niveau(false, false, false, false, false);
		Visibilite vs = new Visibilite(false, false, false, false, false, false, false, false, false);
		Eclairage ec = new Eclairage(false, false, false, false, false, false, false, false);	
				
		ControleQualite cq = new ControleQualite(new Date(), (double) 0, null, pn, ec, vs, nv);
		model.addAttribute("cq", cq);
		
		
		return "controleQualite";
		
	}
	
	@PostMapping("/create")
	public String createControleQualite(ControleQualite cq) throws Exception {
		Pneumatique pn = pnService.create(cq.getPneumatique());
		Eclairage ec = ecService.create(cq.getEclairage());
		Niveau nv = nvService.create(cq.getNiveau());
		Visibilite vs = vsService.create(cq.getVisibilite());
		
		cq.setDateDebut(new Date());
		cq.setPneumatique(pn);
		cq.setEclairage(ec);
		cq.setNiveau(nv);
		cq.setVisibilite(vs);
		cq = service.create(cq);
		
		return "redirect:/controlequalite";
		
	}
}
