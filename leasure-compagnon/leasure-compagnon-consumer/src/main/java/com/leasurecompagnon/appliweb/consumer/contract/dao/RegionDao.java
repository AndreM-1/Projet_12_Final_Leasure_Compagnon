package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Region;
import com.leasurecompagnon.appliweb.model.exception.GetListRegionFault_Exception;

/**
 * Interface RegionDao
 * @author André Monnier
 *
 */
public interface RegionDao {

	/**
	 * Méthode permettant de renvoyer la liste des régions.
	 * @return List
	 * @throws GetListRegionFault_Exception
	 */
	List<Region> getListRegion() throws GetListRegionFault_Exception;

}