package com.leasurecompagnon.appliweb.webapp.action;

import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.AjoutAvisFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer l'ajout d'avis utilisateur.
 * @author André Monnier
 *
 */
public class GestionAjoutAvisAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1690701874827592242L;
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private int activiteId;
	private String commentaire;
	private String appreciation;
	private String nomActivite;

	// ----- Eléments Struts
	private Map<String, Object> session;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAjoutAvisAction.class);

	
	// ===================== Getters/Setters =====================
	public int getActiviteId() {
		return activiteId;
	}

	public void setActiviteId(int activiteId) {
		this.activiteId = activiteId;
	}
	
	public String getNomActivite() {
		return nomActivite;
	}

	public void setNomActivite(String nomActivite) {
		this.nomActivite = nomActivite;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	
	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;	
	}


	// ===================== Méthodes ============================
	
	/**
	 * Méthode permettant d'ajouter un avis utilisateur.
	 * @return input / success
	 */
	public String doAjoutAvis() {
		LOGGER.info("Méthode doAjoutAvis()");
		String vResult;
		LOGGER.info("Activité id : "+activiteId);
		LOGGER.info("Commentaire : "+commentaire);
		LOGGER.info("Appréciation : "+appreciation);
		//Récupération de la variable de session relative à l'utilisateur.
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		LOGGER.info("Utilisateur Id : "+vUtilisateurSession.getId());
		
		if(commentaire==null && appreciation==null) {
			vResult=ActionSupport.INPUT;
		}else {
			try {
				managerFactory.getAvisManager().ajoutAvis(commentaire, appreciation, vUtilisateurSession.getId(), activiteId);
				vResult=ActionSupport.SUCCESS;
			} catch (AjoutAvisFault_Exception e) {
				LOGGER.info(e.getMessage());
				this.addActionError(e.getMessage());
				vResult=ActionSupport.INPUT;
			}
		}		
		return vResult;
	}
}
