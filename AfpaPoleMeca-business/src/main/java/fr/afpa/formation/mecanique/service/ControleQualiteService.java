package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.ControleQualite;
import fr.afpa.formation.mecanique.repository.ControleQualiteRepository;

@Service
public class ControleQualiteService implements IService<ControleQualite, Exception>{
	
	@Autowired
	ControleQualiteRepository controleQualiteRepository;

	@Override
	public List<ControleQualite> findAll() throws Exception {
		List<ControleQualite> list = (List<ControleQualite>) controleQualiteRepository.findAll();
		
		return list;
	}

	@Override
	public ControleQualite create(ControleQualite t) throws Exception {
		return controleQualiteRepository.save(t);
	}

	@Override
	public ControleQualite findById(long id) throws Exception {
		return controleQualiteRepository.findById(id).get();
	}

	@Override
	public ControleQualite update(ControleQualite t) throws Exception {
		return controleQualiteRepository.save(t);
	}

	@Override
	public void delete(ControleQualite t) throws Exception {
		controleQualiteRepository.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		controleQualiteRepository.deleteById(id);
		
	}
	
}
