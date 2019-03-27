package com.leasurecompagnon.appliweb.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Activite;
import com.leasurecompagnon.appliweb.model.exception.AjoutActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.DeleteActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetActiviteNomFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteRechercheFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleNomFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleTAFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListNomActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateStatutActiviteFault_Exception;

/**
 * Interface ActiviteManager
 * @author André Monnier
 *
 */
public interface ActiviteManager {

	/**
	 * Méthode permettant d'ajouter une activité.
	 * @param activite : Un objet de type {@link Activite}
	 * @throws AjoutActiviteFault_Exception
	 */
	void ajoutActivite(Activite activite) throws AjoutActiviteFault_Exception;
	
	/**
	 * Méthode permettant de renvoyer un objet de type {@link Activite} en fonction de son nom.
	 * @param nomActivite : Le nom de l'activité.
	 * @return Un objet de type {@link Activite}
	 * @throws GetActiviteNomFault_Exception
	 */
	Activite getActiviteNom(String nomActivite) throws GetActiviteNomFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des activités en fonction de leur statut pour une ville donnée.
	 * @param nomVille : Le nom de la ville.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws GetListActiviteVilleNomFault_Exception
	 */
	List<Activite> getListActiviteVilleNom(String nomVille, String statutActivite) throws GetListActiviteVilleNomFault_Exception;

	/**
	 * Méthode permettant de renvoyer une liste d'activités à partir d'une chaîne de caractères recherchée et en fonction du statut de l'activité.
	 * @param nomRecherche : La chaîne de caractères recherchée.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws GetListActiviteRechercheFault_Exception
	 */
	List<Activite> getListActiviteRecherche(String nomRecherche, String statutActivite) throws GetListActiviteRechercheFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des noms de l'ensemble des activités.
	 * @return List
	 * @throws GetListNomActiviteFault_Exception
	 */
	List<String> getListNomActivite() throws GetListNomActiviteFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des activités d'un utilisateur en fonction de leur statut.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws GetListActiviteUtilisateurFault_Exception
	 */
	List<Activite> getListActiviteUtilisateur(int utilisateurId, String statutActivite) throws GetListActiviteUtilisateurFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des activités en fonction de leur type d'activité et de leur statut pour une ville donnée.
	 * @param villeId : L'identifiant de la ville.
	 * @param typeActiviteId : L'identifiant du type d'activité.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws GetListActiviteVilleTAFault_Exception
	 */
	List<Activite> getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite) throws GetListActiviteVilleTAFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des activités en fonction de leur statut pour une ville donnée.
	 * @param villeId : L'identifiant de la ville.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws GetListActiviteVilleFault_Exception
	 */
	List<Activite> getListActiviteVille(int villeId, String statutActivite) throws GetListActiviteVilleFault_Exception;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Activite} en fonction de son identifiant.
	 * @param activiteId : L'identifiant de l'activité.
	 * @return Un objet de type {@link Activite}
	 * @throws GetActiviteFault_Exception
	 */
	Activite getActivite(int activiteId) throws GetActiviteFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des activités en fonction de leur statut.
	 * @param nbActivite : Le nombre d'activités à renvoyer. nbActivite=-1 veut dire sélection de toutes les activités.
	 * @param statutActivite : Le statut de l'activité.
	 * @return List
	 * @throws GetListActiviteFault_Exception
	 */
	List<Activite> getListActivite(int nbActivite, String statutActivite) throws GetListActiviteFault_Exception;

	/**
	 * Méthode permettant de supprimer l'ensemble des informations relatives à une activité de la base de données.
	 * @param activiteId : L'identifiant de l'activité.
	 * @throws DeleteActiviteFault_Exception
	 */
	void deleteActivite(int activiteId) throws DeleteActiviteFault_Exception;

	/**
	 * Méthode permettant de mettre à jour le statut de l'activité ainsi que la date de modération ou de mise 
	 * en ligne pour une activité donnée. 
	 * @param activiteId : L'identifiant de l'activité.
	 * @param statutActiviteId : L'identifiant du statut de l'activité.
	 * @param dateAModifier : La date à mettre à jour.
	 * @throws UpdateStatutActiviteFault_Exception
	 */
	void updateStatutActivite(int activiteId, int statutActiviteId, String dateAModifier) throws UpdateStatutActiviteFault_Exception;
}