package com.leasurecompagnon.ws.webapp.formulairecontactservice.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.ManagerFactory;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;
import com.leasurecompagnon.ws.webapp.formulairecontactservice.generated.EnvoiFormulaireContactFault;
import com.leasurecompagnon.ws.webapp.formulairecontactservice.generated.EnvoiFormulaireContactFault_Exception;
import com.leasurecompagnon.ws.webapp.formulairecontactservice.generated.FormulaireContactService;
import com.leasurecompagnon.ws.webapp.formulairecontactservice.generated.GetListFormulaireContactFault;
import com.leasurecompagnon.ws.webapp.formulairecontactservice.generated.GetListFormulaireContactFault_Exception;

public class FormulaireContactServiceImpl implements FormulaireContactService{
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private List<FormulaireContact> listFormulaireContact;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(FormulaireContactServiceImpl.class);
	
	@Override
	public List<FormulaireContact> getListFormulaireContact() throws GetListFormulaireContactFault_Exception {
		LOGGER.info("Méthode getListFormulaireContact()");
		try {
			listFormulaireContact=managerFactory.getFormulaireContactManager().getListFormulaireContact();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListFormulaireContactFault getListFormulaireContactFault = new GetListFormulaireContactFault();
			getListFormulaireContactFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListFormulaireContactFault_Exception(tExc.getMessage(),getListFormulaireContactFault);	
		}
		return listFormulaireContact;
	}

	@Override
	public void envoiFormulaireContact(String nomNa, String adresseMailNa, String objet, String message,
			int utilisateurId) throws EnvoiFormulaireContactFault_Exception {
		LOGGER.info("Méthode envoiFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId)");
		try {
			managerFactory.getFormulaireContactManager().insertFormulaireContact(nomNa, adresseMailNa, objet, message,utilisateurId);
		} catch (FunctionalException fExc) {
			LOGGER.info(fExc.getMessage());
			EnvoiFormulaireContactFault envoiFormulaireContactFault = new EnvoiFormulaireContactFault();
			envoiFormulaireContactFault.setFaultMessageErreur(fExc.getMessage());
			throw new EnvoiFormulaireContactFault_Exception(fExc.getMessage(),envoiFormulaireContactFault);
		}
	}
}
