package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.model.bean.catalogue.Pays;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Pays}
 * @author André Monnier
 */
public class PaysRM implements RowMapper<Pays>{
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PaysRM.class);

	@Override
	public Pays mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("PaysRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Pays vPays=new Pays();
		vPays.setId(pRS.getInt("id"));
		vPays.setNomPays(pRS.getString("nom_pays"));
		return vPays;
	}
}