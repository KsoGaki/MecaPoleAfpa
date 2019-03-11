package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.Vehicule;
import fr.afpa.formation.mecanique.repository.VehiculeRepository;

@Service
public class VehiculeService implements IService<Vehicule, Exception>{
	
	@Autowired
	VehiculeRepository vehiculeRepository;

	@Override
	public List<Vehicule> findAll() throws Exception {
		List<Vehicule> list = (List<Vehicule>) vehiculeRepository.findAll();
		
		return list;
	}

	@Override
	public Vehicule create(Vehicule t) throws Exception {
		return vehiculeRepository.save(t);
	}

	@Override
	public Vehicule findById(long id) throws Exception {
		return vehiculeRepository.findById(id).get();
	}

	@Override
	public Vehicule update(Vehicule t) throws Exception {
		return vehiculeRepository.save(t);
	}

	@Override
	public void delete(Vehicule t) throws Exception {
		vehiculeRepository.delete(t);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		vehiculeRepository.deleteById(id);
		
	}
	
}
