package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.DepartementManager;
import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager{
	
	private List<Departement> listDepartement;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DepartementManagerImpl.class);
	
	@Override
	public List<Departement> getListDepartement() throws TechnicalException{
		LOGGER.info("Méthode getListDepartement()");
		try {
			listDepartement=getDaoFactory().getDepartementDao().getListDepartement();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listDepartement;
	}
}