package com.leasurecompagnon.ws.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Utilisateur}
 * @author André Monnier
 */
public class UtilisateurRM implements RowMapper<Utilisateur> {

	private PhotoDao photoDao;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(UtilisateurRM.class);

	public UtilisateurRM(PhotoDao photoDao) {
		this.photoDao=photoDao;
	}

	@Override

	public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("UtilisateurRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Utilisateur vUtilisateur=new Utilisateur();
		vUtilisateur.setId(pRS.getInt("id"));
		vUtilisateur.setCivilite(pRS.getString("civilite"));
		vUtilisateur.setNom(pRS.getString("nom"));
		vUtilisateur.setPrenom(pRS.getString("prenom"));
		vUtilisateur.setPseudo(pRS.getString("pseudo"));
		vUtilisateur.setAdresseMail(pRS.getString("adresse_mail"));
		vUtilisateur.setSalt(pRS.getString("salt"));
		vUtilisateur.setMotDePasseSecurise(pRS.getString("mot_de_passe_securise"));
		
		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_inscription.
		if(pRS.getTimestamp("date_inscription")!=null) {
			GregorianCalendar gCalendarDateInscription = new GregorianCalendar();
			gCalendarDateInscription.setTime(pRS.getTimestamp("date_inscription"));
			XMLGregorianCalendar xmlCalendarDateInscription = null;
			try {
				xmlCalendarDateInscription = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateInscription);
				vUtilisateur.setDateInscription(xmlCalendarDateInscription);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_inscription");
			}
		}
		
		vUtilisateur.setTelephone(pRS.getString("telephone"));

		//Conversion du format Date en format XMLGregorianCalendar pour le champs date_naissance.
		if(pRS.getDate("date_naissance")!=null) {
			GregorianCalendar gCalendarDateNaissance = new GregorianCalendar();
			gCalendarDateNaissance.setTime(pRS.getDate("date_naissance"));
			XMLGregorianCalendar xmlCalendarDateNaissance = null;
			try {
				xmlCalendarDateNaissance = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateNaissance);
				vUtilisateur.setDateNaissance(xmlCalendarDateNaissance);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_naissance");
			}
		}

		vUtilisateur.setAdresse(pRS.getString("adresse"));
		vUtilisateur.setCodePostal(pRS.getString("code_postal"));
		vUtilisateur.setVille(pRS.getString("ville"));
		vUtilisateur.setPays(pRS.getString("pays"));
		vUtilisateur.setEnvoiMailInformatif(pRS.getBoolean("envoi_mail_informatif"));
		try {
			vUtilisateur.setPhotoUtilisateur(photoDao.getPhotoUtilisateur(pRS.getInt("id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}

		vUtilisateur.setAdministrateur(pRS.getBoolean("administrateur"));
		return vUtilisateur;
	}
}
