package com.leasurecompagnon.appliweb.consumer.contract.dao;

import javax.xml.datatype.XMLGregorianCalendar;

import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.AuthentifierUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.CreerCompteUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateCoordUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateMdpUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateParametresUtilisateurFault_Exception;

/**
 * Interface UtilisateurDao
 * @author André Monnier
 *
 */
public interface UtilisateurDao {

	/**
	 * Méthode permettant de mettre à jour les paramètres de l'utilisateur. Pour l'instant, un seul paramètre est présent, celui permettant
	 * d'activer ou de désactiver l'option de réception de mails informatifs.
	 * @param id : L'id de l'utilisateur.
	 * @param envoiMailInformatif : Une variable de type booléenne permettant d'activer ou de désactiver l'option de réception de mails informatifs.
	 * @throws UpdateParametresUtilisateurFault_Exception
	 */
	void updateParametresUtilisateur(int id, boolean envoiMailInformatif) throws UpdateParametresUtilisateurFault_Exception;

	/**
	 * Méthode permettant de mettre à jour le mot de passe de l'utilisateur.
	 * @param id : L'id de l'utilisateur.
	 * @param actuelMdp : Le mot de passe actuel de l'utilisateur.
	 * @param nouveauMdp : Le nouveau mot de passe de l'utilisateur.
	 * @param confirmationNouveauMdp : La confirmation du mot de passe.
	 * @throws UpdateMdpUtilisateurFault_Exception
	 */
	void updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp)
			throws UpdateMdpUtilisateurFault_Exception;

	/**
	 * Méthode permettant de mettre à jour les informations relatives à l'utilisateur.
	 * @param id : L'id de l'utilisateur.
	 * @param civilite : La civilité de l'utilisateur.
	 * @param nom : Le nom de l'utilisateur.
	 * @param prenom : Le prénom de l'utilisateur.
	 * @param pseudo : Le pseudo de l'utilisateur.
	 * @param adresseMail : L'adresse Mail de l'utilisateur.
	 * @param telephone : Le téléphone de l'utilisateur.
	 * @param dateNaissance : La date de naissance de l'utilisateur.
	 * @param adresse : L'adresse postale de l'utilisateur.
	 * @param codePostal : Le code postal de l'utilisateur.
	 * @param ville : La ville de l'utilisateur.
	 * @param pays : Le pays de l'utilisateur
	 * @throws UpdateCoordUtilisateurFault_Exception
	 */
	void updateCoordUtilisateur(int id, String civilite, String nom, String prenom, String pseudo, String adresseMail,
			String telephone, XMLGregorianCalendar dateNaissance, String adresse, String codePostal, String ville, String pays)
			throws UpdateCoordUtilisateurFault_Exception;

	/**
	 * Méthode permettant de créer un compte utilisateur.
	 * @param civilite : La civilité de l'utilisateur
	 * @param nom : Le nom de l'utilisateur.
	 * @param prenom : Le prénom de l'utilisateur.
	 * @param pseudo : Le pseudo de l'utilisateur.
	 * @param adresseMail : L'adresse Mail de l'utilisateur.
	 * @param motDePasse : Le mot de passe de l'utilisateur
	 * @param confirmationMotDePasse : La confirmation du mot de passe.
	 * @param conditionsUtilisation : Variable de type booléenne indiquant si les conditions d'utilisation ont été acceptées par l'utilisateur.
	 * @return Un objet de type {@link Utilisateur}.
	 * @throws CreerCompteUtilisateurFault_Exception
	 */
	Utilisateur creerCompteUtilisateur(String civilite, String nom, String prenom, String pseudo, String adresseMail, String motDePasse,
			String confirmationMotDePasse, boolean conditionsUtilisation) throws CreerCompteUtilisateurFault_Exception;

	/**
	 * Méthode permettant d'authentifier un utilisateur.
	 * @param adresseMail : L'adresse mail de l'utilisateur.
	 * @param motDePasse : Le mot de passe de l'utilisateur.
	 * @return Un objet de type {@link Utilisateur}.
	 * @throws AuthentifierUtilisateurFault_Exception
	 */
	Utilisateur authentifierUtilisateur(String adresseMail, String motDePasse) throws AuthentifierUtilisateurFault_Exception;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Utilisateur} en fonction de son identifiant.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @return Un objet de type {@link Utilisateur}.
	 * @throws GetUtilisateurFault_Exception
	 */
	Utilisateur getUtilisateur(int utilisateurId) throws GetUtilisateurFault_Exception;

}