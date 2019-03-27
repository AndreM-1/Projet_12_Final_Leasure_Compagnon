package com.leasurecompagnon.ws.consumer.contract.dao;

import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.CoordonneeGPS;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

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

	/**
	 * Méthode permettant d'enregistrer les coordonnées GPS dans la table correspondante en base de données
	 * suite à l'ajout d'une activité.
	 * @param activite : Le bean de type {@link Activite}
	 */
	void insertCoordonneeGPSActivite(Activite activite);

	/**
	 * Méthode permettant de supprimer les informations relatives aux coordonnées GPS de l'activité.
	 * @param activiteId : L'identifiant de l'activité.
	 * @throws TechnicalException
	 */
	void deleteCoordonneeGPSActivite(int activiteId) throws TechnicalException;
}