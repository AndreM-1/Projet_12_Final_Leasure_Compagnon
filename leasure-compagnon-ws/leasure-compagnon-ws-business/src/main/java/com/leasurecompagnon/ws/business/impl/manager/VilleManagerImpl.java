package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.VilleManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class VilleManagerImpl extends AbstractManager implements VilleManager{
	
	private List<Ville> listVille;	
	
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
}