package com.leasurecompagnon.appliweb.webapp.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Activite;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Avis;
import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.DeleteAvisFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListAvisUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateStatutActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateStatutAvisFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer la modération des activités et avis.
 * @author André Monnier
 *
 */
public class GestionModerationAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7808992656806706191L;
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private String civilite;
	private String pseudo;
	private String nomPhoto;
	private List<Avis> listAvis;
	private int avisId;
	private List<Activite> listActivite;
	private int activiteId;
	private Activite activite;
	private String latitude;
	private String longitude;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionModerationAction.class);
	
	
	// ===================== Getters/Setters =====================
	public String getCivilite() {
		return civilite;
	}


	public String getPseudo() {
		return pseudo;
	}


	public String getNomPhoto() {
		return nomPhoto;
	}
	
	public List<Avis> getListAvis() {
		return listAvis;
	}
	
	public void setAvisId(int avisId) {
		this.avisId = avisId;
	}
	
	public List<Activite> getListActivite() {
		return listActivite;
	}
	
	public void setActiviteId(int activiteId) {
		this.activiteId = activiteId;
	}

	public Activite getActivite() {
		return activite;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;	
	}
	
	// ===================== Méthodes ============================
	/**
	 * Méthode permettant d'afficher le choix entre les activités ou les avis à modérer.
	 * @return success
	 */
	public String doModerationActiviteAvis() {
		LOGGER.info("Méthode doModerationActiviteAvis()");
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		pseudo=vUtilisateurSession.getPseudo();
		civilite=vUtilisateurSession.getCivilite();
		if(vUtilisateurSession.getPhotoUtilisateur()!=null)
			nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();
		
		return ActionSupport.SUCCESS;	
	}
	
	/**
	 * Méthode permettant de visualiser l'ensemble des avis en cours de modération.
	 * @return input / success
	 */
	public String doListAvisModeration() {
		LOGGER.info("Méthode doListAvisModeration()");
		String vResult;
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		pseudo=vUtilisateurSession.getPseudo();
		civilite=vUtilisateurSession.getCivilite();
		if(vUtilisateurSession.getPhotoUtilisateur()!=null)
			nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();
		
		try {
			listAvis = managerFactory.getAvisManager().getListAvisUtilisateur(-1,"ECDM");
			vResult=ActionSupport.SUCCESS;
		} catch (GetListAvisUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionMessage("Aucun avis en cours de modération pour le moment");
			vResult=ActionSupport.INPUT;
		}
		return vResult;
	}
	
	/**
	 * Méthode permettant de valider un avis qui sera directement mis en ligne.
	 * @return success / error
	 */
	public String doValidationAvis() {
		LOGGER.info("Méthode doValidationAvis()");
		String vResult;
		
		try {
			managerFactory.getAvisManager().updateStatutAvis(avisId, 4);
			vResult=ActionSupport.SUCCESS;
		} catch (UpdateStatutAvisFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
			vResult=ActionSupport.ERROR;
		}
		return vResult;	
	}
	
	/**
	 * Méthode permettant de refuser un avis qui sera directement supprimé de la base de données.
	 * @return success / error
	 */
	public String doRefusAvis() {
		LOGGER.info("Méthode doRefusAvis()");
		String vResult;
		
		try {
			managerFactory.getAvisManager().deleteAvis(avisId);
			vResult=ActionSupport.SUCCESS;
		} catch (DeleteAvisFault_Exception e) {
			this.addActionError(e.getMessage());
			vResult=ActionSupport.ERROR;
		}
		return vResult;		
	}
	
	/**
	 * Méthode permettant de visualiser l'ensemble des activités en cours de modération.
	 * @return input / success
	 */
	public String doListActiviteModeration() {
		LOGGER.info("Méthode doListActiviteModeration()");
		String vResult;
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		pseudo=vUtilisateurSession.getPseudo();
		civilite=vUtilisateurSession.getCivilite();
		if(vUtilisateurSession.getPhotoUtilisateur()!=null)
			nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();
		
		try {
			listActivite = managerFactory.getActiviteManager().getListActivite(-1, "ECDM");
			vResult=ActionSupport.SUCCESS;
		} catch (GetListActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionMessage("Aucune activité en cours de modération pour le moment");
			vResult=ActionSupport.INPUT;
		}
		return vResult;
	}
	
	/**
	 * Méthode permettant de visualiser le détail d'une activité en cours de modération.
	 * @return success / error
	 */
	public String doDetailActiviteModerationAdmin() {
		LOGGER.info("Méthode doDetailActiviteModerationAdmin()");
		String vResult;
		
		try {
			//On récupère l'activité choisie.
			activite = managerFactory.getActiviteManager().getActivite(activiteId);				
			latitude = String.valueOf(activite.getCoordonnee().getLatitude());
			longitude = String.valueOf(activite.getCoordonnee().getLongitude());
			vResult=ActionSupport.SUCCESS;
		} catch (GetActiviteFault_Exception e) {
			LOGGER.info("Aucune activité trouvée. Veuillez nous excuser pour ce problème technique.");
			this.addActionError("Aucune activité trouvée. Veuillez nous excuser pour ce problème technique.");
			vResult=ActionSupport.ERROR;
		}
		return vResult;	
	}
	
	/**
	 * Méthode permettant de valider une activité qui aura un statut du type "Validé" en base de données.
	 * @return success / error
	 */
	public String doValidationActivite() {
		LOGGER.info("Méthode doValidationActivite()");
		String vResult;
		
		try {
			managerFactory.getActiviteManager().updateStatutActivite(activiteId, 2, "DATE_MODERATION_ADMIN");
			vResult=ActionSupport.SUCCESS;
		} catch (UpdateStatutActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
			vResult=ActionSupport.ERROR;
		}
		return vResult;	
	}
	
	/**
	 * Méthode permettant de refuser une activité qui aura un statut du type "Refusé" en base de données.
	 * @return success / error
	 */
	public String doRefusActivite() {
		LOGGER.info("Méthode doRefusActivite()");
		String vResult;
		
		try {
			managerFactory.getActiviteManager().updateStatutActivite(activiteId, 3, "DATE_MODERATION_ADMIN");
			vResult=ActionSupport.SUCCESS;
		} catch (UpdateStatutActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
			vResult=ActionSupport.ERROR;
		}
		return vResult;	
	}
}