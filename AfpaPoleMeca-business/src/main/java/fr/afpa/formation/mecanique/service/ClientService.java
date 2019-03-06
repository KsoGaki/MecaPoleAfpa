package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Client;
import fr.afpa.formation.mecanique.repository.ClientRepository;

@Service
public class ClientService implements IService<Client, Exception>{
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> findAll() throws Exception {
		List<Client> list = (List<Client>) clientRepository.findAll();
		
		return list;
	}

	@Override
	public Client create(Client t) throws Exception {
		return clientRepository.save(t);
	}

	@Override
	public Client findById(long id) throws Exception {
		return clientRepository.findById(id).get();
	}

	@Override
	public Client update(Client t) throws Exception {
		return clientRepository.save(t);
	}

	@Override
	public void delete(Client t) throws Exception {
		clientRepository.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		clientRepository.deleteById(id);
		
	}
	
}
