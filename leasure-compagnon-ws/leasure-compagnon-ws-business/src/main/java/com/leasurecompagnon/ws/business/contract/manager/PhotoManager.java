package com.leasurecompagnon.ws.business.contract.manager;

import com.leasurecompagnon.ws.model.exception.FunctionalException;

/**
 * Interface PhotoManager
 * @author André Monnier
 *
 */
public interface PhotoManager {

	/**
	 * Méthode qui permet d'ajouter une photo en base de données pour un utilisateur qui n'a pas de photos de profil.
	 * @param nomPhoto : Le nom de la photo.
	 * @param utilisateurId : L'id de l'utilisateur.
	 * @throws FunctionalException
	 */
	void insertPhotoUtilisateur(String nomPhoto, int utilisateurId) throws FunctionalException;

}