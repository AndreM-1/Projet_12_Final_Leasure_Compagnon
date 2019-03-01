package com.leasurecompagnon.ws.consumer.contract.dao;

import com.leasurecompagnon.ws.model.bean.catalogue.StatutActiviteAvis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Interface StatutActiviteAvisDao
 * @author André Monnier
 *
 */
public interface StatutActiviteAvisDao {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link StatutActiviteAvis} en fonction de son identifiant.
	 * @param statutActiviteAvisId : L'identifiant du statut de l'activité ou de l'avis.
	 * @return Un objet de type {@link StatutActiviteAvis}
	 * @throws NotFoundException
	 */
	StatutActiviteAvis getStatutActiviteAvis(int statutActiviteAvisId) throws NotFoundException;
}