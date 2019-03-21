package com.leasurecompagnon.appliweb.webapp.action;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Activite;
import com.leasurecompagnon.appliweb.model.bean.catalogue.ActiviteAppliWeb;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Avis;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Ville;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteRechercheFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleRechercheFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer la recherche de villes et d'activités.
 * @author André Monnier
 *
 */
public class GestionRechercheAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -780139757973954980L;
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private List<Ville> listVille;	
	private List<Activite> listActivite;
	private List<ActiviteAppliWeb> listActiviteAppliWeb;
	private String nomRecherche;
	private String messageInformatifVille;
	private String messageInformatifActivite;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionRechercheAction.class);

	
	// ===================== Getters/Setters =====================
	public List<Ville> getListVille() {
		return listVille;
	}

	public List<Activite> getListActivite() {
		return listActivite;
	}
	
	public List<ActiviteAppliWeb> getListActiviteAppliWeb() {
		return listActiviteAppliWeb;
	}

	public void setNomRecherche(String nomRecherche) {
		this.nomRecherche = nomRecherche;
	}
	
	public String getMessageInformatifVille() {
		return messageInformatifVille;
	}

	public String getMessageInformatifActivite() {
		return messageInformatifActivite;
	}
	
	// ===================== Méthodes ============================
	
	/**
	 * Méthode permettant de renvoyer une liste de villes et/ou d'activités à partir d'une recherche
	 * de l'utilisateur ou un message informatif si rien n'est trouvé. 
	 * @return success
	 */
	public String doRechercheVilleActivite() {
		LOGGER.info("Méthode doRechercheVilleActivite()");
		LOGGER.info("Chaîne de caractères recherché : "+nomRecherche);
		try {
			listVille=managerFactory.getVilleManager().getListVilleRecherche(nomRecherche);
		} catch (GetListVilleRechercheFault_Exception e) {
			LOGGER.info(e.getMessage());
			if(e.getMessage().equals("Le nombre de caractères renseigné n'est pas suffisant. Veuillez renseigner au moins 3 caractères."))
				messageInformatifVille=e.getMessage();
			else
				messageInformatifVille="Aucune ville ne correspond à la recherche effectuée.";
		}
		
		try {
			listActivite=managerFactory.getActiviteManager().getListActiviteRecherche(nomRecherche, "MEL");
			
			listActiviteAppliWeb=new ArrayList<>();
			
			//On parcourt la liste d'activités.
			for(Activite vActivite : listActivite) {
				ActiviteAppliWeb vActiviteAppliWeb = new ActiviteAppliWeb();
				double vAppreciationMoyenneDouble=0.0d;
				//on récupère le bean Activite, le nom de la photo principale, le nombre d'avis et la moyenne des avis.
				vActiviteAppliWeb.setActivite(vActivite);
				vActiviteAppliWeb.setNomPhotoPrincipale(vActivite.getListPhotoActivite().get(0).getNomPhoto());	
				vActiviteAppliWeb.setNombreAvis(vActivite.getListAvis().size());
				vAppreciationMoyenneDouble=calculAppreciationMoyenneActivite(vActivite);
				vActiviteAppliWeb.setAppreciationMoyenneDouble(vAppreciationMoyenneDouble);
				
				//On l'ajout à la liste de beans de type ActiviteAppliWeb
				listActiviteAppliWeb.add(vActiviteAppliWeb);
			}
			
		} catch (GetListActiviteRechercheFault_Exception e) {
			LOGGER.info(e.getMessage());
			if(e.getMessage().equals("Le nombre de caractères renseigné n'est pas suffisant. Veuillez renseigner au moins 3 caractères."))
				messageInformatifActivite=e.getMessage();
			else
				messageInformatifActivite="Aucune activité ne correspond à la recherche effectuée.";		
		}
		return ActionSupport.SUCCESS;
	}
	
	
	/**
	 * Méthode permettant de calculer l'appréciation moyenne d'une activité.
	 * @param pActivite : L'activité en question.
	 * @return L'appréciation moyenne d'une activité.
	 */
	private double calculAppreciationMoyenneActivite(Activite pActivite) {
		double sommeAppreciation=0.0d;
		double appreciation=0.0d;
		int nombreAvis=pActivite.getListAvis().size();
		double appreciationMoyenne=0.0d;

		for(Avis vAvis : pActivite.getListAvis()) {
			switch(vAvis.getAppreciation()) {
			case "Excellent" :
				appreciation=5.0;
				break;
			case "Très bon" :
				appreciation=4.0;
				break;
			case "Bon" :
				appreciation=3.0;
				break;
			case "Moyen" :
				appreciation=2.0;
				break;
			case "Déconseillé" :
				appreciation=1.0;
				break;
			default :
				LOGGER.info("Erreur : Pas de traitement effectué dans la boucle switch");
			}
			sommeAppreciation+=appreciation;
		}
		if(nombreAvis!=0)
			appreciationMoyenne=sommeAppreciation/nombreAvis;
		else
			appreciationMoyenne=0.0;

		return appreciationMoyenne;
	}
}
