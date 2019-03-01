package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface ActiviteDao
 * @author André Monnier
 *
 */
public interface ActiviteDao {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Activite} en fonction de son identifiant.
	 * @param activiteId : L'identifiant de l'activité.
	 * @return Un objet de type {@link Activite}
	 * @throws NotFoundException
	 */
	Activite getActivite(int activiteId) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des activités en fonction de leur statut.
	 * @param nbActivite : Le nombre d'activités à renvoyer. nbActivite=-1 veut dire sélection de toutes les activités.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Activite> getListActivite(int nbActivite, String statutActivite) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des activités en fonction de leur statut pour une ville donnée.
	 * @param villeId : L'identifiant de la ville.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Activite> getListActiviteVille(int villeId, String statutActivite) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des activités en fonction de leur type d'activité et de leur statut pour une ville donnée.
	 * @param villeId : L'identifiant de la ville.
	 * @param typeActiviteId : L'identifiant du type d'activité.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Activite> getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des activités d'un utilisateur en fonction de leur statut.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Activite> getListActiviteUtilisateur(int utilisateurId, String statutActivite) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des noms de l'ensemble des activités.
	 * @return List
	 * @throws TechnicalException
	 */
	List<String> getListNomActivite() throws TechnicalException;

	/**
	 * Méthode permettant de renvoyer une liste d'activités à partir d'une chaîne de caractères recherchée et en fonction du statut de l'activité.
	 * @param nomRecherche : La chaîne de caractères recherchée.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Activite> getListActiviteRecherche(String nomRecherche, String statutActivite) throws NotFoundException;

}