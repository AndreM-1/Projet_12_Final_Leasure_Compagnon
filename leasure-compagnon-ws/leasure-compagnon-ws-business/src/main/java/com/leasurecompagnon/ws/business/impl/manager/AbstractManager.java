package com.leasurecompagnon.ws.business.impl.manager;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.transaction.PlatformTransactionManager;

import com.leasurecompagnon.ws.consumer.contract.DaoFactory;


/**
 * Classe permettant de définir une DaoFactory, un platformTransactionManager (utilisé
 * dans un contexte transactionnel) et un validateur de contraintes qui seront utilisés par
 * les implémentations de la couche business.
 * @author André Monnier
 */
public abstract class AbstractManager {
	
    private static DaoFactory daoFactory; 
	
	private static PlatformTransactionManager platformTransactionManager;

	public static DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public static void setDaoFactory(DaoFactory daoFactory) {
		AbstractManager.daoFactory = daoFactory;
	}

	public static PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public static void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		AbstractManager.platformTransactionManager = platformTransactionManager;
	}
	
	/**
     * Méthode permettant de renvoyer un {@link Validator} de contraintes
     * @return Validator
     */
    protected Validator getConstraintValidator() {
        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();		
        Validator vValidator = vFactory.getValidator();
        return vValidator;
    }
}