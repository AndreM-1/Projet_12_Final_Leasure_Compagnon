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
import com.leasurecompagnon.appliweb.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListTypeActiviteFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de visualiser l'ensemble des activités d'une ville.
 * @author André Monnier
 *
 */
public class GestionActivitesVilleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2287278890858158701L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres
	private List<Activite> listActivite;
	private List<ActiviteAppliWeb> listActiviteAppliWeb;
	private List<TypeActivite> listTypeActivite;
	private int villeId;
	private String nomVille;
	private String messageInformatif;

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionActivitesVilleAction.class);


	// ===================== Getters/Setters =====================
	public List<Activite> getListActivite() {
		return listActivite;
	}

	public List<ActiviteAppliWeb> getListActiviteAppliWeb() {
		return listActiviteAppliWeb;
	}

	public List<TypeActivite> getListTypeActivite() {
		return listTypeActivite;
	}

	public void setVilleId(int villeId) {
		this.villeId = villeId;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	public String getMessageInformatif() {
		return messageInformatif;
	}

	// ===================== Méthodes ============================
	
	/**
	 * Méthode permettant de renvoyer l'ensemble des activités d'une ville.
	 * @return input / success /error
	 */
	public String doListActivitesVille() {
		LOGGER.info("Méthode doListActivitesVille()");
		String vResult;

		try {
			//On récupère d'abord la liste de type d'activités.
			listTypeActivite=managerFactory.getTypeActiviteManager().getListTypeActivite();

			try {
				//Si ça marche on récupère ensuite la liste d'activités de la ville.
				listActivite=managerFactory.getActiviteManager().getListActiviteVille(villeId, "MEL");
				
				listActiviteAppliWeb=new ArrayList<>();
				
				for(TypeActivite vTypeActivite : listTypeActivite) {
					int nbActivite=0;

					//On parcourt cette liste d'activités
					for(Activite vActivite : listActivite) {		
						for(TypeActivite vActiviteTypeActivite : vActivite.getListTypeActivite()) {
							if(vActiviteTypeActivite.getTypeActivite().equals(vTypeActivite.getTypeActivite())) {	
								ActiviteAppliWeb vActiviteAppliWeb = new ActiviteAppliWeb();
								double vAppreciationMoyenneDouble=0.0d;
								//on récupère le bean Activite, le nom de la photo principale, le nombre d'avis et la moyenne des avis.
								vActiviteAppliWeb.setActivite(vActivite);
								vActiviteAppliWeb.setNomPhotoPrincipale(vActivite.getListPhotoActivite().get(0).getNomPhoto());	
								vActiviteAppliWeb.setNombreAvis(vActivite.getListAvis().size());
								vAppreciationMoyenneDouble=calculAppreciationMoyenneActivite(vActivite);
								LOGGER.info("Appréciation moyenne activité "+vActivite.getNomActivite()+" : "+vAppreciationMoyenneDouble);
								vActiviteAppliWeb.setAppreciationMoyenneDouble(vAppreciationMoyenneDouble);
								vActiviteAppliWeb.setTypeActiviteRattache(vTypeActivite.getTypeActivite());

								//On l'ajout à la liste de beans de type ActiviteAppliWeb
								listActiviteAppliWeb.add(vActiviteAppliWeb);
								nbActivite++;							
							}			
						}											
					}
					if(nbActivite==0) {
						ActiviteAppliWeb vActiviteAppliWeb = new ActiviteAppliWeb();
						vActiviteAppliWeb.setTypeActiviteRattache(vTypeActivite.getTypeActivite());
						vActiviteAppliWeb.setMessageInformatif("Pas d'activités disponibles pour ce type d'activité pour le moment.");
						listActiviteAppliWeb.add(vActiviteAppliWeb);
					}

				}
				LOGGER.info("Taille liste activite finale : "+listActiviteAppliWeb.size());
				vResult=ActionSupport.SUCCESS;
			} catch (GetListActiviteVilleFault_Exception e1) {
				LOGGER.info(e1.getMessage());
				messageInformatif="Pas d'activités disponibles pour ce type d'activité pour le moment.";
				vResult=ActionSupport.INPUT;
			}
		} catch (GetListTypeActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
			vResult=ActionSupport.ERROR;
		}	
		return vResult;
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
