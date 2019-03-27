package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.leasurecompagnon.ws.business.contract.manager.AvisManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class AvisManagerImpl extends AbstractManager implements AvisManager{

	private List<Avis> listAvis;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AvisManagerImpl.class);
	
	@Override
	public List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws NotFoundException {
		LOGGER.info("Méthode getListAvisUtilisateur(int utilisateurId, String statutAvis)");
		try {
			listAvis=getDaoFactory().getAvisDao().getListAvisUtilisateur(utilisateurId, statutAvis);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return listAvis;
	}
	
	@Override
	public void insertAvis(String commentaire, String appreciation, int utilisateurId, int activiteId) throws FunctionalException {
		LOGGER.info("Méthode insertAvis(String commentaire, String appreciation, int utilisateurId, int activiteId)");
		
		//On lève une exception si l'un des champs saisis dans le formulaire d'ajout d'avis n'est pas bon.
		//Il s'agit de l'équivalent de la validation de bean du projet 6.
		if(appreciation.equals("-1")) {
			throw new FunctionalException("Veuillez sélectionner une appréciation dans la liste proposée.");
		}

		if(appreciation.trim().isEmpty()||appreciation.length()>20) {
			throw new FunctionalException("Le champ Appréciation n'est pas renseigné correctement.");
		}
				
		if(commentaire.trim().isEmpty()||commentaire.length()>500) {
			throw new FunctionalException("Le champ Commentaire n'est pas renseigné correctement.");
		}
				
		//Si le formulaire d'ajout d'avis est correctement renseigné, alors on lance la transaction.
		//Utilisation d'un TransactionStatus.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		getDaoFactory().getAvisDao().insertAvis(commentaire,appreciation,utilisateurId,activiteId);
		getPlatformTransactionManager().commit(vTransactionStatus);		
	}
	
	@Override
	public void updateStatutAvis(int avisId, int statutAvisId) throws TechnicalException {
		LOGGER.info("Méthode updateStatutAvis(int avisId, int statutAvisId)");
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une TechnicalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		
		try {
			getDaoFactory().getAvisDao().updateStatutAvis(avisId, statutAvisId);
			getPlatformTransactionManager().commit(vTransactionStatus);
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new TechnicalException(e.getMessage());
		}
	}
	
	@Override
	public void deleteAvis(int avisId) throws TechnicalException {
		LOGGER.info("Méthode deleteAvis(int avisId)");
		
		//Utilisation d'un TransactionStatus. On a besoin de lever une TechnicalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		
		try {
			getDaoFactory().getAvisDao().deleteAvis(avisId);
			getPlatformTransactionManager().commit(vTransactionStatus);
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new TechnicalException(e.getMessage());
		}
	}
}