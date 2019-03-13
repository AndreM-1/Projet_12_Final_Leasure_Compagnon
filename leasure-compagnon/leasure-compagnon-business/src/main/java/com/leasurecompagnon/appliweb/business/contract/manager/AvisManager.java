package com.leasurecompagnon.appliweb.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Avis;
import com.leasurecompagnon.appliweb.model.exception.GetListAvisUtilisateurFault_Exception;

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
	 * @throws GetListAvisUtilisateurFault_Exception
	 */
	List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws GetListAvisUtilisateurFault_Exception;

}