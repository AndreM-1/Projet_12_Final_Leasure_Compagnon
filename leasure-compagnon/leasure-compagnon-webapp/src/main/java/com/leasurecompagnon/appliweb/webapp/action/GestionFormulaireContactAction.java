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

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;		
	}
	
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
}