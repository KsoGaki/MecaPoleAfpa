package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Client;
import fr.afpa.formation.mecanique.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> findAll(){
		List<Client> list = (List<Client>) clientRepository.findAll();
		
		return list;
		
	}
	
	public Client create(Client cl) {
		return clientRepository.save(cl);
		
	}

}
