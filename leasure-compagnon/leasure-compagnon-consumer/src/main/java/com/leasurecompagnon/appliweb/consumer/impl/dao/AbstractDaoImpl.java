package com.leasurecompagnon.appliweb.consumer.impl.dao;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.consumer.generated.catalogueservice.CatalogueService;
import com.leasurecompagnon.appliweb.consumer.generated.formulairecontactservice.FormulaireContactService;
import com.leasurecompagnon.appliweb.consumer.generated.utilisateurservice.UtilisateurService;

/**
 * Classe permettant de définir des objets de type {@link CatalogueService}, {@link FormulaireContactService} et {@link UtilisateurService}
 * qui seront utilisés par les implémentations de la couche Dao pour appeler les méthodes de ces web services.
 * @author André Monnier
 */
public abstract class AbstractDaoImpl {
	
	private CatalogueService catalogueService;
	
	private FormulaireContactService formulaireContactService;
	
	private UtilisateurService utilisateurService;
	
	private static String adresseCatalogueService;
	
	private static String adresseFormulaireContactService;
	
	private static String adresseUtilisateurService;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AbstractDaoImpl.class);

	public static void setAdresseCatalogueService(String adresseCatalogueService) {
		AbstractDaoImpl.adresseCatalogueService = adresseCatalogueService;
	}

	public static void setAdresseFormulaireContactService(String adresseFormulaireContactService) {
		AbstractDaoImpl.adresseFormulaireContactService = adresseFormulaireContactService;
	}

	public static void setAdresseUtilisateurService(String adresseUtilisateurService) {
		AbstractDaoImpl.adresseUtilisateurService = adresseUtilisateurService;
	}

	public CatalogueService getCatalogueService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		LOGGER.info("Adresse Web service -  CatalogueService : "+adresseCatalogueService);
        factory.setAddress(adresseCatalogueService);
        factory.setServiceClass(CatalogueService.class);
        catalogueService=(CatalogueService)factory.create();
		return catalogueService;
	}

	public FormulaireContactService getFormulaireContactService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		LOGGER.info("Adresse Web service -  FormulaireContactService : "+adresseFormulaireContactService);
        factory.setAddress(adresseFormulaireContactService);
        factory.setServiceClass(FormulaireContactService.class);
        formulaireContactService=(FormulaireContactService)factory.create();
		return formulaireContactService;
	}

	public UtilisateurService getUtilisateurService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		LOGGER.info("Adresse Web service -  UtilisateurService : "+adresseUtilisateurService);
		factory.setAddress(adresseUtilisateurService);
		factory.setServiceClass(UtilisateurService.class);
		utilisateurService=(UtilisateurService)factory.create();
		return utilisateurService;
	}
}