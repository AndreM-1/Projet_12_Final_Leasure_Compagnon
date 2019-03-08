package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.DureeManager;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Duree;
import com.leasurecompagnon.appliweb.model.exception.GetDureeFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListDureeFault_Exception;

@Named
public class DureeManagerImpl extends AbstractManager implements DureeManager {
	
	private List<Duree> listDuree;
	private Duree duree;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DureeManagerImpl.class);
	
	@Override
	public List<Duree> getListDuree() throws GetListDureeFault_Exception {
		LOGGER.info("Méthode getListDuree()");
		try {
			listDuree = getDaoFactory().getDureeDao().getListDuree();
		} catch (GetListDureeFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListDureeFault_Exception (e.getMessage());
		}
		return listDuree;
	}
	
	@Override
	public Duree getDuree(int dureeId) throws GetDureeFault_Exception {
		LOGGER.info("Méthode getDuree(int dureeId)");
		try {
			duree = getDaoFactory().getDureeDao().getDuree(dureeId);
		} catch (GetDureeFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetDureeFault_Exception(e.getMessage());
		}
		return duree;
	}
}