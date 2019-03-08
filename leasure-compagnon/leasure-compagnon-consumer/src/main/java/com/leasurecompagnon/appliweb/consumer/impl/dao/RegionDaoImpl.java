package com.leasurecompagnon.appliweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Region;
import com.leasurecompagnon.appliweb.model.exception.GetListRegionFault_Exception;

@Named
public class RegionDaoImpl extends AbstractDaoImpl implements RegionDao {

	private List<Region> listRegion;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(RegionDaoImpl.class);
	
	@Override
	public List<Region> getListRegion() throws GetListRegionFault_Exception {
		LOGGER.info("Méthode getListRegion()");
		try {
			listRegion = getCatalogueService().getListRegion();
		} catch (GetListRegionFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListRegionFault_Exception(e.getMessage());
		}
		return listRegion;
	}
}