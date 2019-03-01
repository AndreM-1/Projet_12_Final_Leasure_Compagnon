package com.leasurecompagnon.ws.consumer.contract.dao;

import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Interface UtilisateurDao
 * @author André Monnier
 *
 */
public interface UtilisateurDao {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Utilisateur} en fonction de son identifiant.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @return Un objet de type {@link Utilisateur}
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException;

}