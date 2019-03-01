package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.contract.dao.VilleDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.VilleRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
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
	
	@Override
	public Ville getVille(int villeId) throws NotFoundException {
		LOGGER.info("Méthode getVille(int villeId)");
		String vSQL="SELECT * FROM public.ville WHERE id ="+villeId+ " ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Ville> vRowMapper=new VilleRM(coordonneeGPSDao,photoDao,departementDao);
		List<Ville> vListVille = vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListVille.size()!=0)
			return vListVille.get(0);
		else
			throw new NotFoundException("Aucune ville ne correspond à l'id demandé");
	}
	
	@Override
	public List<String> getListNomVille() throws TechnicalException {
		LOGGER.info("Méthode getListNomVille()");
		String vSQL="SELECT * FROM public.ville ORDER BY id ASC";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Ville> vRowMapper=new VilleRM(coordonneeGPSDao,photoDao,departementDao);
		List<Ville> vListVille;
		try {
			vListVille = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		List<String> vListNomVille = new ArrayList<>();
		for(Ville vVille : vListVille) {
			vListNomVille.add(vVille.getNomVille());
		}
		return vListNomVille;
	}
	
	@Override
	public List<Ville> getListVilleRecherche(String nomRecherche) throws NotFoundException {
		LOGGER.info("Méthode getListVilleRecherche(String nomRecherche)");
		String vSQL="SELECT * FROM public.ville WHERE REPLACE(TRIM(LOWER(nom_ville)),' ','') LIKE :nomRecherche ORDER BY id ASC";

		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nomRecherche", nomRecherche);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		RowMapper<Ville> vRowMapper=new VilleRM(coordonneeGPSDao,photoDao,departementDao);
		List<Ville> vListVille = vJdbcTemplate.query(vSQL,vParams,vRowMapper);
		
		if(vListVille.size()!=0)
			return vListVille;
		else
			throw new NotFoundException("Aucune ville ne correspond à la chaîne de caractères recherchée");
	}
}