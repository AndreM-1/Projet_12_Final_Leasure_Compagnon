package com.leasurecompagnon.ws.consumer.contract.dao;

import com.leasurecompagnon.ws.model.bean.catalogue.CoordonneeGPS;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Interface CoordonneeGPSDao
 * @author André Monnier
 *
 */
public interface CoordonneeGPSDao {
	
	/**
	 * Méthode permettant de renvoyer les coordonnées GPS d'une ville en fonction de son identifiant.
	 * @param villeId : L'identifiant de la ville.
	 * @return Un objet de type {@link CoordonneeGPS}
	 * @throws NotFoundException
	 */
	CoordonneeGPS getCoordonneeGPSVille(int villeId) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer les coordonnées GPS d'une activité en fonction de son identifiant.
	 * @param activiteId : L'identifiant de l'activité.
	 * @return Un objet de type {@link CoordonneeGPS}
	 * @throws NotFoundException
	 */
	CoordonneeGPS getCoordonneeGPSActivite(int activiteId) throws NotFoundException;
}