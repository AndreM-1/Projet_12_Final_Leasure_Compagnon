package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface FormulaireContactDao
 * @author André Monnier
 *
 */
public interface FormulaireContactDao {

	/**
	 * Méthode permettant de renvoyer la liste de l'ensemble des formulaires de contact.
	 * @return List
	 * @throws TechnicalException
	 */
	List<FormulaireContact> getListFormulaireContact() throws TechnicalException;

	/**
	 * Méthode permettant d'enregistrer un formulaire de contact renseigné par un utilisateur (authentifié ou non) en base de données.
	 * @param nomNa : Le nom ou pseudo de l'utilisateur (utile dans le cas où l'utilisateur n'est pas authentifié).
	 * @param adresseMailNa : L'adresse mail de l'utilisateur (utile dans le cas où l'utilisateur n'est pas authentifié).
	 * @param objet : L'objet du message.
	 * @param message : Le message.
	 * @param utilisateurId : L'identifiant de l'utilisateur (utile dans le cas où l'utilisateur est authentifié).
	 */
	void insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId);

}