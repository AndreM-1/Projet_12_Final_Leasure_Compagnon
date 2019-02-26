package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.exception.NotFoundException;


/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Departement}
 * @author André Monnier
 */
public class DepartementRM implements RowMapper<Departement>{
	
	private RegionDao regionDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DepartementRM.class);
	
	public DepartementRM(RegionDao regionDao) {
		this.regionDao=regionDao;
	}

	@Override
	public Departement mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("DepartementRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Departement vDepartement=new Departement();
		vDepartement.setId(pRS.getInt("id"));
		vDepartement.setNomDepartement(pRS.getString("nom_departement"));
		try {
			vDepartement.setRegion(regionDao.getRegion(pRS.getInt("region_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return vDepartement;
	}
}
