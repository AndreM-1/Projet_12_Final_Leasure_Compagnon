package com.leasurecompagnon.appliweb.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Departement;
import com.leasurecompagnon.appliweb.model.exception.GetListDepartementFault_Exception;

/**
 * Interface DepartementManager
 * @author André Monnier
 *
 */
public interface DepartementManager {

	/**
	 * Méthode permettant de renvoyer la liste des départements.
	 * @return List
	 * @throws GetListDepartementFault_Exception
	 */
	List<Departement> getListDepartement() throws GetListDepartementFault_Exception;

}