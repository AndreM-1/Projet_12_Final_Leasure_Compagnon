package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.DureeManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class DureeManagerImpl extends AbstractManager implements DureeManager {
	
	private List<Duree> listDuree;
	private Duree duree;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DureeManagerImpl.class);
	
	@Override
	public List<Duree> getListDuree() throws TechnicalException{
		LOGGER.info("Méthode getListDuree()");
		try {
			listDuree=getDaoFactory().getDureeDao().getListDuree();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listDuree;
	}
	
	@Override
	public Duree getDuree(int dureeId) throws NotFoundException {
		LOGGER.info("Méthode getDuree(int dureeId)");
		try {
			duree=getDaoFactory().getDureeDao().getDuree(dureeId);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return duree;
	}
}