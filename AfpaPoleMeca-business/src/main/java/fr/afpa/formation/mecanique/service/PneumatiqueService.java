package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Pneumatique;
import fr.afpa.formation.mecanique.repository.PneumatiqueRepository;

@Service
public class PneumatiqueService implements IService<Pneumatique, Exception>{
	
	@Autowired
	PneumatiqueRepository repo;

	@Override
	public List<Pneumatique> findAll() throws Exception {
		
		return (List<Pneumatique>) repo.findAll();
	}

	@Override
	public Pneumatique create(Pneumatique t) throws Exception {
		
		return repo.save(t);
	}

	@Override
	public Pneumatique findById(long id) throws Exception {
		
		return repo.findById(id).get();
	}

	@Override
	public Pneumatique update(Pneumatique t) throws Exception {
		
		return repo.save(t);
	}

	@Override
	public void delete(Pneumatique t) throws Exception {
		repo.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		repo.deleteById(id);
		
	}

}
