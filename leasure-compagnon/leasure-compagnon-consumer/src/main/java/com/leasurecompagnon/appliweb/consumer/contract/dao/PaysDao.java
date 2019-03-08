package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Pays;
import com.leasurecompagnon.appliweb.model.exception.GetListPaysFault_Exception;

/**
 * Interface PaysDao
 * @author André Monnier
 *
 */
public interface PaysDao {

	/**
	 * Méthode permettant de renvoyer la liste des pays.
	 * @return List
	 * @throws GetListPaysFault_Exception
	 */
	List<Pays> getListPays() throws GetListPaysFault_Exception;

}