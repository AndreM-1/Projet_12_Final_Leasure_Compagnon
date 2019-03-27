package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

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
	 * @param utilisateurId : L'identifiant de l'utilisateur. Une valeur de -1 permet de sélectionner tous les utilisateurs.
	 * @param statutAvis : Le statut de l'avis.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws NotFoundException;

	/**
	 * Méthode permettant d'enregistrer un avis posté par un utilisateur sur une activité en base de données.
	 * @param commentaire : Le commentaire de l'utilisateur.
	 * @param appreciation : L'appréciation de l'utilisateur.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @param activiteId : L'identifiant de l'activité.
	 */
	void insertAvis(String commentaire, String appreciation, int utilisateurId, int activiteId);

	/**
	 * Méthode permettant de mettre à jour le statut de l'avis pour un avis donné.
	 * @param avisId : L'identifiant de l'avis.
	 * @param statutAvisId : L'identifiant du statut de l'avis.
	 * @throws TechnicalException
	 */
	void updateStatutAvis(int avisId, int statutAvisId) throws TechnicalException;

	/**
	 * Méthode permettant de supprimer un avis de la base de données.
	 * @param avisId : L'identifiant de l'avis.
	 * @throws TechnicalException
	 */
	void deleteAvis(int avisId) throws TechnicalException;

}