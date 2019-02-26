package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface PaysManager
 * @author André Monnier
 *
 */
public interface PaysManager {

	/**
	 * Méthode permettant de renvoyer la liste des pays.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Pays> getListPays() throws TechnicalException;

}