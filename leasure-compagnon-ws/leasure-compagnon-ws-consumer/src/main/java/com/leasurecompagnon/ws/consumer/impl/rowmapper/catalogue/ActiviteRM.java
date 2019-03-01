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

import com.leasurecompagnon.ws.consumer.contract.dao.AvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.ws.consumer.contract.dao.StatutActiviteAvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.TypeActiviteDao;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.consumer.contract.dao.VilleDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Activite}
 * @author André Monnier
 */
public class ActiviteRM implements RowMapper <Activite>{
	
	private TypeActiviteDao typeActiviteDao;
	private DureeDao dureeDao;
	private SaisonDao saisonDao;
	private StatutActiviteAvisDao statutActiviteDao;
	private CoordonneeGPSDao coordonneeGPSDao;
	private PhotoDao photoDao;
	private UtilisateurDao utilisateurDao;
	private VilleDao villeDao;
	private AvisDao avisDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(ActiviteRM.class);
	
	public ActiviteRM(TypeActiviteDao typeActiviteDao, DureeDao dureeDao, SaisonDao saisonDao, StatutActiviteAvisDao statutActiviteDao, CoordonneeGPSDao coordonneeGPSDao,
			PhotoDao photoDao, UtilisateurDao utilisateurDao, VilleDao villeDao, AvisDao avisDao) {
		this.typeActiviteDao=typeActiviteDao;
		this.dureeDao=dureeDao;
		this.saisonDao=saisonDao;
		this.statutActiviteDao=statutActiviteDao;
		this.coordonneeGPSDao=coordonneeGPSDao;
		this.photoDao=photoDao;
		this.utilisateurDao=utilisateurDao;
		this.villeDao=villeDao;
		this.avisDao=avisDao;
	}

	@Override
	public Activite mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("ActiviteRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Activite vActivite=new Activite();
		vActivite.setId(pRS.getInt("id"));
		vActivite.setNomActivite(pRS.getString("nom_activite"));
		vActivite.setAdresse(pRS.getString("adresse"));
		vActivite.setDescription(pRS.getString("description"));
		vActivite.setLienHoraireOuverture(pRS.getString("lien_horaire_ouverture"));
		
		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_demande_ajout.
		if(pRS.getTimestamp("date_demande_ajout")!=null) {
			GregorianCalendar gCalendarDateDemandeAjout = new GregorianCalendar();
			gCalendarDateDemandeAjout.setTime(pRS.getTimestamp("date_demande_ajout"));
			XMLGregorianCalendar xmlCalendarDateDemandeAjout = null;
			try {
				xmlCalendarDateDemandeAjout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateDemandeAjout);
				vActivite.setDateDemandeAjout(xmlCalendarDateDemandeAjout);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_demande_ajout");
			}
		}
		
		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_moderation_admin.
		if(pRS.getTimestamp("date_moderation_admin")!=null) {
			GregorianCalendar gCalendarDateModerationAdmin = new GregorianCalendar();
			gCalendarDateModerationAdmin.setTime(pRS.getTimestamp("date_moderation_admin"));
			XMLGregorianCalendar xmlCalendarDateModerationAdmin = null;
			try {
				xmlCalendarDateModerationAdmin= DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateModerationAdmin);
				vActivite.setDateModerationAdmin(xmlCalendarDateModerationAdmin);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_moderation_admin");
			}
		}
	
		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_mise_en_ligne.
		if(pRS.getTimestamp("date_mise_en_ligne")!=null) {
			GregorianCalendar gCalendarDateMiseEnLigne = new GregorianCalendar();
			gCalendarDateMiseEnLigne.setTime(pRS.getTimestamp("date_mise_en_ligne"));
			XMLGregorianCalendar xmlCalendarDateMiseEnLigne = null;
			try {
				xmlCalendarDateMiseEnLigne= DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateMiseEnLigne);
				vActivite.setDateMiseEnLigne(xmlCalendarDateMiseEnLigne);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_mise_en_ligne");
			}
		}
		
		try {
			vActivite.getListTypeActivite().addAll(typeActiviteDao.getListTypeActivite(pRS.getInt("id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.setDuree(dureeDao.getDuree(pRS.getInt("duree_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.setSaison(saisonDao.getSaison(pRS.getInt("saison_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.setStatutActivite(statutActiviteDao.getStatutActiviteAvis(pRS.getInt("statut_activite_avis_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.setCoordonnee(coordonneeGPSDao.getCoordonneeGPSActivite(pRS.getInt("id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.getListPhotoActivite().addAll(photoDao.getListPhotoActivite(pRS.getInt("id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.setVille(villeDao.getVille(pRS.getInt("ville_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		try {
			vActivite.getListAvis().addAll(avisDao.getListAvisActivite(pRS.getInt("id"),"MEL"));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		
		return vActivite;
	}
}
