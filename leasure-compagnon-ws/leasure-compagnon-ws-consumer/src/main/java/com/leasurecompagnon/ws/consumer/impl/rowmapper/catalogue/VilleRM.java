package com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Classe de type RowMapper permettant de mapper des
 * lignes de résultats (du resultSet en BDD) en objet
 * de type {@link Ville}
 * @author André Monnier
 */
public class VilleRM implements RowMapper<Ville>{
	
	private CoordonneeGPSDao coordonneeGPSDao;
	private PhotoDao photoDao;
	private DepartementDao departementDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(VilleRM.class);
	
	public VilleRM(CoordonneeGPSDao coordonneeGPSDao,PhotoDao photoDao,DepartementDao departementDao) {
		this.coordonneeGPSDao=coordonneeGPSDao;
		this.photoDao=photoDao;
		this.departementDao=departementDao;
	}

	@Override
	public Ville mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		LOGGER.info("VilleRM - Méthode mapRow(ResultSet pRS, int pRowNum)");
		Ville vVille=new Ville();
		vVille.setId(pRS.getInt("id"));
		vVille.setNomVille(pRS.getString("nom_ville"));
		vVille.setCodePostal(pRS.getString("code_postal"));
		vVille.setDescription(pRS.getString("description"));
		vVille.setNbHabitant(pRS.getInt("nb_habitant"));
		try {
			vVille.setCoordonnee(coordonneeGPSDao.getCoordonneeGPSVille(pRS.getInt("id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		try {
			vVille.setPhotoVille(photoDao.getPhotoVille(pRS.getInt("id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		try {
			vVille.setDepartement(departementDao.getDepartement(pRS.getInt("departement_id")));
		} catch (NotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return vVille;
	}
}