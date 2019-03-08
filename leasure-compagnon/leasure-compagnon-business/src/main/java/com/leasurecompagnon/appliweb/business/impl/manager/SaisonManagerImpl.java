package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.SaisonManager;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Saison;
import com.leasurecompagnon.appliweb.model.exception.GetListSaisonFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetSaisonFault_Exception;

@Named
public class SaisonManagerImpl extends AbstractManager implements SaisonManager {

	private List<Saison> listSaison;
	private Saison saison;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SaisonManagerImpl.class);
	
	@Override
	public List<Saison> getListSaison() throws GetListSaisonFault_Exception {
		LOGGER.info("Méthode getListSaison()");
		try {
			listSaison =  getDaoFactory().getSaisonDao().getListSaison();
		} catch (GetListSaisonFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListSaisonFault_Exception(e.getMessage());
		}
		return listSaison;
	}
	
	@Override
	public Saison getSaison(int saisonId) throws GetSaisonFault_Exception {
		LOGGER.info("Méthode getSaison(int saisonId)");
		try {
			saison = getDaoFactory().getSaisonDao().getSaison(saisonId);
		} catch (GetSaisonFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetSaisonFault_Exception(e.getMessage());
		}
		return saison;
	}
}