package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.model.bean.catalogue.Saison;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Saison}
 * @author André Monnier
 */
public class SaisonRM implements RowMapper<Saison> {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(SaisonRM.class);

	@Override
	public Saison mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("SaisonRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Saison vSaison= new Saison();
		vSaison.setId(pRS.getInt("id"));
		vSaison.setNomSaison(pRS.getString("nom_saison"));			
		return vSaison;
	}
}