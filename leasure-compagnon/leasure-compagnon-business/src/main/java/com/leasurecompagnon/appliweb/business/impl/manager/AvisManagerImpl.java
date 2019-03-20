package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.AvisManager;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Avis;
import com.leasurecompagnon.appliweb.model.exception.AjoutAvisFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListAvisUtilisateurFault_Exception;

@Named
public class AvisManagerImpl extends AbstractManager implements AvisManager {

	private List<Avis> listAvis;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AvisManagerImpl.class);
	
	@Override
	public List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws GetListAvisUtilisateurFault_Exception {
		LOGGER.info("Méthode getListAvisUtilisateur(int utilisateurId, String statutAvis)");
		try {
			listAvis = getDaoFactory().getAvisDao().getListAvisUtilisateur(utilisateurId, statutAvis);
		} catch (GetListAvisUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListAvisUtilisateurFault_Exception(e.getMessage());
		}
		return listAvis;
	}
	
	@Override
	public void ajoutAvis(String commentaire, String appreciation, int utilisateurId, int activiteId) throws AjoutAvisFault_Exception {
		LOGGER.info("Méthode ajoutAvis(String commentaire, String appreciation, int utilisateurId, int activiteId)");
		try {
			getDaoFactory().getAvisDao().ajoutAvis(commentaire, appreciation, utilisateurId, activiteId);
		} catch (AjoutAvisFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new AjoutAvisFault_Exception(e.getMessage());
		}
	}
}