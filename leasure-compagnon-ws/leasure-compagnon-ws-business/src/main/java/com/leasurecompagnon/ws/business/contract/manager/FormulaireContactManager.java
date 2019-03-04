package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface FormulaireContactManager
 * @author André Monnier
 *
 */
public interface FormulaireContactManager {

	/**
	 * Méthode permettant de renvoyer la liste de l'ensemble des formulaires de contact.
	 * @return List
	 * @throws TechnicalException
	 */
	List<FormulaireContact> getListFormulaireContact() throws TechnicalException;

}