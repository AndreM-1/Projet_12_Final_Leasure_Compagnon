package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.SaisonRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class SaisonDaoImpl extends AbstractDaoImpl implements SaisonDao {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SaisonDaoImpl.class);
	
	@Override
	public List<Saison> getListSaison() throws TechnicalException {
		LOGGER.info("Méthode getListSaison()");
		String vSQL="SELECT * FROM public.saison ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Saison> vRowMapper=new SaisonRM();
		List<Saison> vListSaison;
		try {
			vListSaison = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListSaison;	
	}
	
	@Override
	public Saison getSaison(int saisonId) throws NotFoundException {
		LOGGER.info("Méthode getSaison(int saisonId)");
		String vSQL="SELECT * FROM public.saison WHERE id ="+saisonId+ " ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Saison> vRowMapper=new SaisonRM();
		List<Saison> vListSaison=vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListSaison.size()!=0)
			return vListSaison.get(0);
		else
			throw new NotFoundException("Aucune saison ne correspond à l'id demandé");
	}
}