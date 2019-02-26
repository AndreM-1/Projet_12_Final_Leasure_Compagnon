package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface PaysDao
 * @author André Monnier
 *
 */
public interface PaysDao {

	/**
	 * Méthode permettant de renvoyer la liste des pays.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Pays> getListPays() throws TechnicalException;
	
	/**
	 * Méthode permettant de renvoyer un objet de type {@link Pays} en fonction de son identifiant.
	 * @param paysId : L'identifiant du pays.
	 * @return Un objet de type {@link Pays}
	 * @throws NotFoundException
	 */
	Pays getPays(int paysId) throws NotFoundException;

}
