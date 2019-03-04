package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
}