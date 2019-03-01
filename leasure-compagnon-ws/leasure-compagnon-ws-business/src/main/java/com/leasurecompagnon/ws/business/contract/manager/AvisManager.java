package com.leasurecompagnon.ws.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Interface AvisManager
 * @author André Monnier
 *
 */
public interface AvisManager {

	/**
	 * Méthode permettant de renvoyer la liste des avis d'un utilisateur en fonction de leur statut.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @param statutAvis : Le statut de l'avis.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws NotFoundException;

}