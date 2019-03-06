package fr.afpa.formation.mecanique.service;

import java.util.List;

public interface IService <T, E extends Exception> {
	
	
	/**
	 * Récupérer la liste des tous les éléments de l'entité.
	 * @return Retourne une liste de tous les éléments de l'entité.
	 * @throws E Erreur possible: <br> 
	 * 			- Aucune entité disponible.
	 */
	public abstract List<T> findAll() throws E;
	
	/**
	 * Créer une entité dans la base de données.
	 * @param t Necéssite un objet de l'entité pour la créer dans la base de données.
	 * @throws E Erreurs possibles:<br>
	 * 			(1.) L'entité fournie est NULL. <br>
	 * 			(2.) L'entite fournie possède un id non NULL.<br>
	 */
	public abstract T create(T t) throws E;
	
	/**
	 * Récupérer un élément dans la base de données.
	 * @param id Necessite un ID (long) pour récuperer un élément de la base de données.
	 * @return Retourne un objet de l'entité grâce à un ID (long) trouvé dans la base de données.
	 * @throws E Erreur possible:<br>
	 * 			- L'entité est introuvable.
	 */
	public abstract T findById(long id) throws E;
	
	/**
	 * Appliquer une mise à jour d'un élément dans la base de données.
	 * @param t Nécessite un objet de l'entité pour sa mise à jour dans la base de données.
	 * @throws E Erreurs possibles:<br>
	 * 			(1.) L'entité fournie est NULL.
	 * 			(2.) L'entité recherché n'a pas le même ID.
	 */
	public abstract T update(T t) throws E;
	
	/**
	 * Effacer un élément dans la base de données.
	 * @param t Nécessite un objet de l'entité pour sa suppression dans la base de données.
	 * @throws E Erreur possible: <br>
	 * 			- L'entité recherché n'existe pas.
	 */
	public abstract void delete(T t) throws E;
	
	/***
	 * Effacer un élément dans la base de données par son ID
	 * @param id Necessite un ID (long) pour effacer un élément de la base de données.
	 * @throws E Erreur possible: <br>
	 * 			- L'entité recherché n'existe pas.
	 */
	public abstract void deleteById(long id) throws E;


}
