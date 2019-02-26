package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.contract.dao.VilleDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.VilleRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class VilleDaoImpl extends AbstractDaoImpl implements VilleDao {
	
	@Inject
	private CoordonneeGPSDao coordonneeGPSDao;
	
	@Inject
	private PhotoDao photoDao;
	
	@Inject
	private DepartementDao departementDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(VilleDaoImpl.class);
	
	@Override
	public List<Ville> getListVille(int nbVille) throws TechnicalException{
		LOGGER.info("Méthode getListVille(int nbVille)");
		String vSQL="";
		if(nbVille>=0)
			vSQL = "SELECT * FROM public.ville ORDER BY id ASC LIMIT "+nbVille;
		else
			vSQL = "SELECT * FROM public.ville ORDER BY id ASC";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Ville> vRowMapper=new VilleRM(coordonneeGPSDao,photoDao,departementDao);
		List<Ville> vListVille;
		try {
			vListVille = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListVille;
	}
}