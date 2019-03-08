package com.leasurecompagnon.appliweb.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Pays;
import com.leasurecompagnon.appliweb.model.exception.GetListPaysFault_Exception;

@Named
public class PaysDaoImpl extends AbstractDaoImpl implements PaysDao {
	
	private List<Pays> listPays;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PaysDaoImpl.class);

	@Override
	public List<Pays> getListPays() throws GetListPaysFault_Exception {
		LOGGER.info("Méthode getListPays()");
		try {
			listPays = getCatalogueService().getListPays();
		} catch (GetListPaysFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListPaysFault_Exception(e.getMessage());
		}
		return listPays;
	}
}