package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.model.bean.catalogue.CoordonneeGPS;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link CoordonneeGPS}
 * @author André Monnier
 */
public class CoordonneeGPSRM implements RowMapper<CoordonneeGPS>{
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(CoordonneeGPSRM.class);

	@Override
	public CoordonneeGPS mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("CoordonneeGPSRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		CoordonneeGPS vCoordonneeGPS=new CoordonneeGPS();
		vCoordonneeGPS.setId(pRS.getInt("id"));
		vCoordonneeGPS.setLatitude(pRS.getDouble("latitude"));
		vCoordonneeGPS.setLongitude(pRS.getDouble("longitude"));
		return vCoordonneeGPS;
	}
}