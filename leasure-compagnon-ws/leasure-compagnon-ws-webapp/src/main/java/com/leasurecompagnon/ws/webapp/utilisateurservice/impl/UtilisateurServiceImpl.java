package com.leasurecompagnon.ws.webapp.utilisateurservice.impl;

import javax.inject.Inject;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.ManagerFactory;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.AuthentifierUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.AuthentifierUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.CreerCompteUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.CreerCompteUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.GetUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.GetUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateCoordUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateCoordUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateMdpUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateMdpUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateParametresUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateParametresUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdatePhotoUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdatePhotoUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres
	private Utilisateur utilisateur;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(UtilisateurServiceImpl.class);

	@Override
	public Utilisateur getUtilisateur(int utilisateurId) throws GetUtilisateurFault_Exception {
		LOGGER.info("Méthode getUtilisateur(int utilisateurId)");
		try {
			utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(utilisateurId);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetUtilisateurFault getUtilisateurFault = new GetUtilisateurFault();
			getUtilisateurFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetUtilisateurFault_Exception(nfExc.getMessage(),getUtilisateurFault);
		}
		return utilisateur;
	}

	@Override
	public Utilisateur authentifierUtilisateur(String adresseMail, String motDePasse)
			throws AuthentifierUtilisateurFault_Exception {
		LOGGER.info("Méthode authentifierUtilisateur(String adresseMail, String motDePasse)");
		LOGGER.info("Adresse mail :"+adresseMail);
		LOGGER.info("Mot de Passe :"+motDePasse);

		if (!StringUtils.isAllEmpty(adresseMail, motDePasse)) {
			try {
				utilisateur=managerFactory.getUtilisateurManager().getUtilisateur(adresseMail,motDePasse);
			} catch (NotFoundException pEx) {
				LOGGER.info(pEx.getMessage());
				AuthentifierUtilisateurFault authentifierUtilisateurFault=new AuthentifierUtilisateurFault();
				authentifierUtilisateurFault.setFaultMessageErreur(pEx.getMessage());
				throw new AuthentifierUtilisateurFault_Exception("Identifiant ou mot de passe invalide !",authentifierUtilisateurFault);
			}
		}else {
			AuthentifierUtilisateurFault authentifierUtilisateurFault=new AuthentifierUtilisateurFault();
			authentifierUtilisateurFault.setFaultMessageErreur("L'identifiant et le mot de passe ne sont pas renseignés.");
			throw new AuthentifierUtilisateurFault_Exception("Champs non renseignés.",authentifierUtilisateurFault);
		}
		return utilisateur;
	}

	@Override
	public Utilisateur creerCompteUtilisateur(String civilite, String nom, String prenom, String pseudo,
			String adresseMail, String motDePasse, String confirmationMotDePasse, boolean conditionsUtilisation)
					throws CreerCompteUtilisateurFault_Exception {
		LOGGER.info("Méthode creerCompteUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation)");
		
		try {
			managerFactory.getUtilisateurManager().insertUtilisateur(civilite,nom,prenom,pseudo,adresseMail,motDePasse,confirmationMotDePasse,conditionsUtilisation);
		} catch (FunctionalException fExc) {
			LOGGER.info(fExc.getMessage());
			CreerCompteUtilisateurFault creerCompteUtilisateurFault=new CreerCompteUtilisateurFault(); 
			creerCompteUtilisateurFault.setFaultMessageErreur(fExc.getMessage());

			if(fExc.getMessage().equals("Veuillez accepter les conditions d'utilisation.")) {
				throw new CreerCompteUtilisateurFault_Exception(fExc.getMessage(),creerCompteUtilisateurFault);
			} else if(fExc.getMessage().contains("champ")){
				throw new CreerCompteUtilisateurFault_Exception("Certains paramètres ne sont pas renseignés correctement.",creerCompteUtilisateurFault);
			}else if(fExc.getMessage().contains("pseudo")) {
				throw new CreerCompteUtilisateurFault_Exception(fExc.getMessage(),creerCompteUtilisateurFault);
			}
		}

		try {
			utilisateur=managerFactory.getUtilisateurManager().getUtilisateur(adresseMail,motDePasse);
			LOGGER.info("Utilisateur id : "+utilisateur.getId());
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			CreerCompteUtilisateurFault creerCompteUtilisateurFault=new CreerCompteUtilisateurFault(); 
			creerCompteUtilisateurFault.setFaultMessageErreur(nfExc.getMessage());
			throw new CreerCompteUtilisateurFault_Exception(nfExc.getMessage(),creerCompteUtilisateurFault);
		}
		return utilisateur;
	}
	
	@Override
	public void updateCoordUtilisateur(int id, String civilite, String nom, String prenom, String pseudo,
			String adresseMail, String telephone, XMLGregorianCalendar dateNaissance, String adresse, String codePostal,
			String ville, String pays) throws UpdateCoordUtilisateurFault_Exception {
		LOGGER.info("Méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays)");
		
		try {
			managerFactory.getUtilisateurManager().updateCoordUtilisateur(id, civilite, nom, prenom, pseudo,
					adresseMail, telephone, dateNaissance, adresse, codePostal, ville, pays);
		} catch (FunctionalException fExc) {
			LOGGER.info(fExc.getMessage());
			UpdateCoordUtilisateurFault updateCoordUtilisateurFault=new UpdateCoordUtilisateurFault();
			updateCoordUtilisateurFault.setFaultMessageErreur(fExc.getMessage());

			if(fExc.getMessage().contains("champ")) {
				throw new UpdateCoordUtilisateurFault_Exception("Certains paramètres ne sont pas renseignés correctement.",updateCoordUtilisateurFault);
			}else if(fExc.getMessage().contains("pseudo")) {
				throw new UpdateCoordUtilisateurFault_Exception(fExc.getMessage(),updateCoordUtilisateurFault);
			}

		}
	}
	
	@Override
	public void updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp)
			throws UpdateMdpUtilisateurFault_Exception {
		LOGGER.info("Méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp)");
		try {
			managerFactory.getUtilisateurManager().updateMdpUtilisateur(id, actuelMdp, nouveauMdp, confirmationNouveauMdp);
		} 
		catch (NotFoundException | FunctionalException fnfExc) {
			LOGGER.info(fnfExc.getMessage());
			UpdateMdpUtilisateurFault updateMdpUtilisateurFault=new UpdateMdpUtilisateurFault();
			updateMdpUtilisateurFault.setFaultMessageErreur(fnfExc.getMessage());
			throw new UpdateMdpUtilisateurFault_Exception(fnfExc.getMessage(),updateMdpUtilisateurFault);
		}
	}

	@Override
	public void updateParametresUtilisateur(int id, boolean envoiMailInformatif)
			throws UpdateParametresUtilisateurFault_Exception {
		LOGGER.info("Méthode updateParametresUtilisateur(int id, boolean envoiMailInformatif)");
		try {
			managerFactory.getUtilisateurManager().updateParametresUtilisateur(id, envoiMailInformatif);
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			UpdateParametresUtilisateurFault updateParametresUtilisateurFault=new UpdateParametresUtilisateurFault();
			updateParametresUtilisateurFault.setFaultMessageErreur(tExc.getMessage());
			throw new UpdateParametresUtilisateurFault_Exception(tExc.getMessage(),updateParametresUtilisateurFault);
		}
	}
	
	@Override
	public void updatePhotoUtilisateur(String nomPhoto, int utilisateurId)
			throws UpdatePhotoUtilisateurFault_Exception {
		LOGGER.info("Méthode updatePhotoUtilisateur(String nomPhoto, int utilisateurId)");
		//Les contrôles sur le nom, la taille et le format de la photo auront été réalisés en amont dans l'application web.
		//Ce web service ne sert donc qu'à mettre à jour la base de données pour un utilisateur qui n'aurait pas de photos
		//de profil.
		try {
			managerFactory.getPhotoManager().insertPhotoUtilisateur(nomPhoto,utilisateurId);
		} catch (FunctionalException fExc) {
			LOGGER.info(fExc.getMessage());
			UpdatePhotoUtilisateurFault updatePhotoUtilisateurFault = new UpdatePhotoUtilisateurFault();
			updatePhotoUtilisateurFault.setFaultMessageErreur(fExc.getMessage());
			throw new UpdatePhotoUtilisateurFault_Exception(fExc.getMessage(),updatePhotoUtilisateurFault);
		}
	}
}
