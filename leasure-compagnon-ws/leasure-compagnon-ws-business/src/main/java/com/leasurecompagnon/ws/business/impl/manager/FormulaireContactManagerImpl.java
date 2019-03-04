package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.FormulaireContactManager;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class FormulaireContactManagerImpl extends AbstractManager implements FormulaireContactManager {
	
	private List<FormulaireContact> listFormulaireContact;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(FormulaireContactManagerImpl.class);
	
	@Override
	public List<FormulaireContact> getListFormulaireContact() throws TechnicalException {
		LOGGER.info("Méthode getListFormulaireContact()");
		try {
			listFormulaireContact=getDaoFactory().getFormulaireContactDao().getListFormulaireContact();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listFormulaireContact;
	}
}