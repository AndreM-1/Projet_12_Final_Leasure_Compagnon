package com.leasurecompagnon.appliweb.webapp.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.EnvoiFormulaireContactFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListFormulaireContactFault_Exception;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Classe d'action permettant de gérer les formulaires de contact {@link FormulaireContact}
 * @author André Monnier
 */
public class GestionFormulaireContactAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -318806885818596546L;
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private int id;
	private String civilite;
	private String pseudo;
	private String nomPhoto;
	private List<FormulaireContact> listFormulaireContact;
	private String nomNa;
	private String adresseMailNa;
	private String objet;
	private String message;
	private boolean validationFormulaire=false;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionFormulaireContactAction.class);
	
	// ===================== Getters/Setters =====================
	public int getId() {
		return id;
	}

	public String getCivilite() {
		return civilite;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}
	
	public List<FormulaireContact> getListFormulaireContact() {
		return listFormulaireContact;
	}
	
	public String getNomNa() {
		return nomNa;
	}

	public void setNomNa(String nomNa) {
		this.nomNa = nomNa;
	}

	public String getAdresseMailNa() {
		return adresseMailNa;
	}

	public void setAdresseMailNa(String adresseMailNa) {
		this.adresseMailNa = adresseMailNa;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isValidationFormulaire() {
		return validationFormulaire;
	}

	public void setValidationFormulaire(boolean validationFormulaire) {
		this.validationFormulaire = validationFormulaire;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;		
	}
	
	// ===================== Méthodes ============================
	
	/**
	 * Méthode permettant de consulter les formulaires de contact.
	 * Les formulaires de contact ne peuvent être consultés que par l'administrateur.
	 * @return success
	 */
	public String doVisuFormContact() {
		LOGGER.info("Méthode doVisuFormContact()");
		String vResult;
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		id=vUtilisateurSession.getId();
		pseudo=vUtilisateurSession.getPseudo();
		civilite=vUtilisateurSession.getCivilite();
		if(vUtilisateurSession.getPhotoUtilisateur()!=null)
			nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();
		
		LOGGER.info("Nom Photo utilisateur : "+nomPhoto);
		try {
			listFormulaireContact=managerFactory.getFormulaireContactManager().getListFormulaireContact();
			vResult=ActionSupport.SUCCESS;
		} catch (GetListFormulaireContactFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
			vResult=ActionSupport.ERROR;
		}
		return vResult;
	}
	
	/**
	 * Méthode permettant d'envoyer un formulaire de contact.
	 * @return input / success
	 */
	public String doEnvoiFormContact() {
		LOGGER.info("Méthode doEnvoiFormContact()");
		String vResult;
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		LOGGER.info("Nom ou pseudo : " +nomNa);
		LOGGER.info("Adresse e-mail : " +adresseMailNa);
		LOGGER.info("Objet : "+objet);
		LOGGER.info("Message : "+message);
		
		//Première entrée dans le formulaire.
		if(!validationFormulaire) {
			validationFormulaire=true;
			vResult=ActionSupport.INPUT;
		}
		//Validation du formulaire
		else {
			//S'il n'y a pas d'utilisateur en session
			if(vUtilisateurSession==null) {
				int utilisateurId=-1;
				try {
					managerFactory.getFormulaireContactManager().envoiFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
					vResult=ActionSupport.SUCCESS;
				} catch (EnvoiFormulaireContactFault_Exception e) {
					LOGGER.info(e.getMessage());
					this.addActionError(e.getMessage());	
					vResult=ActionSupport.INPUT;
				}
			}
			//S'il y a un utilisateur en session
			else {
				int utilisateurId=vUtilisateurSession.getId();
				nomNa=vUtilisateurSession.getPseudo();
				adresseMailNa=vUtilisateurSession.getAdresseMail();
				LOGGER.info("Id utilisateur en session : " +utilisateurId);
				LOGGER.info("Nom ou pseudo utilisateur en session : " +nomNa);
				LOGGER.info("Adresse e-mail utilisateur en session : " +adresseMailNa);
				try {
					managerFactory.getFormulaireContactManager().envoiFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
					vResult=ActionSupport.SUCCESS;
				} catch (EnvoiFormulaireContactFault_Exception e) {
					LOGGER.info(e.getMessage());
					this.addActionError(e.getMessage());
					vResult=ActionSupport.INPUT;
				}
			}
		}
		return vResult;
	}
	
}