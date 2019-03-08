package com.leasurecompagnon.appliweb.business.contract.manager;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.appliweb.model.exception.EnvoiFormulaireContactFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListFormulaireContactFault_Exception;

/**
 * Interface FormulaireContactManager
 * @author André Monnier
 *
 */
public interface FormulaireContactManager {

	/**
	 * Méthode permettant d'envoyer un formulaire de contact renseigné par un utilisateur (authentifié ou non).
	 * @param nomNa : Le nom de l'utilisateur non authentifié.
	 * @param adresseMailNa : L'adresse mail de l'utilisateur non authentifié.
	 * @param objet : L'objet du message.
	 * @param message : Le message de l'utilisateur.
	 * @param utilisateurId : L'identifiant de l'utilisateur (authentifié).
	 * @throws EnvoiFormulaireContactFault_Exception
	 */
	void envoiFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId)
			throws EnvoiFormulaireContactFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste de l'ensemble des formulaires de contact.
	 * @return List
	 * @throws GetListFormulaireContactFault_Exception
	 */
	List<FormulaireContact> getListFormulaireContact() throws GetListFormulaireContactFault_Exception;

}