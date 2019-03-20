package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Visibilite;
import fr.afpa.formation.mecanique.repository.VisibiliteRepository;

@Service
public class VisibiliteService implements IService<Visibilite, Exception>{
	
	@Autowired
	VisibiliteRepository repo;

	@Override
	public List<Visibilite> findAll() throws Exception {
		
		return (List<Visibilite>) repo.findAll();
	}

	@Override
	public Visibilite create(Visibilite t) throws Exception {
		
		return repo.save(t);
	}

	@Override	
	public Visibilite findById(long id) throws Exception {
		
		return repo.findById(id).get();
	}

	@Override
	public Visibilite update(Visibilite t) throws Exception {
		
		return repo.save(t);
	}

	@Override
	public void delete(Visibilite t) throws Exception {
		repo.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		repo.deleteById(id);
		
	}

}
