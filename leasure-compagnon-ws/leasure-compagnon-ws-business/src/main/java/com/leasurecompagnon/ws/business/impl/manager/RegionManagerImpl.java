package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.RegionManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class RegionManagerImpl extends AbstractManager implements RegionManager {
	
	private List<Region> listRegion;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(RegionManagerImpl.class);
	
	@Override
	public List<Region> getListRegion() throws TechnicalException{
		LOGGER.info("Méthode getListRegion()");
		try {
			listRegion=getDaoFactory().getRegionDao().getListRegion();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listRegion;
	}
}