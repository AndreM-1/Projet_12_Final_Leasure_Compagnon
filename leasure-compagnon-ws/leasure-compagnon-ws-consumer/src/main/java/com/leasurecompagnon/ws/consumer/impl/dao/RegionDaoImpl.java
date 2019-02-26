package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.ws.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.RegionRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class RegionDaoImpl extends AbstractDaoImpl implements RegionDao {
	
	@Inject
	private PaysDao paysDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(RegionDaoImpl.class);
	
	
	@Override
	public List<Region> getListRegion() throws TechnicalException{
		LOGGER.info("Méthode getListRegion()");
		String vSQL="SELECT * FROM public.region ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Region> vRowMapper=new RegionRM(paysDao);
		List<Region> vListRegion;
		try {
			vListRegion = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListRegion;	
	}
		
	@Override
	public Region getRegion(int regionId) throws NotFoundException{
		LOGGER.info("Méthode getRegion(int regionId)");
		String vSQL="SELECT * FROM public.region WHERE id="+regionId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Region> vRowMapper=new RegionRM(paysDao);
		List<Region> vListRegion= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListRegion.size()!=0)
			return vListRegion.get(0);
		else
			throw new NotFoundException("Aucune région ne correspondant à l'id demandé");
	}
}
