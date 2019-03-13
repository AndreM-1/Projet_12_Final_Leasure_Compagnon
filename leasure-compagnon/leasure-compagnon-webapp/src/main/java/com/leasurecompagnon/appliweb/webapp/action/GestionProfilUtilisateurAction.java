package com.leasurecompagnon.appliweb.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.GetUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateCoordUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateMdpUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateParametresUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdatePhotoUtilisateurFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer le profil d'un {@link Utilisateur}
 * @author André Monnier
 */
public class GestionProfilUtilisateurAction extends ActionSupport implements SessionAware,ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1529618102965530707L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres
	private int id;
	private String nomPhoto;
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

	//Eléments liés  l'upload
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;

	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionProfilUtilisateurAction.class);

	// ===================== Getters/Setters =====================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
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

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;	
	}

	@Override
	public void setServletRequest(HttpServletRequest pRequest) {
		this.servletRequest=pRequest;

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
			//Récupération des attributs de la variable de session relative à l'utilisateur.
			id=vUtilisateurSession.getId();
			if(vUtilisateurSession.getPhotoUtilisateur()!=null)
				nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();

			LOGGER.info("Nom Photo utilisateur : "+nomPhoto);
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
			vResult=ActionSupport.INPUT;
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
		LOGGER.info("nomPhoto : "+nomPhoto);
		LOGGER.info("Civilité : "+civilite);
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
			pseudo=vUtilisateurSession.getPseudo();
			civilite=vUtilisateurSession.getCivilite();
			if(vUtilisateurSession.getPhotoUtilisateur()!=null)
				nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();

			LOGGER.info("Nom Photo utilisateur : "+nomPhoto);	
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
		LOGGER.info("Civilité : "+civilite);
		LOGGER.info("vResult : "+vResult);
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
			pseudo=vUtilisateurSession.getPseudo();
			civilite=vUtilisateurSession.getCivilite();
			if(vUtilisateurSession.getPhotoUtilisateur()!=null)
				nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();

			LOGGER.info("Nom Photo utilisateur : "+nomPhoto);
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
		LOGGER.info("Civilité : "+civilite);
		LOGGER.info("vResult : "+vResult);
		return vResult;	
	}

	/**
	 * Méthode permettant de mettre à jour la photo de profil pour d'un {@link Utilisateur}
	 * @return input / success / error
	 */
	public String doUpdatePhotoUtil() {
		LOGGER.info("Méthode doUpdatePhotoUtil()");
		String vResult;

		//Récupération de la variable de session relative à l'utilisateur.
		Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
		
		//Récupération des attributs de la variable de session relative à l'utilisateur.
		id=vUtilisateurSession.getId();
		if(vUtilisateurSession.getPhotoUtilisateur()!=null)
			nomPhoto=vUtilisateurSession.getPhotoUtilisateur().getNomPhoto();

		LOGGER.info("Nom Photo utilisateur : "+nomPhoto);
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
			
		if(fileUpload==null) {
			vResult=ActionSupport.INPUT;
		}else {
			
			LOGGER.info("Src (Dossier Temp) File name: " + fileUpload);
			LOGGER.info("Nom initial du fichier : "+fileUploadFileName);
			LOGGER.info("File upload content type : "+fileUploadContentType);

			String[] tabString=fileUploadFileName.split("\\.");

			//On vérifie que l'extension du fichier est correcte, à savoir :
			//JPEG : jpg, jpeg, jpe
			//PNG : png
			//On vérifie aussi que la taille du fichier ne dépasse pas 100Ko.
			String extensionFichier=tabString[tabString.length-1];
			double tailleFichierKiloOctets=fileUpload.length()/1024;
			LOGGER.info("Format du fichier : "+extensionFichier);
			LOGGER.info("Taille du fichier en kilo octets : "+tailleFichierKiloOctets);
			
			if((!extensionFichier.equals("jpg")&&!extensionFichier.equals("jpeg")&&!extensionFichier.equals("jpe")&&!extensionFichier.equals("png"))
					||tailleFichierKiloOctets>100.0) {
				this.addActionError("Le format ou la taille du fichier uploadé n'est pas correct. Seuls les fichiers de moins de 100Ko de type JPEG ou PNG sont autorisés.");
				vResult=ActionSupport.ERROR;
			}else {
				//On change le nom du fichier à uploader, en reprenant l'extension du fichier initial.
				fileUploadFileName="utilisateur-"+vUtilisateurSession.getId()+"."+extensionFichier;
				LOGGER.info("Nom final du fichier : " + fileUploadFileName);

				//On définit le répertoire où sera uploadé le fichier.
				String destPath=servletRequest.getServletContext().getRealPath("/jsp/assets/images/utilisateur/");
				LOGGER.info("Chemin absolu répertoire final : "+destPath);

				File destFile  = new File(destPath, fileUploadFileName);
				
				try {
					//On copie le fichier dans ce répertoire.
					FileUtils.copyFile(fileUpload, destFile);

					//On définit le nom de la photo tel qu'il sera en base de données
					nomPhoto="jsp/assets/images/utilisateur/"+fileUploadFileName;
					LOGGER.info("Nom photo final en base de données :" +nomPhoto);
					LOGGER.info("utilisateur_id :" +vUtilisateurSession.getId());
					
					//Si l'utilisateur n'a pas de photo en BDD, la photo sera ajoutée. Sinon, rien ne se passe, et
					//on affiche juste un message pour dire que l'utilisateur a déjà une photo en BDD.
					try {
						managerFactory.getPhotoManager().updatePhotoUtilisateur(nomPhoto, vUtilisateurSession.getId());
					} catch (UpdatePhotoUtilisateurFault_Exception e) {
						LOGGER.info(e.getMessage());
					}
									
					try {
						Utilisateur vUtilisateur=managerFactory.getUtilisateurManager().getUtilisateur(id);
						nomPhoto=vUtilisateur.getPhotoUtilisateur().getNomPhoto();
						vUtilisateurSession.setPhotoUtilisateur(vUtilisateur.getPhotoUtilisateur());;
						vResult=ActionSupport.SUCCESS;
					} catch (GetUtilisateurFault_Exception e) {
						LOGGER.info(e.getMessage());
						vResult=ActionSupport.ERROR;
					}
					
				} catch (IOException e) {
					LOGGER.info(e.getMessage());
					this.addActionError("Echec lors de l'upload du fichier");
					return ActionSupport.ERROR;
				}
			}
		}
		return vResult;
	}
}