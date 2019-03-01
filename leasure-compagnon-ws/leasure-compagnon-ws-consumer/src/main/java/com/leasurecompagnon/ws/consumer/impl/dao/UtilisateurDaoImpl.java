package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao{
	
	@Inject
	private PhotoDao photoDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(UtilisateurDaoImpl.class);
	
	@Override
	public Utilisateur getUtilisateur(int utilisateurId) throws NotFoundException {
		LOGGER.info("getUtilisateur(int utilisateurId)");
		String vSQL="SELECT * FROM public.utilisateur WHERE id ="+utilisateurId+ " ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Utilisateur> vRowMapper=new UtilisateurRM(photoDao);
		List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListUtilisateur.size()!=0)
			return vListUtilisateur.get(0);
		else
			throw new NotFoundException("Aucun utilisateur ne correspond à l'id demandé");
	}
}