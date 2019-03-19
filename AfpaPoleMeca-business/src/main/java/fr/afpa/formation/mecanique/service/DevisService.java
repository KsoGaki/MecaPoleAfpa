package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Devis;
import fr.afpa.formation.mecanique.repository.DevisRepository;
@Service
public class DevisService implements IService<Devis, Exception> {
	
	@Autowired
	DevisRepository devisRepo;
	
	
	
	
	@Override
	public List<Devis> findAll() throws Exception {
		
		return (List<Devis>) devisRepo.findAll();
	}

	@Override
	public Devis create(Devis t) throws Exception {		
		return devisRepo.save(t);
	}

	@Override
	public Devis findById(long id) throws Exception {
		return devisRepo.findById(id).get();
	}

	@Override
	public Devis update(Devis t) throws Exception {		
		return devisRepo.save(t);
	}

	@Override
	public void delete(Devis t) throws Exception {
		devisRepo.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		devisRepo.deleteById(id);
		
	}

}
