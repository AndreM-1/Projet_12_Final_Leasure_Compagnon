package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface SaisonDao
 * @author André Monnier
 *
 */
public interface SaisonDao {

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link Saison}
	 * @return List
	 * @throws TechnicalException
	 */
	List<Saison> getListSaison() throws TechnicalException;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Saison} en fonction de son identifiant.
	 * @param saisonId : L'identifiant de la saison.
	 * @return Un objet de type {@link Saison}
	 * @throws NotFoundException
	 */
	Saison getSaison(int saisonId) throws NotFoundException;

}