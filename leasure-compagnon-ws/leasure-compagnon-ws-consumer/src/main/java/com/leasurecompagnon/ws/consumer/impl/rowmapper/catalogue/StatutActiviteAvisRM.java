package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.model.bean.catalogue.StatutActiviteAvis;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link StatutActiviteAvis}
 * @author André Monnier
 */
public class StatutActiviteAvisRM implements RowMapper <StatutActiviteAvis> {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(StatutActiviteAvisRM.class);

	@Override
	public StatutActiviteAvis mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("StatutActiviteAvisRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		StatutActiviteAvis vStatutActiviteAvis = new StatutActiviteAvis();
		vStatutActiviteAvis.setId(pRS.getInt("id"));
		vStatutActiviteAvis.setStatutActiviteAvis(pRS.getString("statut_activite_avis"));
		return vStatutActiviteAvis;
	}
}