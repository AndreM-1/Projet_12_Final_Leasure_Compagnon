package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.PhotoRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.Photo;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class PhotoDaoImpl extends AbstractDaoImpl implements PhotoDao{

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(PhotoDaoImpl.class);
	
	@Override
	public Photo getPhotoVille(int villeId) throws NotFoundException{
		LOGGER.info("Méthode getPhotoVille(int villeId)");
		String vSQL="SELECT * FROM public.photo WHERE ville_id ="+villeId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Photo> vRowMapper=new PhotoRM();
		List<Photo> vListPhoto= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListPhoto.size()!=0)
			return vListPhoto.get(0);
		else
			throw new NotFoundException("Aucune photo pour la ville demandée");
		
	}
	
	@Override
	public Photo getPhotoUtilisateur(int utilisateurId) throws NotFoundException{
		LOGGER.info("Méthode getPhotoUtilisateur(int utilisateurId)");
		String vSQL="SELECT * FROM public.photo WHERE utilisateur_id ="+utilisateurId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Photo> vRowMapper=new PhotoRM();
		List<Photo> vListPhoto= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListPhoto.size()!=0)
			return vListPhoto.get(0);
		else
			throw new NotFoundException("Aucune photo de profil pour l'utilisateur demandé");
		
	}
	
	@Override
	public List<Photo> getListPhotoActivite(int activiteId) throws NotFoundException{
		LOGGER.info("Méthode getListPhotoActivite(int activiteId)");
		String vSQL="SELECT * FROM public.photo WHERE activite_id ="+activiteId+" ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Photo> vRowMapper=new PhotoRM();
		List<Photo> vListPhoto= vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListPhoto.size()!=0)
			return vListPhoto;
		else
			throw new NotFoundException("Aucune photo pour l'activité demandée");	
	}
	
	@Override
	public void insertPhotoUtilisateur(String nomPhoto,String provenancePhoto,String typePhoto,int utilisateurId) throws FunctionalException {
		LOGGER.info("Méthode insertPhotoUtilisateur(String nomPhoto,String provenancePhoto,String typePhoto,int utilisateurId)");
		String vSQL="INSERT INTO public.photo(nom_photo,provenance_photo,type_photo,utilisateur_id) VALUES (:nomPhoto,:provenancePhoto,:typePhoto,:utilisateurId)";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nomPhoto", nomPhoto);
		vParams.addValue("provenancePhoto", provenancePhoto);
		vParams.addValue("typePhoto", typePhoto);
		vParams.addValue("utilisateurId", utilisateurId);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vJdbcTemplate.update(vSQL, vParams);
		} catch (DuplicateKeyException vEx) {
			LOGGER.info("L'utilisateur a déjà une photo en base de données");
			throw new FunctionalException("L'utilisateur a déjà une photo en base de données");
		}
	}
	
	@Override
	public void insertPhotoActivite(Activite activite) throws FunctionalException {
		LOGGER.info("Méthode insertPhotoActivite(Activite activite)");
		String vSQL="INSERT INTO public.photo(nom_photo,provenance_photo,type_photo,activite_id) VALUES (:nomPhoto,:provenancePhoto,:typePhoto,:activiteId)";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		int activiteId= activite.getId();
		for(Photo vPhoto : activite.getListPhotoActivite()) {
			vParams.addValue("nomPhoto", vPhoto.getNomPhoto());
			vParams.addValue("provenancePhoto", vPhoto.getProvenancePhoto());
			vParams.addValue("typePhoto", vPhoto.getTypePhoto());
			vParams.addValue("activiteId", activiteId);
			try {
				vJdbcTemplate.update(vSQL, vParams);
			} catch (DuplicateKeyException e) {
				LOGGER.info("Désolé, mais une demande d'ajout pour cette activité dans la ville demandée a été effectuée aujourd'hui même.");
				throw new FunctionalException("Désolé, mais une demande d'ajout pour cette activité dans la ville demandée a été effectuée aujourd'hui même.");
			}
		}
	}
	
	@Override
	public void deletePhotoActivite (int activiteId) throws TechnicalException {
		LOGGER.info("Méthode deletePhotoActivite (int activiteId)");
		String vSQL="DELETE FROM public.photo WHERE activite_id=:activiteId";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("activiteId", activiteId);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		try {
			vJdbcTemplate.update(vSQL, vParams);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}	
	}
}