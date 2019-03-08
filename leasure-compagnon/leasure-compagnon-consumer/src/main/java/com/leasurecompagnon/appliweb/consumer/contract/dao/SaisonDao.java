package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Saison;
import com.leasurecompagnon.appliweb.model.exception.GetListSaisonFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetSaisonFault_Exception;

/**
 * Interface SaisonDao
 * @author André Monnier
 *
 */
public interface SaisonDao {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Saison} en fonction de son identifiant.
	 * @param saisonId : L'identifiant de la saison.
	 * @return Un objet de type {@link Saison}
	 * @throws GetSaisonFault_Exception
	 */
	Saison getSaison(int saisonId) throws GetSaisonFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link Saison}
	 * @return List
	 * @throws GetListSaisonFault_Exception
	 */
	List<Saison> getListSaison() throws GetListSaisonFault_Exception;

}