package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.OrdreReparation;
import fr.afpa.formation.mecanique.repository.OrdreReparationRepository;

@Service
public class OrdreReparationService implements IService<OrdreReparation, Exception>{
	
	@Autowired
	OrdreReparationRepository ordreReparationRepository;

	@Override
	public List<OrdreReparation> findAll() throws Exception {
		List<OrdreReparation> listOrdreReparation = (List<OrdreReparation>) ordreReparationRepository.findAll();
		
		return listOrdreReparation;
	}

	@Override
	public OrdreReparation create(OrdreReparation ordreReparation) throws Exception {
		return ordreReparationRepository.save(ordreReparation);
	}

	@Override
	public OrdreReparation findById(long id) throws Exception {
		return ordreReparationRepository.findById(id).get();
	}

	@Override
	public OrdreReparation update(OrdreReparation ordreReparation) throws Exception {
		return ordreReparationRepository.save(ordreReparation);
	}

	@Override
	public void delete(OrdreReparation ordreReparation) throws Exception {
		ordreReparationRepository.delete(ordreReparation);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		ordreReparationRepository.deleteById(id);
		
	}
	
}
