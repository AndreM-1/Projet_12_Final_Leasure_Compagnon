package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.model.bean.catalogue.Photo;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Photo}
 * @author André Monnier
 */
public class PhotoRM implements RowMapper<Photo>{
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PhotoRM.class);

	@Override
	public Photo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("PhotoRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Photo vPhoto = new Photo();
		vPhoto.setId(pRS.getInt("id"));
		vPhoto.setNomPhoto(pRS.getString("nom_photo"));
		vPhoto.setProvenancePhoto(pRS.getString("provenance_photo"));
		vPhoto.setTypePhoto(pRS.getString("type_photo"));
		return vPhoto;
	}
}