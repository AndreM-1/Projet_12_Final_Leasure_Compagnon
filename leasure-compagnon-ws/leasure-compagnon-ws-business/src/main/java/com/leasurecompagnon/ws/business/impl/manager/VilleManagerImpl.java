package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.VilleManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class VilleManagerImpl extends AbstractManager implements VilleManager{
	
	private List<Ville> listVille;	
	private List<String> listNomVille;
	private Ville ville;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(VilleManagerImpl.class);
	
	@Override
	public List<Ville> getListVille(int nbVille) throws TechnicalException {
		LOGGER.info("Méthode getListVille(int nbVille)");
		try {
			listVille=getDaoFactory().getVilleDao().getListVille(nbVille);
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listVille;	
	}
	
	@Override
	public Ville getVille(int villeId) throws NotFoundException {
		LOGGER.info("Méthode getVille(int villeId)");
		try {
			ville=getDaoFactory().getVilleDao().getVille(villeId);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return ville;
	}
	
	@Override
	public List<String> getListNomVille() throws TechnicalException {
		LOGGER.info("Méthode getListNomVille()");
		try {
			listNomVille=getDaoFactory().getVilleDao().getListNomVille();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listNomVille;
	}
	
	@Override
	public List<Ville> getListVilleRecherche(String nomRecherche) throws FunctionalException, NotFoundException {
		LOGGER.info("Méthode getListVilleRecherche(String nomRecherche)");
		nomRecherche=nomRecherche.trim().replaceAll(" ", "").toLowerCase();
		if(nomRecherche.length()<3)
			throw new FunctionalException("Le nombre de caractères renseigné n'est pas suffisant. Veuillez renseigner au moins 3 caractères.");
		
		nomRecherche="%"+nomRecherche+"%";
		LOGGER.info("nomRecherche = "+nomRecherche);
		try {
			listVille=getDaoFactory().getVilleDao().getListVilleRecherche(nomRecherche);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listVille;
	}
}