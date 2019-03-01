package com.leasurecompagnon.ws.webapp.utilisateurservice.impl;

import javax.inject.Inject;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.ManagerFactory;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.AuthentifierUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.CreerCompteUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.GetUtilisateurFault;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.GetUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateCoordUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateMdpUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.utilisateurservice.generated.UpdateParametresUtilisateurFault_Exception;
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
		LOGGER.info("getUtilisateur(int utilisateurId)");
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
	public Utilisateur creerCompteUtilisateur(String civilite, String nom, String prenom, String pseudo,
			String adresseMail, String motDePasse, String confirmationMotDePasse, boolean conditionsUtilisation)
			throws CreerCompteUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePhotoUtilisateur(String nomPhoto, int utilisateurId)
			throws UpdatePhotoUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp)
			throws UpdateMdpUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur authentifierUtilisateur(String adresseMail, String motDePasse)
			throws AuthentifierUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCoordUtilisateur(int id, String civilite, String nom, String prenom, String pseudo,
			String adresseMail, String telephone, XMLGregorianCalendar dateNaissance, String adresse, String codePostal,
			String ville, String pays) throws UpdateCoordUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateParametresUtilisateur(int id, boolean envoiMailInformatif)
			throws UpdateParametresUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		
	}

}
