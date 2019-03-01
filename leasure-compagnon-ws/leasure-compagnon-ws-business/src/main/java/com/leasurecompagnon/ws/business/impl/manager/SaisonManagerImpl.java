package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.SaisonManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class SaisonManagerImpl extends AbstractManager implements SaisonManager{
	
	private List<Saison> listSaison;
	private Saison saison;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SaisonManagerImpl.class);
	
	@Override
	public List<Saison> getListSaison() throws TechnicalException{
		LOGGER.info("Méthode getListSaison()");
		try {
			listSaison=getDaoFactory().getSaisonDao().getListSaison();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listSaison;
	}
	
	@Override
	public Saison getSaison(int saisonId) throws NotFoundException {
		LOGGER.info("Méthode getSaison(int saisonId)");
		try {
			saison=getDaoFactory().getSaisonDao().getSaison(saisonId);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return saison;
	}
}