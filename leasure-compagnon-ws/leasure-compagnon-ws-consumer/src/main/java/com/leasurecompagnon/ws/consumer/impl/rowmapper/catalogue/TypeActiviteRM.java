package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link TypeActivite}
 * @author André Monnier
 */
public class TypeActiviteRM implements RowMapper<TypeActivite> {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(TypeActiviteRM.class);

	@Override
	public TypeActivite mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("TypeActiviteRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		TypeActivite vTypeActivite= new TypeActivite();
		vTypeActivite.setId(pRS.getInt("id"));
		vTypeActivite.setTypeActivite(pRS.getString("type_activite"));
		return vTypeActivite;
	}
}