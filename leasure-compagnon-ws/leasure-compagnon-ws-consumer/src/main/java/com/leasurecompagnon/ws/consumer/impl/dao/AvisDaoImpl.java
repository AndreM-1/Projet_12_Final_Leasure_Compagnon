package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.AvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.StatutActiviteAvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.AvisRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

@Named
public class AvisDaoImpl extends AbstractDaoImpl implements AvisDao {
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Inject
	private StatutActiviteAvisDao statutActiviteAvisDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AvisDaoImpl.class);
	
	@Override
	public List<Avis> getListAvisActivite(int activiteId,String statutAvis) throws NotFoundException {
		LOGGER.info("Méthode getListAvisActivite(int activiteId,String statutAvis)");
		String vSQL="SELECT * FROM public.avis WHERE activite_id ="+activiteId;
		switch(statutAvis) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		vSQL+=" ORDER BY date_mise_en_ligne_avis DESC";
		LOGGER.info("vSQL = "+vSQL);
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Avis> vRowMapper=new AvisRM(utilisateurDao,statutActiviteAvisDao);
		List<Avis> vListAvis= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListAvis.size()!=0)
			return vListAvis;
		else
			throw new NotFoundException("Aucun avis avec le statut désiré pour l'activité demandée");
	}
	
	@Override
	public List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis) throws NotFoundException {
		LOGGER.info("Méthode getListAvisUtilisateur(int utilisateurId, String statutAvis)");
		String vSQL="SELECT * FROM public.avis WHERE utilisateur_id ="+utilisateurId;
		switch(statutAvis) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		vSQL+=" ORDER BY date_mise_en_ligne_avis DESC";
		LOGGER.info("vSQL = "+vSQL);
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Avis> vRowMapper=new AvisRM(utilisateurDao,statutActiviteAvisDao);
		List<Avis> vListAvis= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListAvis.size()!=0)
			return vListAvis;
		else
			throw new NotFoundException("Aucun avis avec le statut souhaité pour l'utilisateur demandé ou aucun avis posté par l'utilisateur");
	}
	
}