package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.CoordonneeGPSRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.CoordonneeGPS;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

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
	
	@Override
	public void insertCoordonneeGPSActivite(Activite activite) {
		LOGGER.info("Méthode insertCoordonneeGPSActivite(Activite activite)");
		String vSQL="INSERT INTO public.coordonnee_gps(latitude,longitude,activite_id) VALUES (:latitude, :longitude, :activiteId)";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("latitude", activite.getCoordonnee().getLatitude());
		vParams.addValue("longitude", activite.getCoordonnee().getLongitude());
		vParams.addValue("activiteId", activite.getId());
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);
	}
	
	@Override
	public void deleteCoordonneeGPSActivite(int activiteId) throws TechnicalException {
		LOGGER.info("Méthode deleteCoordonneeGPSActivite(int activiteId)");
		String vSQL="DELETE FROM public.coordonnee_gps WHERE activite_id=:activiteId";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("activiteId", activiteId);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		try {
			vJdbcTemplate.update(vSQL, vParams);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}	
	}
}