package com.leasurecompagnon.appliweb.business.impl.manager;

import javax.inject.Named;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.UtilisateurManager;
import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.AuthentifierUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.CreerCompteUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateCoordUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateMdpUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.UpdateParametresUtilisateurFault_Exception;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

private Utilisateur utilisateur;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(UtilisateurManagerImpl.class);
	
	@Override
	public Utilisateur getUtilisateur(int utilisateurId) throws GetUtilisateurFault_Exception {
		LOGGER.info("Méthode getUtilisateur(int utilisateurId)");
		try {
			utilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(utilisateurId);
		} catch (GetUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetUtilisateurFault_Exception(e.getMessage());
		}
		return utilisateur;
	}
	
	@Override
	public Utilisateur authentifierUtilisateur(String adresseMail, String motDePasse) throws AuthentifierUtilisateurFault_Exception {
		LOGGER.info("Méthode authentifierUtilisateur(String adresseMail, String motDePasse)");
		try {
			utilisateur = getDaoFactory().getUtilisateurDao().authentifierUtilisateur(adresseMail, motDePasse);
		} catch (AuthentifierUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new AuthentifierUtilisateurFault_Exception(e.getMessage());
		}
		return utilisateur;
	}
	
	@Override
	public Utilisateur creerCompteUtilisateur(String civilite, String nom, String prenom, String pseudo,
			String adresseMail, String motDePasse, String confirmationMotDePasse, boolean conditionsUtilisation) throws CreerCompteUtilisateurFault_Exception {
		LOGGER.info("Méthode creerCompteUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation)");
		try {
			utilisateur = getDaoFactory().getUtilisateurDao().creerCompteUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, 
					conditionsUtilisation);
		} catch (CreerCompteUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new CreerCompteUtilisateurFault_Exception(e.getMessage());
		}
		return utilisateur;
	}
	
	@Override
	public void updateCoordUtilisateur(int id, String civilite, String nom, String prenom, String pseudo,
			String adresseMail, String telephone, XMLGregorianCalendar dateNaissance, String adresse, String codePostal,
			String ville, String pays) throws UpdateCoordUtilisateurFault_Exception {
		LOGGER.info("Méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays)");
		try {
			getDaoFactory().getUtilisateurDao().updateCoordUtilisateur(id, civilite, nom, prenom, pseudo, adresseMail, telephone, dateNaissance, adresse, codePostal, 
					ville, pays);
		} catch (UpdateCoordUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new UpdateCoordUtilisateurFault_Exception(e.getMessage());
		}
	}
	
	@Override
	public void updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp) throws UpdateMdpUtilisateurFault_Exception {
		LOGGER.info("Méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp)");
		try {
			getDaoFactory().getUtilisateurDao().updateMdpUtilisateur(id, actuelMdp, nouveauMdp, confirmationNouveauMdp);
		} catch (UpdateMdpUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new UpdateMdpUtilisateurFault_Exception(e.getMessage());
		}
	}
	
	@Override
	public void updateParametresUtilisateur(int id, boolean envoiMailInformatif) throws UpdateParametresUtilisateurFault_Exception {
		LOGGER.info("Méthode updateParametresUtilisateur(int id, boolean envoiMailInformatif)");
		try {
			getDaoFactory().getUtilisateurDao().updateParametresUtilisateur(id, envoiMailInformatif);
		} catch (UpdateParametresUtilisateurFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new UpdateParametresUtilisateurFault_Exception(e.getMessage());
		}
	}
}