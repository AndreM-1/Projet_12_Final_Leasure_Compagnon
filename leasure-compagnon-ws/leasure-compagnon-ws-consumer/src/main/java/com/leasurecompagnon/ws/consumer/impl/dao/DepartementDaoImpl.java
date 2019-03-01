package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.DepartementRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class DepartementDaoImpl extends AbstractDaoImpl implements DepartementDao{
	
	@Inject
	private RegionDao regionDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(DepartementDaoImpl.class);
	
	
	@Override
	public List<Departement> getListDepartement() throws TechnicalException{
		LOGGER.info("Méthode getListDepartement()");
		String vSQL="SELECT * FROM public.departement ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Departement> vRowMapper=new DepartementRM(regionDao);
		List<Departement> vListDepartement;
		try {
			vListDepartement = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListDepartement;	
	}
	
	@Override
	public Departement getDepartement(int departementId) throws NotFoundException{
		LOGGER.info("Méthode getDepartement(int departementId)");
		String vSQL="SELECT * FROM public.departement WHERE id="+departementId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Departement> vRowMapper=new DepartementRM(regionDao);
		List<Departement> vListDepartement= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListDepartement.size()!=0)
			return vListDepartement.get(0);
		else
			throw new NotFoundException("Aucun département ne correspond à l'id demandé");
	}
}
