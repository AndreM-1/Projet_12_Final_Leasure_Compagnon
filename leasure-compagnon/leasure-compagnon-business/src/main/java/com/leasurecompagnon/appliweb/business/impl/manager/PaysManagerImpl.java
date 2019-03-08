package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.PaysManager;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Pays;
import com.leasurecompagnon.appliweb.model.exception.GetListPaysFault_Exception;

@Named
public class PaysManagerImpl extends AbstractManager implements PaysManager {

	private List<Pays> listPays;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PaysManagerImpl.class);

	@Override
	public List<Pays> getListPays() throws GetListPaysFault_Exception {
		LOGGER.info("Méthode getListPays()");
		try {
			listPays = getDaoFactory().getPaysDao().getListPays();
		} catch (GetListPaysFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListPaysFault_Exception(e.getMessage());
		}
		return listPays;
	}
}