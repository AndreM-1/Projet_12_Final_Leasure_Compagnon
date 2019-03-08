package com.leasurecompagnon.appliweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Saison;
import com.leasurecompagnon.appliweb.model.exception.GetListSaisonFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetSaisonFault_Exception;

@Named
public class SaisonDaoImpl extends AbstractDaoImpl implements SaisonDao {
	
	private List<Saison> listSaison;
	private Saison saison;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SaisonDaoImpl.class);
	
	@Override
	public List<Saison> getListSaison() throws GetListSaisonFault_Exception {
		LOGGER.info("Méthode getListSaison()");
		try {
			listSaison = getCatalogueService().getListSaison();
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
			saison = getCatalogueService().getSaison(saisonId);
		} catch (GetSaisonFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetSaisonFault_Exception(e.getMessage());
		}
		return saison;
	}
}