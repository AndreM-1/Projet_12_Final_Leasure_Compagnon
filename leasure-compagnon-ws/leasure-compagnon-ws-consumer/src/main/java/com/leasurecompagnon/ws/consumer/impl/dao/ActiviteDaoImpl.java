package com.leasurecompagnon.ws.consumer.impl.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.leasurecompagnon.ws.consumer.contract.dao.ActiviteDao;
import com.leasurecompagnon.ws.consumer.contract.dao.AvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.ws.consumer.contract.dao.StatutActiviteAvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.TypeActiviteDao;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.consumer.contract.dao.VilleDao;
import com.leasurecompagnon.ws.consumer.impl.rowmapper.catalogue.ActiviteRM;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

@Named
public class ActiviteDaoImpl extends AbstractDaoImpl implements ActiviteDao {
	
	@Inject
	private TypeActiviteDao typeActiviteDao;
	
	@Inject
	private DureeDao dureeDao;
	
	@Inject
	private SaisonDao saisonDao;
	
	@Inject
	private StatutActiviteAvisDao statutActiviteDao;
	
	@Inject
	private CoordonneeGPSDao coordonneeGPSDao;
	
	@Inject
	private PhotoDao photoDao;
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Inject
	private VilleDao villeDao;
	
	@Inject
	private AvisDao avisDao;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(ActiviteDaoImpl.class);
	
	@Override
	public Activite getActivite(int activiteId) throws NotFoundException {
		LOGGER.info("Méthode getActivite(int activiteId)");
		String vSQL="SELECT * FROM public.activite WHERE id ="+activiteId+ " ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL, vRowMapper);
		
		if(vListActivite.size()!=0)
			return vListActivite.get(0);
		else
			throw new NotFoundException("Aucune activité ne correspond à l'id demandé");
	}
	
	@Override
	public List<Activite> getListActivite(int nbActivite, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActivite(int nbActivite, String statutActivite)");
		//A noter la subtilité WHERE 1=1 pour inclure la clause WHERE dès le départ.
		String vSQL="SELECT * FROM public.activite WHERE 1=1";
		
		switch(statutActivite) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "VR" :
			vSQL+=" AND statut_activite_avis_id IN (2,3)";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		
		if(nbActivite>=0)
			vSQL+=" ORDER BY date_mise_en_ligne DESC, id DESC LIMIT "+nbActivite;
		else
			vSQL+=" ORDER BY date_mise_en_ligne DESC, id DESC";
		
		LOGGER.info("vSQL = "+vSQL);
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL, vRowMapper);
		if(vListActivite.size()!=0)
			return vListActivite;
		else
			throw new NotFoundException("Aucune activité avec le statut demandé");
	}
	
	@Override
	public List<Activite> getListActiviteVille(int villeId, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActiviteVille(int villeId, String statutActivite)");
		String vSQL="SELECT * FROM public.activite WHERE ville_id ="+villeId;
		
		switch(statutActivite) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "VR" :
			vSQL+=" AND statut_activite_avis_id IN (2,3)";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		vSQL+=" ORDER BY date_mise_en_ligne DESC, id DESC";
		LOGGER.info("vSQL = "+vSQL);
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL, vRowMapper);
		if(vListActivite.size()!=0)
			return vListActivite;
		else
			throw new NotFoundException("Aucune activité avec le statut désiré pour la ville demandée ou aucune activité pour la ville demandée");
	}
	
	@Override
	public List<Activite> getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite)");
		String vSQL="SELECT activite.* FROM public.activite_type_activite"
				+ " INNER JOIN activite ON activite_id=activite.id"
				+ " INNER JOIN type_activite ON type_activite_id=type_activite.id"
				+ " WHERE ville_id="+villeId+" AND type_activite.id="+typeActiviteId;
		
		switch(statutActivite) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "VR" :
			vSQL+=" AND statut_activite_avis_id IN (2,3)";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		vSQL+=" ORDER BY date_mise_en_ligne DESC, activite.id DESC";
		LOGGER.info("vSQL = "+vSQL);
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL, vRowMapper);
		if(vListActivite.size()!=0)
			return vListActivite;
		else
			throw new NotFoundException("Aucune activité correspondant au type d'activité et au statut désirés pour la ville demandée ou aucune activité pour la ville demandée");
	}
	
	@Override
	public List<Activite> getListActiviteUtilisateur(int utilisateurId, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActiviteUtilisateur(int utilisateurId, String statutActivite)");
		String vSQL="SELECT * FROM public.activite WHERE utilisateur_id="+utilisateurId;
		
		switch(statutActivite) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "VR" :
			vSQL+=" AND statut_activite_avis_id IN (2,3)";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		vSQL+=" ORDER BY date_mise_en_ligne DESC, id DESC";
		LOGGER.info("vSQL = "+vSQL);
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL, vRowMapper);
		if(vListActivite.size()!=0)
			return vListActivite;
		else
			throw new NotFoundException("Aucune activité avec le statut souhaité pour l'utilisateur demandé ou aucune activité postée par l'utilisateur");
	}
	
	@Override
	public List<String> getListNomActivite() throws TechnicalException {
		LOGGER.info("Méthode getListNomActivite()");
		String vSQL="SELECT * FROM public.activite WHERE statut_activite_avis_id = 4 ORDER BY id ASC";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite;
		try {
			vListActivite = vJdbcTemplate.query(vSQL, vRowMapper);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
			throw new TechnicalException("Erreur technique lors de l'accès en base de données.");
		}
		List<String> vListNomActivite= new ArrayList<>();
		for(Activite vActivite : vListActivite) {
			vListNomActivite.add(vActivite.getNomActivite());
		}
		return vListNomActivite;
	}
	
	@Override
	public List<Activite> getListActiviteRecherche(String nomRecherche, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActiviteRecherche(String nomRecherche, String statutActivite)");
		String vSQL="SELECT * FROM public.activite WHERE REPLACE(TRIM(LOWER(nom_activite)),' ','') LIKE :nomRecherche";
		
		switch(statutActivite) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "VR" :
			vSQL+=" AND statut_activite_avis_id IN (2,3)";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		vSQL+=" ORDER BY id ASC";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nomRecherche", nomRecherche);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL,vParams,vRowMapper);
		
		if(vListActivite.size()!=0)
			return vListActivite;
		else
			throw new NotFoundException("Aucune activité ne correspond à la chaîne de caractères recherchée en fonction du statut demandé");
	}
	
	@Override
	public List<Activite> getListActiviteVille(String nomVille, String statutActivite) throws NotFoundException {
		LOGGER.info("Méthode getListActiviteVille(String nomVille, String statutActivite)");
		//Utilisation d'une sous-requête pour une fois (on aurait tout aussi bien pu utiliser une jointure interne).
		String vSQL="SELECT * FROM public.activite WHERE ville_id = (SELECT id FROM public.ville WHERE nom_ville = :nomVille)";
		
		switch(statutActivite) {
		case "ECDM" :
			vSQL+=" AND statut_activite_avis_id = 1";
			break;
		case "VR" :
			vSQL+=" AND statut_activite_avis_id IN (2,3)";
			break;
		case "MEL" :
			vSQL+=" AND statut_activite_avis_id = 4";
			break;
		default :
			LOGGER.info("Pas de traitement à effectuer dans la boucle switch");
		}
		vSQL+=" ORDER BY date_mise_en_ligne DESC, id DESC";
		LOGGER.info("vSQL = "+vSQL);
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nomVille", nomVille);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL,vParams,vRowMapper);
		
		if(vListActivite.size()!=0)
			return vListActivite;
		else
			throw new NotFoundException("Aucune activité avec le statut désiré pour la ville demandée ou aucune activité pour la ville demandée");
	}
	
	@Override
	public Activite getActivite(String nomActivite) throws NotFoundException {
		LOGGER.info("Méthode getActivite(String nomActivite)");
		String vSQL="SELECT * FROM public.activite WHERE nom_activite = :nomActivite ORDER BY id ASC";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		//On va prendre le même nom pour cet identifiant.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nomActivite", nomActivite);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		RowMapper<Activite> vRowMapper=new ActiviteRM(typeActiviteDao,dureeDao,saisonDao,statutActiviteDao,coordonneeGPSDao,photoDao,utilisateurDao,villeDao,avisDao);
		List<Activite> vListActivite = vJdbcTemplate.query(vSQL,vParams,vRowMapper);
		
		if(vListActivite.size()!=0)
			return vListActivite.get(0);
		else
			throw new NotFoundException("Aucune activité ne correspond au nom demandé");	
	}
	
	@Override
	public void insertActivite(Activite activite) {
		LOGGER.info("Méthode insertActivite(Activite activite)");
		String vSQL ="INSERT INTO public.activite(nom_activite, description, adresse, lien_horaire_ouverture, date_demande_ajout, utilisateur_id, ville_id, duree_id, saison_id, "
				+ "statut_activite_avis_id) VALUES (:nomActivite, :description, :adresse, :lienHoraireOuverture, :dateDemandeAjout, :utilisateurId, :villeId, :dureeId, :saisonId, "
				+ ":statutActiviteAvisId)";
		
		//On définit une MapSqlParameterSource dans laquelle on va mapper la valeur de nos paramètres d'entrée à un identifiant de type String.
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nomActivite", activite.getNomActivite());
		vParams.addValue("description", activite.getDescription());
		vParams.addValue("adresse", StringUtils.isEmpty(activite.getAdresse())?null:activite.getAdresse());
		vParams.addValue("lienHoraireOuverture", StringUtils.isEmpty(activite.getLienHoraireOuverture())?null:activite.getLienHoraireOuverture());
		vParams.addValue("dateDemandeAjout", new Date());
		vParams.addValue("utilisateurId", activite.getUtilisateur().getId());
		vParams.addValue("villeId", activite.getVille().getId());
		vParams.addValue("dureeId", activite.getDuree().getId());
		vParams.addValue("saisonId", activite.getSaison().getId());
		vParams.addValue("statutActiviteAvisId", 1);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);		
	}
	
	@Override
	public int getSequenceActivite() {
		String vSQL="SELECT CURRVAL('activite_id_seq')";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		int sequenceActivite = vJdbcTemplate.queryForObject(vSQL, Integer.class);
		return sequenceActivite;
	}
}