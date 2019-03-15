package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.leasurecompagnon.ws.business.contract.manager.FormulaireContactManager;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
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
	
	@Override
	public void insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message,
			int utilisateurId) throws FunctionalException {
		LOGGER.info("Méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId)");
		
		//On lève une exception si l'un des champs saisis dans le formulaire de contact n'est pas bon.
		//Il s'agit de l'équivalent de la validation de bean du projet 6.
		if(nomNa.trim().isEmpty()||nomNa.length()>50) {
			throw new FunctionalException("Le champ Nom ou Pseudo n'est pas renseigné correctement.");
		}
		
		if(adresseMailNa.trim().isEmpty()||adresseMailNa.length()>50) {
			throw new FunctionalException("Le champ Adresse e-mail n'est pas renseigné correctement.");
		}
		
		if(objet.equals("-1")) {
			throw new FunctionalException("Veuillez sélectionner un objet dans la liste proposée.");
		}

		if(objet.trim().isEmpty()||objet.length()>50) {
			throw new FunctionalException("Le champ Objet n'est pas renseigné correctement.");
		}
		
		if(message.trim().isEmpty()||message.length()>500) {
			throw new FunctionalException("Le champ Message n'est pas renseigné correctement.");
		}
		
		//Si le formulaire de contact est correctement renseigné, alors on lance la transaction.
		//Utilisation d'un TransactionStatus.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		getDaoFactory().getFormulaireContactDao().insertFormulaireContact(nomNa, adresseMailNa, objet, message,utilisateurId);
		getPlatformTransactionManager().commit(vTransactionStatus);
		
	}
}