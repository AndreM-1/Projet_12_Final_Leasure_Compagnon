package com.leasurecompagnon.appliweb.webapp.action;

import java.util.Map;

import javax.inject.Inject;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.UpdateCoordUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateMdpUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateParametresUtilisateurFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer le profil d'un {@link Utilisateur}
 * @author André Monnier
 */
public class GestionProfilUtilisateurAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1529618102965530707L;
	
	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres
	private int id;
	private String civilite;
	private String nom;
	private String prenom;
	private String pseudo;
	private String adresseMail;
	private String telephone;
	private XMLGregorianCalendar dateNaissance;
	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;
	private boolean validationFormulaire=false;
	
	private String actuelMdp;
	private String nouveauMotDePasse;
	private String confirmationNouveauMotDePasse;
	
	private boolean envoiMailInformatif;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionProfilUtilisateurAction.class);
	
	// ===================== Getters/Setters =====================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public XMLGregorianCalendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(XMLGregorianCalendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public boolean isValidationFormulaire() {
		return validationFormulaire;
	}

	public void setValidationFormulaire(boolean validationFormulaire) {
		this.validationFormulaire = validationFormulaire;
	}
	
	public String getActuelMdp() {
		return actuelMdp;
	}

	public void setActuelMdp(String actuelMdp) {
		this.actuelMdp = actuelMdp;
	}

	public String getNouveauMotDePasse() {
		return nouveauMotDePasse;
	}

	public void setNouveauMotDePasse(String nouveauMotDePasse) {
		this.nouveauMotDePasse = nouveauMotDePasse;
	}

	public String getConfirmationNouveauMotDePasse() {
		return confirmationNouveauMotDePasse;
	}

	public void setConfirmationNouveauMotDePasse(String confirmationNouveauMotDePasse) {
		this.confirmationNouveauMotDePasse = confirmationNouveauMotDePasse;
	}
	
	public boolean isEnvoiMailInformatif() {
		return envoiMailInformatif;
	}

	public void setEnvoiMailInformatif(boolean envoiMailInformatif) {
		this.envoiMailInformatif = envoiMailInformatif;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;	
	}
	
	// ===================== Méthodes ============================
	
	/**
	 * Méthode permettant de mettre à jour les informations
	 * relatives à un {@link Utilisateur}
	 * @return input / success
	 */
	public String doUpdateCoord() {
		LOGGER.info("Méthode doUpdateCoord()");
		String vResult;
		
		LOGGER.info("Validation formulaire : "+validationFormulaire);
		
		//Récupération de la variable de session relative à l'utilisateur.
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		LOGGER.info("Utilisateur Id : "+id);
		
		//Si le champ validationFormulaire est égal à false, c'est que l'on entre dans le formulaire.
		//Sinon, c'est que l'on vient de valider le formulaire de mise à jour des coordonnées.
		if(!validationFormulaire) {
			vResult=ActionSupport.INPUT;
			
			//Récupération des attributs de la variable de session relative à l'utilisateur.
			id=vUtilisateurSession.getId();
			civilite=vUtilisateurSession.getCivilite();
			nom=vUtilisateurSession.getNom();
			prenom=vUtilisateurSession.getPrenom();
			pseudo=vUtilisateurSession.getPseudo();
			adresseMail=vUtilisateurSession.getAdresseMail();
			telephone=vUtilisateurSession.getTelephone();
			dateNaissance=vUtilisateurSession.getDateNaissance();
			LOGGER.info("Date naissance : "+dateNaissance);
			adresse=vUtilisateurSession.getAdresse();
			codePostal=vUtilisateurSession.getCodePostal();
			ville=vUtilisateurSession.getVille();
			pays=vUtilisateurSession.getPays();
			
			validationFormulaire=true;
		}
		else {
			//Appel au web service. 
			LOGGER .info("Date de Naissance :"+dateNaissance);
			LOGGER .info("Pays :"+pays);
			try {
				managerFactory.getUtilisateurManager().updateCoordUtilisateur(id, civilite, nom, prenom, pseudo, adresseMail, telephone, dateNaissance, adresse, codePostal,
						ville, pays);
				
				//En cas de succès, on met à jour les attributs de la variable de session pour être cohérent avec la base de données.
				vUtilisateurSession.setCivilite(civilite);
				vUtilisateurSession.setNom(nom);
				vUtilisateurSession.setPrenom(prenom);
				vUtilisateurSession.setPseudo(pseudo);
				vUtilisateurSession.setAdresseMail(adresseMail);
				vUtilisateurSession.setTelephone(telephone);
				LOGGER.info("Date naissance : "+dateNaissance);
				vUtilisateurSession.setDateNaissance(dateNaissance);
				vUtilisateurSession.setAdresse(adresse);
				vUtilisateurSession.setCodePostal(codePostal);
				vUtilisateurSession.setVille(ville);
				vUtilisateurSession.setPays(pays);
				vResult=ActionSupport.SUCCESS;
			} catch (UpdateCoordUtilisateurFault_Exception e) {
				LOGGER.info(e.getMessage());
				this.addActionError(e.getMessage());
				//En cas d'échec, on affiche bien les valeurs précédentes.
				civilite=vUtilisateurSession.getCivilite();
				nom=vUtilisateurSession.getNom();
				prenom=vUtilisateurSession.getPrenom();
				pseudo=vUtilisateurSession.getPseudo();
				adresseMail=vUtilisateurSession.getAdresseMail();
				telephone=vUtilisateurSession.getTelephone();
				dateNaissance=vUtilisateurSession.getDateNaissance();
				LOGGER.info("Date naissance : "+dateNaissance);
				adresse=vUtilisateurSession.getAdresse();
				codePostal=vUtilisateurSession.getCodePostal();
				ville=vUtilisateurSession.getVille();
				pays=vUtilisateurSession.getPays();
				vResult=ActionSupport.INPUT;
			}		
		}
		
		LOGGER.info("Utilisateur Id : "+id);
		LOGGER.info("vResult : "+vResult);
		return vResult;
	}
	
	/**
	 * Méthode permettant de mettre à jour le mot de passe
	 * d'un {@link Utilisateur}
	 * @return input / success /error
	 */
	public String doUpdateMdp() {
		LOGGER.info("Méthode doUpdateMdp()");
		String vResult;
		
		//Récupération de la variable de session relative à l'utilisateur.
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		LOGGER.info("Utilisateur Id : "+id);
		
		if(actuelMdp==null&&nouveauMotDePasse==null&&confirmationNouveauMotDePasse==null) {
			id=vUtilisateurSession.getId();
			vResult=ActionSupport.INPUT;
		}else {
			try {
				managerFactory.getUtilisateurManager().updateMdpUtilisateur(id, actuelMdp, nouveauMotDePasse, confirmationNouveauMotDePasse);
				this.addActionMessage("La mise à jour de votre mot de passe a bien été prise en compte.");
				vResult=ActionSupport.SUCCESS;
			} catch (UpdateMdpUtilisateurFault_Exception e) {
				LOGGER.info(e.getMessage());
				this.addActionError(e.getMessage());
			
				if(e.getMessage().equals("Aucun utilisateur ne correspond à l'id demandé")) {
					vResult=ActionSupport.ERROR;
				}else {
					vResult=ActionSupport.INPUT;
				}
			}
		}
		return vResult;
	}
	
	/**
	 * Méthode permettant de mettre à jour les paramètres d'un {@link Utilisateur}
	 * @return input / success /error
	 */
	public String doUpdateParam() {
		LOGGER.info("Méthode doUpdateParam()");
		String vResult;
		
		//Récupération de la variable de session relative à l'utilisateur.
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		if(!validationFormulaire) {
			//Récupération des attributs id et envoiMailInformatif de la variable de session relative à l'utilisateur.
			id=vUtilisateurSession.getId();
			envoiMailInformatif=vUtilisateurSession.isEnvoiMailInformatif();
			validationFormulaire=true;
			vResult=ActionSupport.INPUT;
		}else {
			//Appel au web service.
			LOGGER.info("Utilisateur Id : "+id);
			LOGGER.info("Option envoi mail informatif : "+envoiMailInformatif);
			try {
				managerFactory.getUtilisateurManager().updateParametresUtilisateur(id, envoiMailInformatif);
				
				//En cas de succès, on met à jour les attributs de la variable de session pour être cohérent avec la base de données.
				vUtilisateurSession.setEnvoiMailInformatif(envoiMailInformatif);
				vResult=ActionSupport.SUCCESS;	
			} catch (UpdateParametresUtilisateurFault_Exception e) {
				LOGGER.info(e.getMessage());
				this.addActionError(e.getMessage());
				vResult=ActionSupport.ERROR;
			}	
		}
		return vResult;	
	}
}