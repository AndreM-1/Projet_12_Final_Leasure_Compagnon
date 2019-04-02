package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
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
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

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

	@Override
	public Utilisateur getUtilisateur(String adresseMail) throws NotFoundException {
		LOGGER.info("Méthode getUtilisateur(String adresseMail)");
		String vSQL="SELECT * FROM public.utilisateur WHERE adresse_mail=:adresseMail";

		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("adresseMail", adresseMail);

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		RowMapper<Utilisateur> vRowMapper=new UtilisateurRM(photoDao);
		List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL,vParams,vRowMapper);

		if(vListUtilisateur.size()!=0)	{
			return vListUtilisateur.get(0);
		}
		else
			throw new NotFoundException("Méthode getUtilisateur(String adresseMail) - Aucun utilisateur correspondant à l'adresse mail demandée.");
	}

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws FunctionalException {
		LOGGER.info("Méthode insertUtilisateur(Utilisateur utilisateur)");
		String vSQL="INSERT INTO public.utilisateur(civilite,nom,prenom,pseudo,adresse_mail,salt,mot_de_passe_securise,date_inscription,envoi_mail_informatif,administrateur) "
				+ "VALUES (:civilite, :nom, :prenom, :pseudo, :adresseMail, :salt, :motDePasseSecurise, :dateInscription, :envoiMailInformatif, :administrateur)";

		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("civilite", utilisateur.getCivilite());
		vParams.addValue("nom", utilisateur.getNom());
		vParams.addValue("prenom",utilisateur.getPrenom());
		vParams.addValue("pseudo", utilisateur.getPseudo());
		vParams.addValue("adresseMail", utilisateur.getAdresseMail());
		vParams.addValue("salt", utilisateur.getSalt());
		vParams.addValue("motDePasseSecurise", utilisateur.getMotDePasseSecurise());
		vParams.addValue("dateInscription", new Date());
		vParams.addValue("envoiMailInformatif", utilisateur.isEnvoiMailInformatif());
		vParams.addValue("administrateur", utilisateur.isAdministrateur());

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vJdbcTemplate.update(vSQL, vParams);
		} catch (DuplicateKeyException e) {
			LOGGER.info("Le pseudo ou l'adresse mail existe déjà.");
			throw new FunctionalException("Le pseudo ou l'adresse mail existe déjà.");
		}
	}


	@Override
	public void updateCoordUtilisateur(Utilisateur utilisateur) throws FunctionalException {
		LOGGER.info("Méthode updateCoordUtilisateur(Utilisateur utilisateur)");
		String vSQL="UPDATE public.utilisateur SET civilite=:civilite, nom=:nom, prenom=:prenom, pseudo=:pseudo, adresse_mail=:adresseMail, telephone=:telephone,"
				+ " date_naissance=:dateNaissance, adresse=:adresse, code_postal=:codePostal, ville=:ville, pays=:pays WHERE id=:id";

		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("civilite", utilisateur.getCivilite());
		vParams.addValue("nom", utilisateur.getNom());
		vParams.addValue("prenom",utilisateur.getPrenom());
		vParams.addValue("pseudo", utilisateur.getPseudo());
		vParams.addValue("adresseMail", utilisateur.getAdresseMail());
		vParams.addValue("telephone",utilisateur.getTelephone());
		Date dateNaissanceFormatDate=null;
		
		if(utilisateur.getDateNaissance()!=null) {
			dateNaissanceFormatDate=utilisateur.getDateNaissance().toGregorianCalendar().getTime();
			LOGGER.info("Date de naissance en format Date : "+dateNaissanceFormatDate);
		}
		
		vParams.addValue("dateNaissance",dateNaissanceFormatDate);
		vParams.addValue("adresse",utilisateur.getAdresse());
		vParams.addValue("codePostal",utilisateur.getCodePostal());
		vParams.addValue("ville",utilisateur.getVille());
		vParams.addValue("pays",utilisateur.getPays());
		vParams.addValue("id",utilisateur.getId());
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vJdbcTemplate.update(vSQL, vParams);
		} catch (DuplicateKeyException e) {
			LOGGER.info("Le pseudo ou l'adresse mail existe déjà.");
			throw new FunctionalException("Le pseudo ou l'adresse mail existe déjà.");
		}
	}
	
	@Override
	public void updateMdpUtilisateur (Utilisateur utilisateur) {
		LOGGER.info("Méthode updateMdpUtilisateur (Utilisateur utilisateur)");
		
		//En procédant ainsi, on évite les problèmes d'injection SQL. Pas besoin de requête préparée dans ce cas.
		String vSQL="UPDATE public.utilisateur SET mot_de_passe_securise=:motDePasseSecurise, salt=:salt WHERE id=:id";

		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("motDePasseSecurise", utilisateur.getMotDePasseSecurise());
		vParams.addValue("salt", utilisateur.getSalt());
		vParams.addValue("id",utilisateur.getId());

		NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL,vParams);
	}
	
	@Override
	public void updateParametresUtilisateur(int id, boolean envoiMailInformatif) throws TechnicalException {
		LOGGER.info("Méthode updateParametresUtilisateur(int id, boolean envoiMailInformatif)");
		String vSQL="UPDATE public.utilisateur SET envoi_mail_informatif=:envoiMailInformatif WHERE id=:id";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("envoiMailInformatif",envoiMailInformatif);
		vParams.addValue("id",id);
		
		NamedParameterJdbcTemplate vJdbcTemplate=new NamedParameterJdbcTemplate(getDataSource());
		try {
			vJdbcTemplate.update(vSQL,vParams);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
	}
	
	@Override
	public List<Utilisateur> getListUtilisateur(String optEnvoiMailInformatif) throws NotFoundException {
		LOGGER.info("Méthode getListUtilisateur(String optEnvoiMailInformatif)");
		//A noter la subtilité WHERE 1=1 pour inclure la clause WHERE dès le départ.
		String vSQL="SELECT * FROM public.utilisateur WHERE 1=1";
		
		switch(optEnvoiMailInformatif) {
		case "OPT_ACTIVE" : 
			vSQL+=" AND envoi_mail_informatif=true";
			break;
		case "OPT_DESACTIVE" : 
			vSQL+=" AND envoi_mail_informatif=false";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Utilisateur> vRowMapper=new UtilisateurRM(photoDao);
		List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListUtilisateur.size()!=0)
			return vListUtilisateur;
		else
			throw new NotFoundException("Aucun utilisateur avec la valeur d'option d'envoi mail informatif demandé.");
	}
}