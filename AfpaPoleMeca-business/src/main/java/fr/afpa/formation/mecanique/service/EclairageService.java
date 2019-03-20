package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Eclairage;
import fr.afpa.formation.mecanique.repository.EclairageRepository;

@Service
public class EclairageService implements IService<Eclairage, Exception>{
	
	@Autowired
	EclairageRepository repo;

	@Override
	public List<Eclairage> findAll() throws Exception {
		
		return (List<Eclairage>) repo.findAll();
	}

	@Override
	public Eclairage create(Eclairage t) throws Exception {
		
		return repo.save(t);
	}

	@Override
	public Eclairage findById(long id) throws Exception {
		
		return repo.findById(id).get();
	}

	@Override
	public Eclairage update(Eclairage t) throws Exception {
		
		return repo.save(t);
	}

	@Override
	public void delete(Eclairage t) throws Exception {
		repo.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		repo.deleteById(id);
		
	}

}
