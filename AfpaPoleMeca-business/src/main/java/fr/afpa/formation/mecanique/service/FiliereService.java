package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Filiere;
import fr.afpa.formation.mecanique.repository.FiliereRepository;

@Service
public class FiliereService implements IService<Filiere, Exception>{
	@Autowired
	FiliereRepository filiereRepository;
	
	@Override
	public List<Filiere> findAll() throws Exception {
		List<Filiere> filieres = (List<Filiere>) filiereRepository.findAll();
		return filieres;
	}

	@Override
	public Filiere create(Filiere t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filiere findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filiere update(Filiere t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Filiere t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
