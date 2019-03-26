package com.leasurecompagnon.appliweb.webapp.converter.locator;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Duree;
import com.leasurecompagnon.appliweb.model.exception.GetDureeFault_Exception;
import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * Bean Locator permettant de récupérer un objet de type {@link Duree}
 * à partir de l'id de cet objet.
 * @author André Monnier
 *
 */
public class DureeLocator extends StrutsTypeConverter {

	// ======================== Attributs =======================
	@Inject
	private ManagerFactory managerFactory;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DureeLocator.class);

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		LOGGER.warn("Appel de la méthode convertFromString ");
		Object vRetour=null;
		if(values!=null) {
			if(values.length==1) {
				String vValue=values[0];	
				try {
					vRetour=StringUtils.isEmpty(vValue)?null:managerFactory.getDureeManager().getDuree(new Integer(vValue));
				} catch (NumberFormatException pE) {
					throw new TypeConversionException("Format d'identifiant durée invalide",pE);
				}
				catch(GetDureeFault_Exception pE) {
					throw new TypeConversionException("Aucune durée ne correspond à l'id demandé",pE);
				}
				
			} else {
				vRetour=performFallbackConversion(context,values,toClass);
			}
		}
		return vRetour;
	}

	@Override
	public String convertToString(Map context, Object o) {
		LOGGER.warn("Appel de la méthode convertToString ");
		String vRetour=null;
		if(o instanceof Duree) {
			Duree vDuree=(Duree) o;
			Integer dureeId= new Integer(vDuree.getId());
			vRetour=dureeId!=null?dureeId.toString():"";
		} else {
			vRetour="";
		}
		return vRetour;
	}
}