package com.leasurecompagnon.appliweb.business.impl.manager;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.PhotoManager;
import com.leasurecompagnon.appliweb.model.exception.UpdatePhotoUtilisateurFault_Exception;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PhotoManagerImpl.class);
	
	@Override
	public void updatePhotoUtilisateur(String nomPhoto, int utilisateurId) throws UpdatePhotoUtilisateurFault_Exception {
		LOGGER.info("Méthode updatePhotoUtilisateur(String nomPhoto, int utilisateurId)");
		try {
			getDaoFactory().getPhotoDao().updatePhotoUtilisateur(nomPhoto, utilisateurId);
		} catch (UpdatePhotoUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new UpdatePhotoUtilisateurFault_Exception(e.getMessage());
		}
	}
}