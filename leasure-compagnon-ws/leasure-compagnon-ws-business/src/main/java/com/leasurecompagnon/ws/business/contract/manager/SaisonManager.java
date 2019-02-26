package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface SaisonManager
 * @author André Monnier
 *
 */
public interface SaisonManager {

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link Saison}
	 * @return List
	 * @throws TechnicalException
	 */
	List<Saison> getListSaison() throws TechnicalException;

}