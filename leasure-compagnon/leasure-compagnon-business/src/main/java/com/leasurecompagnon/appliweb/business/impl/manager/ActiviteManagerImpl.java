package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.ActiviteManager;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Activite;
import com.leasurecompagnon.appliweb.model.exception.AjoutActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.DeleteActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetActiviteNomFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteRechercheFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleNomFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleTAFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListNomActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateStatutActiviteFault_Exception;


@Named
public class ActiviteManagerImpl extends AbstractManager implements ActiviteManager {

	private List<Activite> listActivite;
	private Activite activite;
	private List<String> listNomActivite;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(ActiviteManagerImpl.class);
	
	@Override
	public List<Activite> getListActivite(int nbActivite, String statutActivite) throws GetListActiviteFault_Exception {
		LOGGER.info("Méthode getListActivite(int nbActivite, String statutActivite)");
		try {
			listActivite = getDaoFactory().getActiviteDao().getListActivite(nbActivite, statutActivite);
		} catch (GetListActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListActiviteFault_Exception(e.getMessage());
		}
		return listActivite;
	}	
	
	@Override
	public Activite getActivite(int activiteId) throws GetActiviteFault_Exception {
		LOGGER.info("Méthode getActivite(int activiteId)");
		try {
			activite = getDaoFactory().getActiviteDao().getActivite(activiteId);
		} catch (GetActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetActiviteFault_Exception(e.getMessage());
		}
		return activite;
	}
	
	@Override
	public List<Activite> getListActiviteVille(int villeId, String statutActivite) throws GetListActiviteVilleFault_Exception {
		LOGGER.info("Méthode getListActiviteVille(int villeId, String statutActivite)");
		try {
			listActivite = getDaoFactory().getActiviteDao().getListActiviteVille(villeId, statutActivite);
		} catch (GetListActiviteVilleFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListActiviteVilleFault_Exception(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite) throws GetListActiviteVilleTAFault_Exception {
		LOGGER.info("Méthode getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite)");
		try {
			listActivite = getDaoFactory().getActiviteDao().getListActiviteVilleTA(villeId, typeActiviteId, statutActivite);
		} catch (GetListActiviteVilleTAFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListActiviteVilleTAFault_Exception(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteUtilisateur(int utilisateurId, String statutActivite) throws GetListActiviteUtilisateurFault_Exception {
		LOGGER.info("Méthode getListActiviteUtilisateur(int utilisateurId, String statutActivite)");
		try {
			listActivite = getDaoFactory().getActiviteDao().getListActiviteUtilisateur(utilisateurId, statutActivite);
		} catch (GetListActiviteUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListActiviteUtilisateurFault_Exception(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<String> getListNomActivite() throws GetListNomActiviteFault_Exception {
		LOGGER.info("Méthode getListNomActivite()");
		try {
			listNomActivite = getDaoFactory().getActiviteDao().getListNomActivite();
		} catch (GetListNomActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListNomActiviteFault_Exception(e.getMessage());
		}
		return listNomActivite;
	}
	
	@Override
	public List<Activite> getListActiviteRecherche(String nomRecherche, String statutActivite) throws GetListActiviteRechercheFault_Exception {
		LOGGER.info("Méthode getListActiviteRecherche(String nomRecherche, String statutActivite)");
		try {
			listActivite = getDaoFactory().getActiviteDao().getListActiviteRecherche(nomRecherche, statutActivite);
		} catch (GetListActiviteRechercheFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListActiviteRechercheFault_Exception(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteVilleNom(String nomVille, String statutActivite) throws GetListActiviteVilleNomFault_Exception {
		LOGGER.info("Méthode getListActiviteVilleNom(String nomVille, String statutActivite)");
		try {
			listActivite = getDaoFactory().getActiviteDao().getListActiviteVilleNom(nomVille, statutActivite);
		} catch (GetListActiviteVilleNomFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListActiviteVilleNomFault_Exception(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public Activite getActiviteNom(String nomActivite) throws GetActiviteNomFault_Exception {
		LOGGER.info("Méthode getActiviteNom(String nomActivite)");
		try {
			activite = getDaoFactory().getActiviteDao().getActiviteNom(nomActivite);
		} catch (GetActiviteNomFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetActiviteNomFault_Exception(e.getMessage());
		}
		return activite;
	}
	
	@Override
	public void ajoutActivite(Activite activite) throws AjoutActiviteFault_Exception {
		LOGGER.info("Méthode ajoutActivite(Activite activite)");
		try {
			getDaoFactory().getActiviteDao().ajoutActivite(activite);
		} catch (AjoutActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new AjoutActiviteFault_Exception(e.getMessage());
		}
	}
	
	@Override
	public void updateStatutActivite (int activiteId, int statutActiviteId, String dateAModifier) throws UpdateStatutActiviteFault_Exception {
		LOGGER.info("Méthode updateStatutActivite (int activiteId, int statutActiviteId, String dateAModifier)");
		try {
			getDaoFactory().getActiviteDao().updateStatutActivite(activiteId, statutActiviteId, dateAModifier);
		} catch (UpdateStatutActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new UpdateStatutActiviteFault_Exception(e.getMessage());
		}
	}
	
	@Override
	public void deleteActivite (int activiteId) throws DeleteActiviteFault_Exception {
		LOGGER.info("Méthode deleteActivite (int activiteId)");
		try {
			getDaoFactory().getActiviteDao().deleteActivite(activiteId);
		} catch (DeleteActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new DeleteActiviteFault_Exception(e.getMessage());
		}
	}
}