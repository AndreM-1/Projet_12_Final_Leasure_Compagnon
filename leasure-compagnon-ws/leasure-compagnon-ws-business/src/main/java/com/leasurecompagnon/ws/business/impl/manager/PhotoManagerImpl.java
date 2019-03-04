package com.leasurecompagnon.ws.business.impl.manager;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.leasurecompagnon.ws.business.contract.manager.PhotoManager;
import com.leasurecompagnon.ws.model.exception.FunctionalException;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager {

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PhotoManagerImpl.class);
	
	@Override
	public void insertPhotoUtilisateur(String nomPhoto, int utilisateurId) throws FunctionalException {
		LOGGER.info("Méthode insertPhotoUtilisateur(String nomPhoto, int utilisateurId)");
		//Utilisation d'un TransactionStatus. On a besoin de lever une FunctionalException,
		//ce qui n'est pas possible avec l'utilisation d'une classe anonyme du transaction template.
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			String provenancePhoto="Non applicable";
			String typePhoto="Profil utilisateur";
			
			//Appel à la DaoFactory
			getDaoFactory().getPhotoDao().insertPhotoUtilisateur(nomPhoto,provenancePhoto,typePhoto,utilisateurId);
			getPlatformTransactionManager().commit(vTransactionStatus);
		} catch (FunctionalException vEx) {
			LOGGER.info(vEx.getMessage());
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new FunctionalException(vEx.getMessage());
		}
	}
}