package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface RegionManager
 * @author André Monnier
 *
 */
public interface RegionManager {

	/**
	 * Méthode permettant de renvoyer la liste des régions.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Region> getListRegion() throws TechnicalException;

}