package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.CoordonneeGPSRM;
import com.leasurecompagnon.ws.model.bean.catalogue.CoordonneeGPS;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

@Named
public class CoordonneeGPSDaoImpl extends AbstractDaoImpl implements CoordonneeGPSDao {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(CoordonneeGPSDaoImpl.class);
	
	@Override
	public CoordonneeGPS getCoordonneeGPSVille(int villeId) throws NotFoundException {
		LOGGER.info("Méthode getCoordonneeGPSVille(int villeId)");
		String vSQL="SELECT * FROM public.coordonnee_gps WHERE ville_id = "+villeId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<CoordonneeGPS> vRowMapper=new CoordonneeGPSRM();
		List<CoordonneeGPS> vListCoordonneeGPS= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListCoordonneeGPS.size()!=0)
			return vListCoordonneeGPS.get(0);
		else
			throw new NotFoundException("Aucune coordonnée GPS pour la ville demandée");
	}
	
	@Override
	public CoordonneeGPS getCoordonneeGPSActivite(int activiteId) throws NotFoundException {
		LOGGER.info("Méthode getCoordonneeGPSActivite(int activiteId)");
		String vSQL="SELECT * FROM public.coordonnee_gps WHERE activite_id = "+activiteId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<CoordonneeGPS> vRowMapper=new CoordonneeGPSRM();
		List<CoordonneeGPS> vListCoordonneeGPS= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListCoordonneeGPS.size()!=0)
			return vListCoordonneeGPS.get(0);
		else
			throw new NotFoundException("Aucune coordonnée GPS pour l'activité demandée");
	}
}