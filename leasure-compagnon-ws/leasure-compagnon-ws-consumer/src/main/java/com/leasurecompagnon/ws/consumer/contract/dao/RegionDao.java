package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface RegionDao
 * @author André Monnier
 *
 */
public interface RegionDao {
	
	/**
	 * Méthode permettant de renvoyer la liste des régions.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Region> getListRegion() throws TechnicalException;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Region} en fonction de son identifiant.
	 * @param regionId : L'identifiant de la région.
	 * @return Un objet de type {@link Region}
	 * @throws NotFoundException
	 */
	Region getRegion(int regionId) throws NotFoundException;

}