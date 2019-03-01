package com.leasurecompagnon.ws.business.contract.manager;

import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Interface UtilisateurManager
 * @author André Monnier
 *
 */
public interface UtilisateurManager {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Utilisateur} en fonction de son identifiant.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @return Un objet de type {@link Utilisateur}
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException;

}