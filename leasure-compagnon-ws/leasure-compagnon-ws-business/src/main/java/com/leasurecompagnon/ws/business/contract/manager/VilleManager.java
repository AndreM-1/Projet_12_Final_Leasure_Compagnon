package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface VilleManager
 * @author André Monnier
 *
 */
public interface VilleManager {

	/**
	 * Méthode permettant de renvoyer la liste des villes.
	 * @param nbVille : Le nombre de villes à renvoyer. nbVille = -1 veut dire sélection de toutes les villes.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Ville> getListVille(int nbVille) throws TechnicalException;

}