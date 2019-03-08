package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.TypeActiviteManager;
import com.leasurecompagnon.appliweb.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.appliweb.model.exception.GetListTypeActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetTypeActiviteFault_Exception;

@Named
public class TypeActiviteManagerImpl extends AbstractManager implements TypeActiviteManager {

	private List <TypeActivite> listTypeActivite;
	private TypeActivite typeActivite;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(TypeActiviteManagerImpl.class);
	
	@Override
	public List<TypeActivite> getListTypeActivite() throws GetListTypeActiviteFault_Exception  {
		LOGGER.info("Méthode getListTypeActivite()");
		try {
			listTypeActivite = getDaoFactory().getTypeActiviteDao().getListTypeActivite();
		} catch (GetListTypeActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListTypeActiviteFault_Exception(e.getMessage());
		}
		return listTypeActivite;
	}
	
	@Override
	public TypeActivite getTypeActivite(int typeActiviteId) throws GetTypeActiviteFault_Exception {
		LOGGER.info("Méthode getTypeActivite(int typeActiviteId)");
		try {
			typeActivite = getDaoFactory().getTypeActiviteDao().getTypeActivite(typeActiviteId);
		} catch (GetTypeActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetTypeActiviteFault_Exception(e.getMessage());
		}
		return typeActivite;
	}
}