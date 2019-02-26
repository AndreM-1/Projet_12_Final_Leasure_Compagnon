package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
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

}