package com.leasurecompagnon.ws.consumer.contract.dao;

import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface UtilisateurDao
 * @author André Monnier
 *
 */
public interface UtilisateurDao {

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Utilisateur} en fonction de son identifiant.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @return Un objet de type {@link Utilisateur}
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer un utilisateur en fonction de son adresse mail.
	 * @param adresseMail : L'adresse mail de l'utilisateur
	 * @return Un objet de type {@link Utilisateur}
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateur(String adresseMail) throws NotFoundException;

	/**
	 * Méthode permettant d'enregistrer un utilisateur en base de données.
	 * @param utilisateur : L'utilisateur.
	 * @throws FunctionalException
	 */
	void insertUtilisateur(Utilisateur utilisateur) throws FunctionalException;

	/**
	 * Méthode permettant de mettre à jour les informations relatives à l'utilisateur.
	 * @param utilisateur : L'utilisateur.
	 * @throws FunctionalException
	 */
	void updateCoordUtilisateur(Utilisateur utilisateur) throws FunctionalException;

	/**
	 * Méthode permettant de mettre à jour le mot de passe de l'utilisateur.
	 * @param utilisateur : L'utilisateur
	 */
	void updateMdpUtilisateur(Utilisateur utilisateur);

	/**
	 * Méthode permettant de mettre à jour les paramètres de l'utilisateur. Pour l'instant, un seul paramètre est présent, celui permettant
	 * d'activer ou de désactiver l'option de réception de mails informatifs.
	 * @param id : L'id de l'utilisateur
	 * @param envoiMailInformatif : Une variable de type booléenne permettant d'activer ou de désactiver l'option de réception de mails informatifs.
	 * @throws TechnicalException
	 */
	void updateParametresUtilisateur(int id, boolean envoiMailInformatif) throws TechnicalException;

}