package com.leasurecompagnon.ws.consumer.impl.rowmapper.formulairecontact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.NotFoundException;


/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link FormulaireContact}
 * @author André Monnier
 */
public class FormulaireContactRM implements RowMapper<FormulaireContact>{
	
	private UtilisateurDao utilisateurDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(FormulaireContactRM.class);
	
	public FormulaireContactRM (UtilisateurDao utilisateurDao) {
		this.utilisateurDao=utilisateurDao;
	}

	@Override
	public FormulaireContact mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("FormulaireContactRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		FormulaireContact vFormulaireContact = new FormulaireContact();
		vFormulaireContact.setId(pRS.getInt("id"));
		vFormulaireContact.setNomNa(pRS.getString("nom_na"));
		vFormulaireContact.setAdresseMailNa(pRS.getString("adresse_mail_na"));
		vFormulaireContact.setObjet(pRS.getString("objet"));
		vFormulaireContact.setMessage(pRS.getString("message"));
		
		//Conversion du format Timestamp en format XMLGregorianCalendar pour le champs date_form_contact.
		if(pRS.getTimestamp("date_form_contact")!=null) {
			GregorianCalendar gCalendarDateFormContact = new GregorianCalendar();
			gCalendarDateFormContact.setTime(pRS.getTimestamp("date_form_contact"));
			XMLGregorianCalendar xmlCalendarDateFormContact = null;
			try {
				xmlCalendarDateFormContact = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendarDateFormContact);
				vFormulaireContact.setDateFormContact(xmlCalendarDateFormContact);
			} catch (DatatypeConfigurationException ex) {
				LOGGER.info("Problème de conversion du format Date en format XMLGregorianCalendar pour le champs date_form_contact");
			}
		}
		
		try {
			vFormulaireContact.setUtilisateur(utilisateurDao.getUtilisateur(pRS.getInt("utilisateur_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return vFormulaireContact;
	}
}
