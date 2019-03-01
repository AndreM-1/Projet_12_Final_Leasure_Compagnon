package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface TypeActiviteDao
 * @author André Monnier
 *
 */
public interface TypeActiviteDao {

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link TypeActivite}
	 * @return List
	 * @throws TechnicalException
	 */
	List<TypeActivite> getListTypeActivite() throws TechnicalException;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link TypeActivite} en fonction de son identifiant.
	 * @param typeActiviteId : L'identifiant du type d'activité.
	 * @return Un objet de type {@link TypeActivite}
	 * @throws NotFoundException
	 */
	TypeActivite getTypeActivite(int typeActiviteId) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des objets de type {@link TypeActivite} associée à une activité en fonction de son identifiant.
	 * @param activiteId : L'identifiant de l'activité.
	 * @return List
	 * @throws NotFoundException
	 */
	List<TypeActivite> getListTypeActivite(int activiteId) throws NotFoundException;

}