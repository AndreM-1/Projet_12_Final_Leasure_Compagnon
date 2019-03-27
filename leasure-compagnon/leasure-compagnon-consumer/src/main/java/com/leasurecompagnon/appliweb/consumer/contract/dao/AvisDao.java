package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Avis;
import com.leasurecompagnon.appliweb.model.exception.AjoutAvisFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.DeleteAvisFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListAvisUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateStatutAvisFault_Exception;

/**
 * Interface AvisDao
 * @author André Monnier
 *
 */
public interface AvisDao {

	/**
	 * Méthode permettant de renvoyer la liste des avis d'un utilisateur en fonction de leur statut.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @param statutAvis : Le statut de l'avis.
	 * @return List
	 * @throws GetListAvisUtilisateurFault_Exception
	 */
	List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws GetListAvisUtilisateurFault_Exception;

	/**
	 * Méthode permettant d'enregistrer un avis posté par un utilisateur sur une activité en base de données.
	 * @param commentaire : Le commentaire de l'utilisateur.
	 * @param appreciation : L'appréciation de l'utilisateur.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @param activiteId : L'identifiant de l'activité.
	 * @throws AjoutAvisFault_Exception
	 */
	void ajoutAvis(String commentaire, String appreciation, int utilisateurId, int activiteId) throws AjoutAvisFault_Exception;

	/**
	 * Méthode permettant de supprimer un avis de la base de données.
	 * @param avisId : L'identifiant de l'avis.
	 * @throws DeleteAvisFault_Exception
	 */
	void deleteAvis(int avisId) throws DeleteAvisFault_Exception;

	/**
	 * Méthode permettant de mettre à jour le statut de l'avis pour un avis donné.
	 * @param avisId : L'identifiant de l'avis.
	 * @param statutAvisId : L'identifiant du statut de l'avis.
	 * @throws UpdateStatutAvisFault_Exception
	 */
	void updateStatutAvis(int avisId, int statutAvisId) throws UpdateStatutAvisFault_Exception;

}