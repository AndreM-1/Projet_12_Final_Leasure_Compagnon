package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.DureeRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class DureeDaoImpl extends AbstractDaoImpl implements DureeDao {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DureeDaoImpl.class);
	
	@Override
	public List<Duree> getListDuree() throws TechnicalException{
		LOGGER.info("Méthode getListDuree()");
		String vSQL="SELECT * FROM public.duree ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Duree> vRowMapper=new DureeRM();
		List<Duree> vListDuree;
		try {
			vListDuree = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListDuree;	
	}
}