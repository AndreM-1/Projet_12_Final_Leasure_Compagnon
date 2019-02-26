package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.model.bean.catalogue.Duree;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Duree}
 * @author André Monnier
 */
public class DureeRM implements RowMapper<Duree> {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DureeRM.class);

	@Override
	public Duree mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("DureeRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Duree vDuree=new Duree();
		vDuree.setId(pRS.getInt("id"));
		vDuree.setDureeConseillee(pRS.getString("duree_conseillee"));
		return vDuree;
	}
}