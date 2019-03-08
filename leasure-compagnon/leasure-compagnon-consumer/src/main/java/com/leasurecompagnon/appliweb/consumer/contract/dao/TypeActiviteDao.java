package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.appliweb.model.exception.GetListTypeActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetTypeActiviteFault_Exception;

/**
 * Interface TypeActiviteDao
 * @author André Monnier
 *
 */
public interface TypeActiviteDao {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link TypeActivite} en fonction de son identifiant.
	 * @param typeActiviteId : L'identifiant du type d'activité.
	 * @return Un objet de type {@link TypeActivite}
	 * @throws GetTypeActiviteFault_Exception
	 */
	TypeActivite getTypeActivite(int typeActiviteId) throws GetTypeActiviteFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link TypeActivite}
	 * @return List
	 * @throws GetListTypeActiviteFault_Exception
	 */
	List<TypeActivite> getListTypeActivite() throws GetListTypeActiviteFault_Exception;

}