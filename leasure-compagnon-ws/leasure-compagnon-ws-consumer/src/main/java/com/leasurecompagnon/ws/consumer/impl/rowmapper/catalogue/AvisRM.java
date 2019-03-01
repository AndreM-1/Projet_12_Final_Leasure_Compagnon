package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.StatutActiviteAvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;


/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Avis}
 * @author André Monnier
 */
public class AvisRM implements RowMapper<Avis>{
	
	private UtilisateurDao utilisateurDao;
	private StatutActiviteAvisDao statutActiviteAvisDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AvisRM.class);
	
	public AvisRM(UtilisateurDao utilisateurDao, StatutActiviteAvisDao statutActiviteAvisDao) {
		this.utilisateurDao=utilisateurDao;
		this.statutActiviteAvisDao=statutActiviteAvisDao;
	}

	@Override
	public Avis mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("AvisRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Avis vAvis = new Avis();
		vAvis.setId(pRS.getInt("id"));
		vAvis.setCommentaire(pRS.getString("commentaire"));
		vAvis.setAppreciation(pRS.getString("appreciation"));
		
		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_poste_avis.
		if(pRS.getTimestamp("date_poste_avis")!=null) {
			GregorianCalendar gCalendarDatePosteAvis = new GregorianCalendar();
			gCalendarDatePosteAvis.setTime(pRS.getTimestamp("date_poste_avis"));
			XMLGregorianCalendar xmlCalendarDatePosteAvis = null;
			try {
				xmlCalendarDatePosteAvis = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDatePosteAvis);
				vAvis.setDatePosteAvis(xmlCalendarDatePosteAvis);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_poste_avis");
			}
		}
		
		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_moderation_admin_avis.
		if(pRS.getTimestamp("date_moderation_admin_avis")!=null) {
			GregorianCalendar gCalendarDateModerationAdminAvis = new GregorianCalendar();
			gCalendarDateModerationAdminAvis.setTime(pRS.getTimestamp("date_moderation_admin_avis"));
			XMLGregorianCalendar xmlCalendarDateModerationAdminAvis = null;
			try {
				xmlCalendarDateModerationAdminAvis = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateModerationAdminAvis);
				vAvis.setDateModerationAdminAvis(xmlCalendarDateModerationAdminAvis);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_moderation_admin_avis");
			}
		}

		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_mise_en_ligne_avis.
		if(pRS.getTimestamp("date_mise_en_ligne_avis")!=null) {
			GregorianCalendar gCalendarDateMiseEnLigneAvis = new GregorianCalendar();
			gCalendarDateMiseEnLigneAvis.setTime(pRS.getTimestamp("date_mise_en_ligne_avis"));
			XMLGregorianCalendar xmlCalendarDateMiseEnLigneAvis = null;
			try {
				xmlCalendarDateMiseEnLigneAvis = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateMiseEnLigneAvis);
				vAvis.setDateMiseEnLigneAvis(xmlCalendarDateMiseEnLigneAvis);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_mise_en_ligne_avis");
			}
		}
		
		try {
			vAvis.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vAvis.setStatutAvis(statutActiviteAvisDao.getStatutActiviteAvis(pRS.getInt("statut_activite_avis_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return vAvis;
	}
}