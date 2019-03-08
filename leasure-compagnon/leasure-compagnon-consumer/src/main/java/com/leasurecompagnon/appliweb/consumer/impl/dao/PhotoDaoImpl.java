package com.leasurecompagnon.appliweb.consumer.impl.dao;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.appliweb.model.exception.UpdatePhotoUtilisateurFault_Exception;

@Named
public class PhotoDaoImpl extends AbstractDaoImpl implements PhotoDao {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PhotoDaoImpl.class);
	
	@Override
	public void updatePhotoUtilisateur(String nomPhoto, int utilisateurId) throws UpdatePhotoUtilisateurFault_Exception {
		LOGGER.info("Méthode updatePhotoUtilisateur(String nomPhoto, int utilisateurId)");
		try {
			getUtilisateurService().updatePhotoUtilisateur(nomPhoto, utilisateurId);
		} catch (UpdatePhotoUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new UpdatePhotoUtilisateurFault_Exception(e.getMessage());
		}
	}
}