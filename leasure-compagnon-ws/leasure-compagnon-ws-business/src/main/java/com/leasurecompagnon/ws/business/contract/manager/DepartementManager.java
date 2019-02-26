package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface DepartementManager
 * @author André Monnier
 *
 */
public interface DepartementManager {

	/**
	 * Méthode permettant de renvoyer la liste des départements.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Departement> getListDepartement() throws TechnicalException;

}