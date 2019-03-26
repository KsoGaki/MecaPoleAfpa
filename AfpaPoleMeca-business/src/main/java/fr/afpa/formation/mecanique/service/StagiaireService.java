package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Stagiaire;
import fr.afpa.formation.mecanique.repository.StagiaireRepository;

@Service
public class StagiaireService implements IService<Stagiaire, Exception>{
	
	@Autowired
	StagiaireRepository stagiaireRepository;

	@Override
	public List<Stagiaire> findAll() throws Exception {
		List<Stagiaire> list = (List<Stagiaire>) stagiaireRepository.findAll();
		
		return list;
	}

	@Override
	public Stagiaire create(Stagiaire t) throws Exception {
		return stagiaireRepository.save(t);
	}

	@Override
	public Stagiaire findById(long id) throws Exception {
		return stagiaireRepository.findById(id).get();
	}

	@Override
	public Stagiaire update(Stagiaire t) throws Exception {
		return stagiaireRepository.save(t);
	}

	@Override
	public void delete(Stagiaire t) throws Exception {
		stagiaireRepository.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		stagiaireRepository.deleteById(id);
		
	}
	
}
