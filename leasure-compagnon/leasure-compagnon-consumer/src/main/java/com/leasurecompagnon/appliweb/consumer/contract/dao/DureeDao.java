package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Duree;
import com.leasurecompagnon.appliweb.model.exception.GetDureeFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListDureeFault_Exception;

/**
 * Interface DureeDao
 * @author André Monnier
 *
 */
public interface DureeDao {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Duree} en fonction de son identifiant.
	 * @param dureeId : L'identifiant de la durée.
	 * @return Un objet de type {@link Duree}
	 * @throws GetDureeFault_Exception
	 */
	Duree getDuree(int dureeId) throws GetDureeFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link Duree}
	 * @return List
	 * @throws GetListDureeFault_Exception
	 */
	List<Duree> getListDuree() throws GetListDureeFault_Exception;

}