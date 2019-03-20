package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Niveau;
import fr.afpa.formation.mecanique.repository.NiveauRepository;

@Service
public class NiveauService implements IService<Niveau, Exception>{
	
	@Autowired
	NiveauRepository repo;

	@Override
	public List<Niveau> findAll() throws Exception {
		
		return (List<Niveau>) repo.findAll();
	}

	@Override
	public Niveau create(Niveau t) throws Exception {
		
		return repo.save(t);
	}

	@Override
	public Niveau findById(long id) throws Exception {
		
		return repo.findById(id).get();
	}

	@Override
	public Niveau update(Niveau t) throws Exception {
		
		return repo.save(t);
	}

	@Override
	public void delete(Niveau t) throws Exception {
		repo.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		repo.deleteById(id);
		
	}

}
