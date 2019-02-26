package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.PaysRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class PaysDaoImpl extends AbstractDaoImpl implements PaysDao{

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PaysDaoImpl.class);
	
	@Override
	public List<Pays> getListPays() throws TechnicalException{
		LOGGER.info("Méthode getListPays()");
		String vSQL="SELECT * FROM public.pays ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Pays> vRowMapper=new PaysRM();
		List<Pays> vListPays;
		try {
			vListPays = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListPays;	
	}
	
	@Override
	public Pays getPays(int paysId) throws NotFoundException{
		LOGGER.info("Méthode getPays(int paysId)");
		String vSQL="SELECT * FROM public.pays WHERE id="+paysId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Pays> vRowMapper=new PaysRM();
		List<Pays> vListPays= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListPays.size()!=0)
			return vListPays.get(0);
		else
			throw new NotFoundException("Aucun pays ne correspondant à l'id demandé");
	}
}
