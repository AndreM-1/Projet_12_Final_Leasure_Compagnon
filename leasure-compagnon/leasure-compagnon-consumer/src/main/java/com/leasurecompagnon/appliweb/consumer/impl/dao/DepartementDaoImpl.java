package com.leasurecompagnon.appliweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Departement;
import com.leasurecompagnon.appliweb.model.exception.GetListDepartementFault_Exception;

@Named
public class DepartementDaoImpl extends AbstractDaoImpl implements DepartementDao {
	
	private List<Departement> listDepartement;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DepartementDaoImpl.class);
	
	@Override
	public List<Departement> getListDepartement() throws GetListDepartementFault_Exception {
		LOGGER.info("Méthode getListDepartement()");
		try {
			listDepartement = getCatalogueService().getListDepartement();
		} catch (GetListDepartementFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListDepartementFault_Exception (e.getMessage());
		}
		return listDepartement;
	}
}