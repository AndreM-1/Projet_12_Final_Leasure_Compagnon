package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.leasurecompagnon.ws.consumer.contract.dao.FormulaireContactDao;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.formulairecontact.FormulaireContactRM;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class FormulaireContactDaoImpl extends AbstractDaoImpl implements FormulaireContactDao{
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(FormulaireContactDaoImpl.class);
	
	@Override
	public List<FormulaireContact> getListFormulaireContact() throws TechnicalException {
		LOGGER.info("Méthode getListFormulaireContact()");
		String vSQL="SELECT * FROM public.formulaire_contact ORDER BY date_form_contact DESC";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<FormulaireContact> vRowMapper=new FormulaireContactRM(utilisateurDao);
		List<FormulaireContact> vListFormulaireContact;
		try {
			vListFormulaireContact=vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListFormulaireContact;
	}
	
	@Override
	public void insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId) {
		LOGGER.info("Méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId)");
		String vSQL="";
		if(utilisateurId==-1) {
			vSQL="INSERT INTO public.formulaire_contact(nom_na,adresse_mail_na,objet,message,date_form_contact) VALUES (:nomNa,:adresseMailNa,:objet,:message,"
					+ ":dateFormContact)";
		}else {
			vSQL="INSERT INTO public.formulaire_contact(objet,message,date_form_contact,utilisateur_id) VALUES (:objet,:message,:dateFormContact,:utilisateurId)";
		}
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nomNa", nomNa);
		vParams.addValue("adresseMailNa", adresseMailNa);
		vParams.addValue("objet", objet);
		vParams.addValue("message", message);
		vParams.addValue("dateFormContact",new Date());
		vParams.addValue("utilisateurId", utilisateurId);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);	
	}
}