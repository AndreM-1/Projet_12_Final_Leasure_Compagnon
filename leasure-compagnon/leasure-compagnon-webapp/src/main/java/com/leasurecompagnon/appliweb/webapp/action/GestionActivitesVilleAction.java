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
import com.leasurecompagnon.appliweb.model.exception.GetActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleTAFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListTypeActiviteFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de visualiser l'ensemble des activités d'une ville, un type d'actvités
 * d'une ville, ainsi que le détail d'une activité.
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
	private int typeActiviteId;
	private String typeActivite;
	private int activiteId;
	private Activite activite;
	private ActiviteAppliWeb activiteAppliWeb;
	private String latitude;
	private String longitude;

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

	public int getVilleId() {
		return villeId;
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
	
	public void setTypeActiviteId(int typeActiviteId) {
		this.typeActiviteId = typeActiviteId;
	}
	
	public String getTypeActivite() {
		return typeActivite;
	}

	public void setTypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}
	
	public void setActiviteId(int activiteId) {
		this.activiteId = activiteId;
	}
	
	public Activite getActivite() {
		return activite;
	}
	
	public ActiviteAppliWeb getActiviteAppliWeb() {
		return activiteAppliWeb;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
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

					//On parcourt cette liste d'activités.
					for(Activite vActivite : listActivite) {		
						for(TypeActivite vActiviteTypeActivite : vActivite.getListTypeActivite()) {
							if(vActiviteTypeActivite.getTypeActivite().equals(vTypeActivite.getTypeActivite())) {	
								ActiviteAppliWeb vActiviteAppliWeb = new ActiviteAppliWeb();
								double vAppreciationMoyenneDouble=0.0d;
								//on récupère le bean Activite, le nom de la photo principale, le nombre d'avis, la moyenne des avis et le type d'activité rattaché.
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
	 * Méthode permettant de renvoyer les activités liées à un type d'activité choisi pour une ville donnée.
	 * @return input / success
	 */
	public String doListTypeActivitesVille() {
		LOGGER.info("Méthode doListTypeActivitesVille()");
		String vResult;
		
		try {
			//On récupère la liste d'activités d'une ville liée à un type d'activité.
			listActivite=managerFactory.getActiviteManager().getListActiviteVilleTA(villeId, typeActiviteId, "MEL");
			
			listActiviteAppliWeb=new ArrayList<>();
			
			//On parcourt cette liste d'activités.
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
			
			vResult=ActionSupport.SUCCESS;
		} catch (GetListActiviteVilleTAFault_Exception e) {
			LOGGER.info("Pas d'activités disponibles pour ce type d'activité pour le moment.");
			this.addActionMessage("Pas d'activités disponibles pour ce type d'activité pour le moment.");
			vResult=ActionSupport.INPUT;
		}
		return vResult;
	}
	
	/**
	 * Méthode permettant de renvoyer l'activité choisie.
	 * @return success / error
	 */
	public String doDetailActivite() {
		LOGGER.info("Méthode doDetailActivite()");
		String vResult;
		
		try {
			//On récupère l'activité choisie.
			activite = managerFactory.getActiviteManager().getActivite(activiteId);
			
			if(activite.getStatutActivite().getStatutActiviteAvis().equals("Mise en ligne")) {
				activiteAppliWeb = new ActiviteAppliWeb();
				
				//on récupère le bean Activite, le nombre d'avis et la moyenne des avis.
				activiteAppliWeb.setActivite(activite);
				activiteAppliWeb.setNombreAvis(activite.getListAvis().size());
				double vAppreciationMoyenneDouble=0.0d;
				vAppreciationMoyenneDouble=calculAppreciationMoyenneActivite(activite);
				activiteAppliWeb.setAppreciationMoyenneDouble(vAppreciationMoyenneDouble);		
				latitude = String.valueOf(activiteAppliWeb.getActivite().getCoordonnee().getLatitude());
				longitude = String.valueOf(activiteAppliWeb.getActivite().getCoordonnee().getLongitude());
				vResult=ActionSupport.SUCCESS;	
			}else {
				this.addActionError("Aucune activité trouvée.");
				vResult=ActionSupport.ERROR;
			}

		} catch (GetActiviteFault_Exception e) {
			LOGGER.info("Aucune activité trouvée. Veuillez nous excuser pour ce problème technique.");
			this.addActionError("Aucune activité trouvée. Veuillez nous excuser pour ce problème technique.");
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
