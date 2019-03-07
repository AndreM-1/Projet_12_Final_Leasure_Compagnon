package com.leasurecompagnon.ws.testbusiness.business;

import javax.sql.DataSource;

import org.springframework.transaction.PlatformTransactionManager;

import com.leasurecompagnon.ws.business.contract.ManagerFactory;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;

/**
 * Classe mère des classes de test d'intégration de la couche Business.
 * @author André Monnier
 */
public abstract class BusinessTestCase {
	
    static {
        SpringRegistry.init();
    }

    /** {@link ManagerFactory} */
    private static final ManagerFactory MANAGER_FACTORY = SpringRegistry.getManagerFactory();
  
    /** {@link DataSource} */
    private static final DataSource DATA_SOURCE = SpringRegistry.getDataSource();

    /** {@link PlatformTransactionManager} */
    private static final PlatformTransactionManager PLATFORM_TRANSACTION_MANAGER=SpringRegistry.getPlatformTransactionManager(); 
 
    /** {@link DaoFactory} */
    private static final DaoFactory DAO_FACTORY=SpringRegistry.getDaoFactory();

    
	// ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public BusinessTestCase() {}


    // ==================== Getters/Setters ====================
	public static ManagerFactory getManagerFactory() {
		return MANAGER_FACTORY;
	}

	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}

    public static PlatformTransactionManager getPlatformTransactionManager() {
		return PLATFORM_TRANSACTION_MANAGER;
	}

    public static DaoFactory getDaoFactory() {
    	return DAO_FACTORY;
    }
}