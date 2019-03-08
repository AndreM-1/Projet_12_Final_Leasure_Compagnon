package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.FormulaireContactManager;
import com.leasurecompagnon.appliweb.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.appliweb.model.exception.EnvoiFormulaireContactFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListFormulaireContactFault_Exception;

@Named
public class FormulaireContactManagerImpl extends AbstractManager implements FormulaireContactManager {
	private List<FormulaireContact> listFormulaireContact;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(FormulaireContactManagerImpl.class);
	
	@Override
	public List<FormulaireContact> getListFormulaireContact() throws GetListFormulaireContactFault_Exception {
		LOGGER.info("Méthode getListFormulaireContact()");
		try {
			listFormulaireContact = getDaoFactory().getFormulaireContactDao().getListFormulaireContact();
		} catch (GetListFormulaireContactFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListFormulaireContactFault_Exception(e.getMessage());
		}
		return listFormulaireContact;	
	}
	
	@Override
	public void envoiFormulaireContact(String nomNa, String adresseMailNa, String objet, String message,
			int utilisateurId) throws EnvoiFormulaireContactFault_Exception {
		LOGGER.info("Méthode envoiFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId)");
		 try {
			 getDaoFactory().getFormulaireContactDao().envoiFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
		} catch (EnvoiFormulaireContactFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new EnvoiFormulaireContactFault_Exception(e.getMessage());
		}
	}
}