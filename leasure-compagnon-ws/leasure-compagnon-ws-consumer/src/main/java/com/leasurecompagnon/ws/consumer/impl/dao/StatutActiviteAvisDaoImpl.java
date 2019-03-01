package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.StatutActiviteAvisDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.StatutActiviteAvisRM;
import com.leasurecompagnon.ws.model.bean.catalogue.StatutActiviteAvis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

@Named
public class StatutActiviteAvisDaoImpl extends AbstractDaoImpl implements StatutActiviteAvisDao {

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(StatutActiviteAvisDaoImpl.class);
	
	@Override
	public StatutActiviteAvis getStatutActiviteAvis (int statutActiviteAvisId) throws NotFoundException {
		LOGGER.info("Méthode getStatutActiviteAvis (int statutActiviteAvisId)");
		String vSQL="SELECT * FROM public.statut_activite_avis WHERE id ="+statutActiviteAvisId+ " ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<StatutActiviteAvis> vRowMapper=new StatutActiviteAvisRM();
		List<StatutActiviteAvis> vListStatutActiviteAvis =vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListStatutActiviteAvis.size()!=0)
			return vListStatutActiviteAvis.get(0);
		else
			throw new NotFoundException("Aucun statut d'activité ne correspond à l'id demandé");
	}
}