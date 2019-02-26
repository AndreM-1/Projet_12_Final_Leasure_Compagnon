package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface DureeManager
 * @author André Monnier
 *
 */
public interface DureeManager {

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link Duree}
	 * @return List
	 * @throws TechnicalException
	 */
	List<Duree> getListDuree() throws TechnicalException;

}