package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Departement;
import com.leasurecompagnon.appliweb.model.exception.GetListDepartementFault_Exception;

/**
 * Interface DepartementDao
 * @author André Monnier
 *
 */
public interface DepartementDao {

	/**
	 * Méthode permettant de renvoyer la liste des départements.
	 * @return List
	 * @throws GetListDepartementFault_Exception
	 */
	List<Departement> getListDepartement() throws GetListDepartementFault_Exception;

}