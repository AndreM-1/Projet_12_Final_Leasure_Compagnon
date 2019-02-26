package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface DureeDao
 * @author André Monnier
 *
 */
public interface DureeDao {

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link Duree}
	 * @return List
	 * @throws TechnicalException
	 */
	List<Duree> getListDuree() throws TechnicalException;

}