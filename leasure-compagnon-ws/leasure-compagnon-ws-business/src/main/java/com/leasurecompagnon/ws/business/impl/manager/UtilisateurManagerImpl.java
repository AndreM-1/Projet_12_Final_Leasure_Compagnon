package com.leasurecompagnon.ws.business.impl.manager;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.UtilisateurManager;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {
	
	private Utilisateur utilisateur;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(UtilisateurManagerImpl.class);
	
	@Override
	public Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException {
		LOGGER.info("getUtilisateur(int utilisateurId)");
		try {
			utilisateur=getDaoFactory().getUtilisateurDao().getUtilisateur(utilisateurId);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return utilisateur;
	}
}