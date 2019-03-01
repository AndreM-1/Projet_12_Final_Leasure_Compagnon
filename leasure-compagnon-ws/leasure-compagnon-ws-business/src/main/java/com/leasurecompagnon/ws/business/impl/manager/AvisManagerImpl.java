package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.AvisManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

@Named
public class AvisManagerImpl extends AbstractManager implements AvisManager{

	private List<Avis> listAvis;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AvisManagerImpl.class);
	
	@Override
	public List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws NotFoundException {
		LOGGER.info("Méthode getListAvisUtilisateur(int utilisateurId, String statutAvis)");
		try {
			listAvis=getDaoFactory().getAvisDao().getListAvisUtilisateur(utilisateurId, statutAvis);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listAvis;
	}
}