package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface DepartementDao
 * @author André Monnier
 *
 */
public interface DepartementDao {

	/**
	 * Méthode permettant de renvoyer la liste des départements.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Departement> getListDepartement() throws TechnicalException;
	
	/**
	 * Méthode permettant de renvoyer un objet de type {@link Departement} en fonction de son identifiant.
	 * @param departementId : L'identifiant du département.
	 * @return Un objet de type {@link Departement}
	 * @throws NotFoundException
	 */
	Departement getDepartement(int departementId) throws NotFoundException;

}