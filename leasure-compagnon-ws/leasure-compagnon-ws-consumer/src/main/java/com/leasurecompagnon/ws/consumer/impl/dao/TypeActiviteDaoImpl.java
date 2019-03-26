package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.leasurecompagnon.ws.consumer.contract.dao.TypeActiviteDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.TypeActiviteRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class TypeActiviteDaoImpl extends AbstractDaoImpl implements TypeActiviteDao {
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(TypeActiviteDaoImpl.class);
	
	@Override
	public List<TypeActivite> getListTypeActivite() throws TechnicalException {
		LOGGER.info("Méthode getListTypeActivite()");
		String vSQL="SELECT * FROM public.type_activite ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<TypeActivite> vRowMapper=new TypeActiviteRM();
		List<TypeActivite> vListTypeActivite;
		try {
			vListTypeActivite = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		return vListTypeActivite;		
	}
	
	@Override
	public TypeActivite getTypeActivite(int typeActiviteId) throws NotFoundException {
		LOGGER.info("Méthode getTypeActivite(int typeActiviteId)");
		String vSQL="SELECT * FROM public.type_activite WHERE id ="+typeActiviteId+ " ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<TypeActivite> vRowMapper=new TypeActiviteRM();
		List<TypeActivite> vListTypeActivite =vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListTypeActivite.size()!=0)
			return vListTypeActivite.get(0);
		else
			throw new NotFoundException("Aucun type d'activité ne correspond à l'id demandé");
	}
	
	@Override
	public List<TypeActivite> getListTypeActivite(int activiteId) throws NotFoundException {
		LOGGER.info("Méthode getListTypeActivite(int activiteId)");
		String vSQL = "SELECT type_activite.id, type_activite.type_activite FROM public.activite_type_activite"
				+ " INNER JOIN activite ON activite_id=activite.id"
				+ " INNER JOIN type_activite ON type_activite_id=type_activite.id"
				+ " WHERE activite.id="+activiteId
				+ " ORDER BY type_activite.id";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<TypeActivite> vRowMapper=new TypeActiviteRM();
		List<TypeActivite> vListTypeActivite =vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListTypeActivite.size()!=0)
			return vListTypeActivite;
		else 
			throw new NotFoundException ("Aucun type d'activité pour l'activité demandée");	
	}
	
	@Override
	public void insertTypeActivite(Activite activite) {
		LOGGER.info("Méthode insertTypeActivite(Activite activite)");
		String vSQL="INSERT INTO public.activite_type_activite(activite_id,type_activite_id) VALUES (:activiteId, :typeActiviteId)";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		int activiteId= activite.getId();
		for(TypeActivite vTypeActivite : activite.getListTypeActivite()) {
			vParams.addValue("activiteId", activiteId);
			vParams.addValue("typeActiviteId", vTypeActivite.getId());
			vJdbcTemplate.update(vSQL, vParams);
		}
	}
}