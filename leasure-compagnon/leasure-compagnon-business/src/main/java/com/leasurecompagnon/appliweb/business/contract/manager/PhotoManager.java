package com.leasurecompagnon.appliweb.business.contract.manager;

import com.leasurecompagnon.appliweb.model.exception.UpdatePhotoUtilisateurFault_Exception;

/**
 * Interface PhotoManager
 * @author André Monnier
 *
 */
public interface PhotoManager {

	/**
	 * Méthode permettant de mettre à jour la photo de profil d'un utilisateur.
	 * @param nomPhoto : Le nom de la photo.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @throws UpdatePhotoUtilisateurFault_Exception
	 */
	void updatePhotoUtilisateur(String nomPhoto, int utilisateurId) throws UpdatePhotoUtilisateurFault_Exception;

}