package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface DureeDao
 * @author André Monnier
 *
 */
public interface DureeDao {

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link Duree}
	 * @return List
	 * @throws TechnicalException
	 */
	List<Duree> getListDuree() throws TechnicalException;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Duree} en fonction de son identifiant.
	 * @param dureeId : L'identifiant de la durée.
	 * @return Un objet de type {@link Duree}
	 * @throws NotFoundException
	 */
	Duree getDuree(int dureeId) throws NotFoundException;

}