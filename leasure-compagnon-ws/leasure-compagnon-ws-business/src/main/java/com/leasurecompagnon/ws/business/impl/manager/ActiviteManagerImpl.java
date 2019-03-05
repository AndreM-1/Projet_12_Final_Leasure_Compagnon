package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.ActiviteManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class ActiviteManagerImpl extends AbstractManager implements ActiviteManager  {
	
	private List<Activite> listActivite;
	private List<String> listNomActivite;
	private Activite activite;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(ActiviteManagerImpl.class);
	
	@Override
	public Activite getActivite(int activiteId) throws NotFoundException {
		LOGGER.info("Méthode getActivite(int activiteId)");
		try {
			activite=getDaoFactory().getActiviteDao().getActivite(activiteId);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return activite;
	}
	
	@Override
	public List<Activite> getListActivite(int nbActivite, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActivite(int nbActivite, String statutActivite)");
		try {
			listActivite=getDaoFactory().getActiviteDao().getListActivite(nbActivite,statutActivite);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteVille(int villeId, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActiviteVille(int villeId, String statutActivite)");
		try {
			listActivite=getDaoFactory().getActiviteDao().getListActiviteVille(villeId, statutActivite);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listActivite;
	}
	
	
	@Override
	public List<Activite> getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite) throws NotFoundException{
		LOGGER.info("Méthode getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite)");
		try {
			listActivite=getDaoFactory().getActiviteDao().getListActiviteVilleTA(villeId, typeActiviteId, statutActivite);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteUtilisateur(int utilisateurId, String statutActivite) throws NotFoundException{
		LOGGER.info("Méthode getListActiviteUtilisateur(int utilisateurId, String statutActivite)");
		try {
			listActivite=getDaoFactory().getActiviteDao().getListActiviteUtilisateur(utilisateurId, statutActivite);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<String> getListNomActivite() throws TechnicalException {
		LOGGER.info("Méthode getListNomActivite()");
		try {
			listNomActivite=getDaoFactory().getActiviteDao().getListNomActivite();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listNomActivite;
	}
	
	@Override
	public List<Activite> getListActiviteRecherche(String nomRecherche, String statutActivite) throws FunctionalException, NotFoundException{
		LOGGER.info("Méthode getListActiviteRecherche(String nomRecherche, String statutActivite)");
		nomRecherche=nomRecherche.trim().replaceAll(" ", "").toLowerCase();
		if(nomRecherche.length()<3)
			throw new FunctionalException("Le nombre de caractères renseigné n'est pas suffisant. Veuillez renseigner au moins 3 caractères.");
		
		nomRecherche="%"+nomRecherche+"%";
		LOGGER.info("nomRecherche = "+nomRecherche);
		try {
			listActivite=getDaoFactory().getActiviteDao().getListActiviteRecherche(nomRecherche, statutActivite);
			LOGGER.info("Taille de la liste d'activités : "+listActivite.size());
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteVille(String nomVille, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActiviteVille(String nomVille, String statutActivite)");
		try {
			listActivite=getDaoFactory().getActiviteDao().getListActiviteVille(nomVille, statutActivite);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listActivite;
	}
	
	@Override
	public Activite getActivite(String nomActivite) throws NotFoundException {
		LOGGER.info("Méthode getActivite(String nomActivite)");
		try {
			activite=getDaoFactory().getActiviteDao().getActivite(nomActivite);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return activite;
	}
}