package fr.afpa.formation.mecanique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.entity.RoleUtilisateur;
import fr.afpa.formation.mecanique.repository.RoleUtilisateurRepository;

@Service
public class RoleUtilisateurService implements IService<RoleUtilisateur, Exception> {

	@Autowired
	RoleUtilisateurRepository repo;

	@Override
	public List<RoleUtilisateur> findAll() throws Exception {
		List<RoleUtilisateur> roleUtilisateurs = (List<RoleUtilisateur>) repo.findAll();
		return roleUtilisateurs;
	}

	@Override
	public RoleUtilisateur create(RoleUtilisateur t) throws Exception {

		return null;
	}

	@Override
	public RoleUtilisateur findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleUtilisateur update(RoleUtilisateur t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(RoleUtilisateur t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
