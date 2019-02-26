package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.PhotoRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Photo;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

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
}
