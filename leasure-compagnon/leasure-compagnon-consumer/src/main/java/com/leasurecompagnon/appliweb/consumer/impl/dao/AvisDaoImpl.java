package com.leasurecompagnon.appliweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.consumer.contract.dao.AvisDao;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Avis;
import com.leasurecompagnon.appliweb.model.exception.AjoutAvisFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.DeleteAvisFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListAvisUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateStatutAvisFault_Exception;

@Named
public class AvisDaoImpl extends AbstractDaoImpl implements AvisDao {

	private List<Avis> listAvis;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AvisDaoImpl.class);
	
	@Override
	public List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws GetListAvisUtilisateurFault_Exception {
		LOGGER.info("Méthode getListAvisUtilisateur(int utilisateurId, String statutAvis)");
		try {
			listAvis = getCatalogueService().getListAvisUtilisateur(utilisateurId, statutAvis);
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
			getCatalogueService().ajoutAvis(commentaire, appreciation, utilisateurId, activiteId);
		} catch (AjoutAvisFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new AjoutAvisFault_Exception(e.getMessage());
		}	
	}
	
	@Override
	public void updateStatutAvis(int avisId, int statutAvisId) throws UpdateStatutAvisFault_Exception {
		LOGGER.info("Méthode updateStatutAvis(int avisId, int statutAvisId)");
		try {
			getCatalogueService().updateStatutAvis(avisId, statutAvisId);
		} catch (UpdateStatutAvisFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new UpdateStatutAvisFault_Exception(e.getMessage());
		}
	}
	
	@Override
	public void deleteAvis(int avisId) throws DeleteAvisFault_Exception {
		LOGGER.info("Méthode deleteAvis(int avisId)");
		try {
			getCatalogueService().deleteAvis(avisId);
		} catch (DeleteAvisFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new DeleteAvisFault_Exception(e.getMessage());
		}
	}
}