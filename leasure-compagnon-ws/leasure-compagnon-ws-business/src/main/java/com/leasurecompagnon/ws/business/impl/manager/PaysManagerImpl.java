package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.PaysManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class PaysManagerImpl extends AbstractManager implements PaysManager{
	
	private List<Pays> listPays;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PaysManagerImpl.class);
	
	@Override
	public List<Pays> getListPays() throws TechnicalException{
		LOGGER.info("Méthode getListPays()");
		try {
			listPays=getDaoFactory().getPaysDao().getListPays();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listPays;
	}
}