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
import com.leasurecompagnon.ws.model.exception.TechnicalException;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.AjoutActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.CatalogueService;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetDureeFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteRechercheFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListActiviteVilleTAFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListAvisUtilisateurFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDepartementFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDepartementFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDureeFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListDureeFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListNomActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListNomVilleFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListPaysFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListPaysFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListRegionFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListRegionFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListSaisonFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListSaisonFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListTypeActiviteFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListVilleFault;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListVilleFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetListVilleRechercheFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetSaisonFault_Exception;
import com.leasurecompagnon.ws.webapp.catalogueservice.generated.GetTypeActiviteFault_Exception;
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
	public Ville getVille(int villeId) throws GetVilleFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Saison getSaison(int saisonId) throws GetSaisonFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activite> getListActivite(int nbActivite, String statutActivite) throws GetListActiviteFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activite getActivite(int activiteId) throws GetActiviteFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void ajoutActivite(Activite activite) throws AjoutActiviteFault_Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getListNomVille() throws GetListNomVilleFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeActivite getTypeActivite(int typeActiviteId) throws GetTypeActiviteFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activite> getListActiviteVille(int villeId, String statutActivite)
			throws GetListActiviteVilleFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avis> getListAvisUtilisateur(int utilisateurId, String statutAvis)
			throws GetListAvisUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Duree getDuree(int dureeId) throws GetDureeFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeActivite> getListTypeActivite() throws GetListTypeActiviteFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activite> getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite)
			throws GetListActiviteVilleTAFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListNomActivite() throws GetListNomActiviteFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activite> getListActiviteRecherche(String nomRecherche, String statutActivite)
			throws GetListActiviteRechercheFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> getListVilleRecherche(String nomRecherche) throws GetListVilleRechercheFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activite> getListActiviteUtilisateur(int utilisateurId, String statutActivite)
			throws GetListActiviteUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}