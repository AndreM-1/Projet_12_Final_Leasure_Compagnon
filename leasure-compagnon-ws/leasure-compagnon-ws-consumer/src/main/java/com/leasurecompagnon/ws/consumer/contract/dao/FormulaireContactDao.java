package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface FormulaireContactDao
 * @author André Monnier
 *
 */
public interface FormulaireContactDao {

	/**
	 * Méthode permettant de renvoyer la liste de l'ensemble des formulaires de contact.
	 * @return List
	 * @throws TechnicalException
	 */
	List<FormulaireContact> getListFormulaireContact() throws TechnicalException;

}