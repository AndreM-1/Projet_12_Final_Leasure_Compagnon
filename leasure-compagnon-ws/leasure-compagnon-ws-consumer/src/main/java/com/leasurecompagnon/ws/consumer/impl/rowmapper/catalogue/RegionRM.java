package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Region}
 * @author André Monnier
 */
public class RegionRM implements RowMapper<Region>{
	
	private PaysDao paysDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(RegionRM.class);
	
	public RegionRM(PaysDao paysDao) {
		this.paysDao=paysDao;
	}

	@Override
	public Region mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("RegionRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Region vRegion=new Region();
		vRegion.setId(pRS.getInt("id"));
		vRegion.setNomRegion(pRS.getString("nom_region"));
		try {
			vRegion.setPays(paysDao.getPays(pRS.getInt("pays_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return vRegion;
	}
}