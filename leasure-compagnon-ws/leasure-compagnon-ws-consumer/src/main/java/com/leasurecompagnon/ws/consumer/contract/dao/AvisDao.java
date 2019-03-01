package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Interface AvisDao
 * @author André Monnier
 *
 */
public interface AvisDao {

	/**
	 * Méthode permettant de renvoyer la liste des avis en fonction de leur statut pour une activité donnée.
	 * @param activiteId : L'identifiant de l'activité.
	 * @param statutAvis : Le statut de l'avis.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Avis> getListAvisActivite(int activiteId, String statutAvis) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des avis d'un utilisateur en fonction de leur statut.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @param statutAvis : Le statut de l'avis.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws NotFoundException;

}