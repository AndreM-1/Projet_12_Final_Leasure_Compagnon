package com.leasurecompagnon.ws.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.manager.TypeActiviteManager;
import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class TypeActiviteManagerImpl extends AbstractManager implements TypeActiviteManager {
	
	private List <TypeActivite> listTypeActivite;
	private TypeActivite typeActivite;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(TypeActiviteManagerImpl.class);
	
	@Override
	public List<TypeActivite> getListTypeActivite() throws TechnicalException {
		LOGGER.info("Méthode getListTypeActivite()");
		try {
			listTypeActivite=getDaoFactory().getTypeActiviteDao().getListTypeActivite();
		} catch (TechnicalException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException(e.getMessage());
		}
		return listTypeActivite;	
	}
	
	@Override
	public TypeActivite getTypeActivite(int typeActiviteId) throws NotFoundException {
		LOGGER.info("Méthode getTypeActivite(int typeActiviteId)");
		try {
			typeActivite=getDaoFactory().getTypeActiviteDao().getTypeActivite(typeActiviteId);
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return typeActivite;
	}
}