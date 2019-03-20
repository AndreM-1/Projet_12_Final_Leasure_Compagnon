package com.leasurecompagnon.ws.webapp.catalogueservice.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.ws.business.contract.ManagerFactory;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.AjoutActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.AjoutAvisFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.AjoutAvisFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.CatalogueService;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetActiviteFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetActiviteNomFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetActiviteNomFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetDureeFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetDureeFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteRechercheFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteRechercheFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteUtilisateurFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleNomFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleNomFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleTAFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleTAFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListAvisUtilisateurFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListAvisUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDepartementFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDepartementFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDureeFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDureeFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListNomActiviteFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListNomActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListNomVilleFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListNomVilleFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListPaysFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListPaysFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListRegionFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListRegionFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListSaisonFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListSaisonFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListTypeActiviteFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListTypeActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListVilleFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListVilleFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListVilleRechercheFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListVilleRechercheFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetSaisonFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetSaisonFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetTypeActiviteFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetTypeActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetVilleFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetVilleFault_Exception;

public class CatalogueServiceImpl implements CatalogueService{
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private List<Ville> listVille;	
	private List<Pays> listPays;	
	private List<Region> listRegion;
	private List<Departement> listDepartement;
	private List<Duree> listDuree;
	private List<Saison> listSaison;
	private List <TypeActivite> listTypeActivite;
	private List<Activite> listActivite;
	private List<String> listNomVille;
	private List<String> listNomActivite;
	private List<Avis> listAvis;
	private Ville ville;
	private Duree duree;
	private Saison saison;
	private TypeActivite typeActivite;
	private Activite activite;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(CatalogueServiceImpl.class);

	@Override
	public List<Ville> getListVille(int nbVille) throws GetListVilleFault_Exception {
		LOGGER.info("Méthode getListVille(int nbVille)");
		try {
			listVille=managerFactory.getVilleManager().getListVille(nbVille);
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListVilleFault getListVilleFault = new GetListVilleFault();
			getListVilleFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListVilleFault_Exception(tExc.getMessage(),getListVilleFault);	
		}
		return listVille;
	}

	@Override
	public List<Pays> getListPays() throws GetListPaysFault_Exception {
		LOGGER.info("Méthode getListPays()");
		try {
			listPays=managerFactory.getPaysManager().getListPays();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListPaysFault getListPaysFault=new GetListPaysFault();
			getListPaysFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListPaysFault_Exception(tExc.getMessage(),getListPaysFault);	
		}
		return listPays;
	}
	
	@Override
	public List<Region> getListRegion() throws GetListRegionFault_Exception {
		LOGGER.info("Méthode getListRegion()");
		try {
			listRegion=managerFactory.getRegionManager().getListRegion();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListRegionFault getListRegionFault=new GetListRegionFault();
			getListRegionFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListRegionFault_Exception(tExc.getMessage(),getListRegionFault);		
		}
		return listRegion;
	}
	
	@Override
	public List<Departement> getListDepartement() throws GetListDepartementFault_Exception {
		LOGGER.info("Méthode getListDepartement()");
		try {
			listDepartement=managerFactory.getDepartementManager().getListDepartement();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListDepartementFault getListDepartementFault=new GetListDepartementFault();
			getListDepartementFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListDepartementFault_Exception(tExc.getMessage(),getListDepartementFault);		
		}
		return listDepartement;
	}
	
	@Override
	public List<Duree> getListDuree() throws GetListDureeFault_Exception {
		LOGGER.info("Méthode getListDuree()");
		try {
			listDuree=managerFactory.getDureeManager().getListDuree();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListDureeFault getListDureeFault=new GetListDureeFault();
			getListDureeFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListDureeFault_Exception(tExc.getMessage(),getListDureeFault);		
		}
		return listDuree;
	}
	
	@Override
	public List<Saison> getListSaison() throws GetListSaisonFault_Exception {
		LOGGER.info("Méthode getListSaison()");
		try {
			listSaison=managerFactory.getSaisonManager().getListSaison();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListSaisonFault getListSaisonFault=new GetListSaisonFault();
			getListSaisonFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListSaisonFault_Exception(tExc.getMessage(),getListSaisonFault);	
		}
		return listSaison;
	}
	
	@Override
	public List<TypeActivite> getListTypeActivite() throws GetListTypeActiviteFault_Exception {
		LOGGER.info("Méthode getListTypeActivite()");
		try {
			listTypeActivite=managerFactory.getTypeActiviteManager().getListTypeActivite();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListTypeActiviteFault getListTypeActiviteFault = new GetListTypeActiviteFault();
			getListTypeActiviteFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListTypeActiviteFault_Exception(tExc.getMessage(),getListTypeActiviteFault);	
		}
		return listTypeActivite;
	}

	@Override
	public Ville getVille(int villeId) throws GetVilleFault_Exception {
		LOGGER.info("Méthode getVille(int villeId)");
		try {
			ville=managerFactory.getVilleManager().getVille(villeId);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetVilleFault getVilleFault = new GetVilleFault();
			getVilleFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetVilleFault_Exception(nfExc.getMessage(),getVilleFault);
		}
		return ville;
	}
	
	@Override
	public Duree getDuree(int dureeId) throws GetDureeFault_Exception {
		LOGGER.info("Méthode getDuree(int dureeId)");
		try {
			duree=managerFactory.getDureeManager().getDuree(dureeId);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetDureeFault getDureeFault = new GetDureeFault();
			getDureeFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetDureeFault_Exception(nfExc.getMessage(),getDureeFault);
		}
		return duree;
	}

	@Override
	public Saison getSaison(int saisonId) throws GetSaisonFault_Exception {
		LOGGER.info("Méthode getSaison(int saisonId)");
		try {
			saison=managerFactory.getSaisonManager().getSaison(saisonId);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetSaisonFault getSaisonFault =new GetSaisonFault(); 
			getSaisonFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetSaisonFault_Exception(nfExc.getMessage(),getSaisonFault);
		}
		return saison;
	}
	
	@Override
	public TypeActivite getTypeActivite(int typeActiviteId) throws GetTypeActiviteFault_Exception {
		LOGGER.info("Méthode getTypeActivite(int typeActiviteId)");
		try {
			typeActivite=managerFactory.getTypeActiviteManager().getTypeActivite(typeActiviteId);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetTypeActiviteFault getTypeActiviteFault = new GetTypeActiviteFault();
			getTypeActiviteFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetTypeActiviteFault_Exception(nfExc.getMessage(),getTypeActiviteFault);
		}
		return typeActivite;
	}
	
	
	@Override
	public Activite getActivite(int activiteId) throws GetActiviteFault_Exception {
		LOGGER.info("Méthode getActivite(int activiteId)");
		try {
			activite=managerFactory.getActiviteManager().getActivite(activiteId);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetActiviteFault getActiviteFault = new GetActiviteFault();
			getActiviteFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetActiviteFault_Exception (nfExc.getMessage(),getActiviteFault);
		}
		return activite;
	}

	
	@Override
	public List<Activite> getListActivite(int nbActivite, String statutActivite) throws GetListActiviteFault_Exception {
		LOGGER.info("Méthode getListActivite(int nbActivite, String statutActivite)");
		try {
			listActivite=managerFactory.getActiviteManager().getListActivite(nbActivite,statutActivite);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetListActiviteFault getListActiviteFault = new GetListActiviteFault();
			getListActiviteFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetListActiviteFault_Exception (nfExc.getMessage(),getListActiviteFault);
			
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteVille(int villeId, String statutActivite)
			throws GetListActiviteVilleFault_Exception {
		LOGGER.info("Méthode getListActiviteVille(int villeId, String statutActivite)");
		try {
			listActivite=managerFactory.getActiviteManager().getListActiviteVille(villeId, statutActivite);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetListActiviteVilleFault getListActiviteVilleFault = new GetListActiviteVilleFault();
			getListActiviteVilleFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetListActiviteVilleFault_Exception (nfExc.getMessage(),getListActiviteVilleFault);
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite)
			throws GetListActiviteVilleTAFault_Exception {
		LOGGER.info("Méthode getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite)");
		try {
			listActivite=managerFactory.getActiviteManager().getListActiviteVilleTA(villeId, typeActiviteId, statutActivite);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetListActiviteVilleTAFault getListActiviteVilleTAFault = new GetListActiviteVilleTAFault();
			getListActiviteVilleTAFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetListActiviteVilleTAFault_Exception(nfExc.getMessage(),getListActiviteVilleTAFault);
		}
		return listActivite;
	}
	
	@Override
	public List<Activite> getListActiviteUtilisateur(int utilisateurId, String statutActivite)
			throws GetListActiviteUtilisateurFault_Exception {
		LOGGER.info("Méthode getListActiviteUtilisateur(int utilisateurId, String statutActivite)");
		try {
			listActivite=managerFactory.getActiviteManager().getListActiviteUtilisateur(utilisateurId, statutActivite);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetListActiviteUtilisateurFault getListActiviteUtilisateurFault = new GetListActiviteUtilisateurFault();
			getListActiviteUtilisateurFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetListActiviteUtilisateurFault_Exception (nfExc.getMessage(),getListActiviteUtilisateurFault);
		}
		return listActivite;
	}
	
	@Override
	public List<String> getListNomVille() throws GetListNomVilleFault_Exception {
		LOGGER.info("Méthode getListNomVille()");
		try {
			listNomVille=managerFactory.getVilleManager().getListNomVille();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListNomVilleFault getListNomVilleFault = new GetListNomVilleFault();
			getListNomVilleFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListNomVilleFault_Exception (tExc.getMessage(),getListNomVilleFault);
		}
		return listNomVille;
	}
	
	@Override
	public List<String> getListNomActivite() throws GetListNomActiviteFault_Exception {
		LOGGER.info("Méthode getListNomActivite()");
		try {
			listNomActivite=managerFactory.getActiviteManager().getListNomActivite();
		} catch (TechnicalException tExc) {
			LOGGER.info(tExc.getMessage());
			GetListNomActiviteFault getListNomActiviteFault = new GetListNomActiviteFault();
			getListNomActiviteFault.setFaultMessageErreur(tExc.getMessage());
			throw new GetListNomActiviteFault_Exception(tExc.getMessage(),getListNomActiviteFault);
		}
		return listNomActivite;
	}
	
	@Override
	public List<Ville> getListVilleRecherche(String nomRecherche) throws GetListVilleRechercheFault_Exception {
		LOGGER.info("Méthode getListVilleRecherche(String nomRecherche)");
		try {
			listVille=managerFactory.getVilleManager().getListVilleRecherche(nomRecherche);
		} catch (FunctionalException | NotFoundException fnfExc) {
			LOGGER.info(fnfExc.getMessage());
			GetListVilleRechercheFault getListVilleRechercheFault = new GetListVilleRechercheFault();
			getListVilleRechercheFault.setFaultMessageErreur(fnfExc.getMessage());
			throw new GetListVilleRechercheFault_Exception(fnfExc.getMessage(),getListVilleRechercheFault);
		}
		return listVille;
	}
	
	@Override
	public List<Activite> getListActiviteRecherche(String nomRecherche, String statutActivite)
			throws GetListActiviteRechercheFault_Exception {
		LOGGER.info("Méthode getListActiviteRecherche(String nomRecherche, String statutActivite)");
		try {
			listActivite=managerFactory.getActiviteManager().getListActiviteRecherche(nomRecherche, statutActivite);
		} catch (FunctionalException | NotFoundException fnfExc) {
			LOGGER.info(fnfExc.getMessage());
			GetListActiviteRechercheFault getListActiviteRechercheFault = new GetListActiviteRechercheFault();
			getListActiviteRechercheFault.setFaultMessageErreur(fnfExc.getMessage());
			throw new GetListActiviteRechercheFault_Exception (fnfExc.getMessage(),getListActiviteRechercheFault);
		}
		return listActivite;
	}
	
	@Override
	public List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis)
			throws GetListAvisUtilisateurFault_Exception {
		LOGGER.info("Méthode getListAvisUtilisateur(int utilisateurId, String statutAvis)");
		try {
			listAvis=managerFactory.getAvisManager().getListAvisUtilisateur(utilisateurId, statutAvis);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetListAvisUtilisateurFault getListAvisUtilisateurFault = new GetListAvisUtilisateurFault();
			getListAvisUtilisateurFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetListAvisUtilisateurFault_Exception (nfExc.getMessage(),getListAvisUtilisateurFault);
		}
		return listAvis;
	}

	@Override
	public List<Activite> getListActiviteVilleNom(String nomVille, String statutActivite)
			throws GetListActiviteVilleNomFault_Exception {
		LOGGER.info("Méthode getListActiviteVilleNom(String nomVille, String statutActivite)");
		try {
			listActivite=managerFactory.getActiviteManager().getListActiviteVille(nomVille, statutActivite);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetListActiviteVilleNomFault getListActiviteVilleNomFault = new GetListActiviteVilleNomFault();
			getListActiviteVilleNomFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetListActiviteVilleNomFault_Exception(nfExc.getMessage(),getListActiviteVilleNomFault);
		}
		return listActivite;
	}
	
	@Override
	public Activite getActiviteNom(String nomActivite) throws GetActiviteNomFault_Exception {
		LOGGER.info("Méthode getActiviteNom(String nomActivite)");
		try {
			activite=managerFactory.getActiviteManager().getActivite(nomActivite);
		} catch (NotFoundException nfExc) {
			LOGGER.info(nfExc.getMessage());
			GetActiviteNomFault getActiviteNomFault =new GetActiviteNomFault();
			getActiviteNomFault.setFaultMessageErreur(nfExc.getMessage());
			throw new GetActiviteNomFault_Exception(nfExc.getMessage(),getActiviteNomFault);
		}
		return activite;
	}
	
	@Override
	public void ajoutAvis(String commentaire, String appreciation, int utilisateurId, int activiteId)
			throws AjoutAvisFault_Exception {
		LOGGER.info("Méthode ajoutAvis(String commentaire, String appreciation, int utilisateurId, int activiteId)");
		try {
			managerFactory.getAvisManager().insertAvis(commentaire, appreciation, utilisateurId, activiteId);
		} catch (FunctionalException fExc) {
			LOGGER.info(fExc.getMessage());
			AjoutAvisFault ajoutAvisFault = new AjoutAvisFault();
			ajoutAvisFault.setFaultMessageErreur(fExc.getMessage());
			throw new AjoutAvisFault_Exception(fExc.getMessage(),ajoutAvisFault);
		}
	}
	
	@Override
	public void ajoutActivite(Activite activite) throws AjoutActiviteFault_Exception {
		// TODO Auto-generated method stub
		
	}
}