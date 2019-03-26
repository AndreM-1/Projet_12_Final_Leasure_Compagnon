package com.leasurecompagnon.appliweb.webapp.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Activite;
import com.leasurecompagnon.appliweb.model.bean.catalogue.CoordonneeGPS;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Duree;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Photo;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Saison;
import com.leasurecompagnon.appliweb.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Ville;
import com.leasurecompagnon.appliweb.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.appliweb.model.exception.AjoutActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListDureeFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListSaisonFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListTypeActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer l'ajout d'activités.
 * @author André Monnier
 *
 */
public class GestionAjoutActiviteAction extends ActionSupport implements SessionAware,ServletRequestAware{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5679474706689060651L;
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private List<Ville> listVille;
	private List<TypeActivite> listTypeActivite;
	private List<String> listNomTypeActivite;
	private String nomTypesActivitesChoisis;
	private List<Duree> listDuree;
	private List<Saison> listSaison;
	private Activite activite;
	private boolean validationFormulaire=false;
	private List<String> provenancePhoto;
	private List<String> lienProvenancePhoto;
	private String latitude;
	private String longitude;
	
	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;	
		
	//Eléments liés  l'upload
	private List<File> fileUpload;
	private List<String> fileUploadContentType;
	private List<String> fileUploadFileName;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAjoutActiviteAction.class);
	
	
	// ===================== Getters/Setters =====================
	public List<Ville> getListVille() {
		return listVille;
	}

	public void setListVille(List<Ville> listVille) {
		this.listVille = listVille;
	}
	
	public List<TypeActivite> getListTypeActivite() {
		return listTypeActivite;
	}

	public void setListTypeActivite(List<TypeActivite> listTypeActivite) {
		this.listTypeActivite = listTypeActivite;
	}
	
	public List<String> getListNomTypeActivite() {
		return listNomTypeActivite;
	}

	public void setListNomTypeActivite(List<String> listNomTypeActivite) {
		this.listNomTypeActivite = listNomTypeActivite;
	}
	
	public String getNomTypesActivitesChoisis() {
		return nomTypesActivitesChoisis;
	}

	public void setNomTypesActivitesChoisis(String nomTypesActivitesChoisis) {
		this.nomTypesActivitesChoisis = nomTypesActivitesChoisis;
	}

	public List<Duree> getListDuree() {
		return listDuree;
	}

	public void setListDuree(List<Duree> listDuree) {
		this.listDuree = listDuree;
	}

	public List<Saison> getListSaison() {
		return listSaison;
	}

	public void setListSaison(List<Saison> listSaison) {
		this.listSaison = listSaison;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	
	public boolean isValidationFormulaire() {
		return validationFormulaire;
	}

	public void setValidationFormulaire(boolean validationFormulaire) {
		this.validationFormulaire = validationFormulaire;
	}
	
	public List<String> getProvenancePhoto() {
		return provenancePhoto;
	}

	public void setProvenancePhoto(List<String> provenancePhoto) {
		this.provenancePhoto = provenancePhoto;
	}

	public List<String> getLienProvenancePhoto() {
		return lienProvenancePhoto;
	}

	public void setLienProvenancePhoto(List<String> lienProvenancePhoto) {
		this.lienProvenancePhoto = lienProvenancePhoto;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session=pSession;		
	}
	
	@Override
	public void setServletRequest(HttpServletRequest pRequest) {
		this.servletRequest=pRequest;	
	}
	
	public List<File> getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(List<File> fileUpload) {
		this.fileUpload = fileUpload;
	}

	public List<String> getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(List<String> fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public List<String> getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(List<String> fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	
	
	
	// ===================== Méthodes ============================
	
	/**
	 * Méthode permettant à l'utilisateur d'ajouter une activité.
	 * @return input / success / error
	 */
	public String doAjoutActivite() {
		LOGGER.info("Méthode doAjoutActivite()");
		String vResult;
		
		//On récupère les listes des villes, types d'activités, durées et saisons dans tous les cas, que ce soit
		//la première entrée dans le formulaire ou après avoir validé le formulaire.
		try {
			listVille=managerFactory.getVilleManager().getListVille(-1);
		} catch (GetListVilleFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
		}
		
		try {
			listTypeActivite=managerFactory.getTypeActiviteManager().getListTypeActivite();
			
			listNomTypeActivite = new ArrayList<>();
			for(TypeActivite vTypeActivite : listTypeActivite) {
				listNomTypeActivite.add(vTypeActivite.getTypeActivite());
			}	

		} catch (GetListTypeActiviteFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
		}
		
		try {
			listDuree=managerFactory.getDureeManager().getListDuree();
		} catch (GetListDureeFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
		}
		
		try {
			listSaison = managerFactory.getSaisonManager().getListSaison();
		} catch (GetListSaisonFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
		}
		
		//S'il n'y a pas d'erreurs, on continue.
		if(!this.hasErrors()) {	
			//Première entrée dans le formulaire.
			if(!validationFormulaire) {
				validationFormulaire=true;
				vResult=ActionSupport.INPUT;
			}
			//Validation du formulaire
			else {	
				//Si au moins un type d'activités est sélectionné, on continue.
				if(nomTypesActivitesChoisis!=null) {
					//Récupération de la variable de session relative à l'utilisateur.
					Utilisateur vUtilisateurSession= (Utilisateur)this.session.get("user");
					activite.setUtilisateur(vUtilisateurSession);
					
					//On vérifie que l'ensemble des informations récupérées sont correctes.
					LOGGER.warn("Utilisateur id :"+activite.getUtilisateur().getId());
					LOGGER.warn("Ville id  et nom: "+activite.getVille().getId() +" - " +activite.getVille().getNomVille());
					LOGGER.warn("Adresse : "+activite.getAdresse());
					LOGGER.warn("Latitude en string: "+latitude);
					LOGGER.warn("Longitude en string: "+longitude);
					CoordonneeGPS coordonneeGPS=new CoordonneeGPS();
					coordonneeGPS.setLatitude(Double.valueOf(latitude));
					coordonneeGPS.setLongitude(Double.valueOf(longitude));					
					activite.setCoordonnee(coordonneeGPS);
					LOGGER.warn("Latitude en double: "+activite.getCoordonnee().getLatitude());
					LOGGER.warn("Longitude en double: "+activite.getCoordonnee().getLongitude());
					
					LOGGER.warn("Nom de l'activité : "+activite.getNomActivite());
					LOGGER.warn("Description : "+activite.getDescription());
					LOGGER.warn("Type d'activités choisis : "+nomTypesActivitesChoisis);
					LOGGER.warn("Lien Horaire Ouverture : "+activite.getLienHoraireOuverture());
					LOGGER.warn("Durée conseillée id et nom : "+activite.getDuree().getId() +" - "+activite.getDuree().getDureeConseillee());
					LOGGER.warn("Saison conseillée id et nom : "+activite.getSaison().getId() +" - "+activite.getSaison().getNomSaison());
					
					//On va convertir les types d'activités choisis dans le format adéquate.
					String [] tabNomTypesActivites =nomTypesActivitesChoisis.split(",");
					for(String vNomActivite :tabNomTypesActivites) {
						for(TypeActivite vTypeActivite:listTypeActivite) {
							if(vNomActivite.trim().equals(vTypeActivite.getTypeActivite())) {
								activite.getListTypeActivite().add(vTypeActivite);
								break;
							}
						}
					}
					
					for(TypeActivite vTypeActivite : activite.getListTypeActivite()) {
						LOGGER.warn("Type Activite id et nom : "+vTypeActivite.getId()+" - "+vTypeActivite.getTypeActivite());
					}
					
					
					boolean verifUploadPhoto=true;
				
					for (int i=0;i<fileUpload.size();i++) {
						LOGGER.warn("Src (Dossier Temp) File name: " + fileUpload.get(i));
						LOGGER.warn("Nom initial du fichier : "+fileUploadFileName.get(i));
						LOGGER.warn("Provenance Photo Principale : "+provenancePhoto.get(i));
						LOGGER.warn("Lien provenance Photo Principale : "+ lienProvenancePhoto.get(i));
						
						String[] tabString=fileUploadFileName.get(i).split("\\.");
						
						//On vérifie que l'extension de chaque fichier est correcte, à savoir :
						//JPEG : jpg, jpeg, jpe
						//On vérifie aussi que la taille de chaque fichier ne dépasse pas 100Ko.
						String extensionFichier=tabString[tabString.length-1];
						double tailleFichierKiloOctets=fileUpload.get(i).length()/1024;
						LOGGER.warn("Format du fichier : "+extensionFichier);
						LOGGER.warn("Taille du fichier en kilo octets : "+tailleFichierKiloOctets);
						
						if((!extensionFichier.equals("jpg")&&!extensionFichier.equals("jpeg")&&!extensionFichier.equals("jpe"))
								||tailleFichierKiloOctets>100.0) {
							verifUploadPhoto=false;	
							break;
						}						
					}
					
					//Si tous les fichiers uploadés ont le bon format (JPEG) et la bonne taille, on continue.
					if(verifUploadPhoto) {
						boolean uploadPhotoServeur=true;
						Date dateAjoutActivite= new Date();
						DateFormat dfAjoutActivite = new SimpleDateFormat("yyyy-MM-dd");
						String strDateAjoutActivite = dfAjoutActivite.format(dateAjoutActivite);
						String nomVilleRetouche=activite.getVille().getNomVille().toLowerCase().replaceAll("à","a").replaceAll("ë","e").replaceAll("é", "e").replaceAll("è", "e");
						String nomActiviteRetouche=activite.getNomActivite().trim().toLowerCase().replaceAll(" ", "-").replaceAll("à","a").replaceAll("â", "a").replaceAll("ä", "a")
								.replaceAll("ë","e").replaceAll("é", "e").replaceAll("è", "e").replaceAll("'", "-");
						//On définit le répertoire où sera uploadé le fichier.
						String destPath=servletRequest.getServletContext().getRealPath("/jsp/assets/images/"+nomVilleRetouche+"/");
						LOGGER.warn("Chemin absolu répertoire final : "+destPath);

						for (int i=0;i<fileUpload.size();i++) {
							Photo photo = new Photo();
							String[] tabString=fileUploadFileName.get(i).split("\\.");
							String extensionFichier=tabString[tabString.length-1];
							//On change le nom du fichier à uploader, en reprenant l'extension du fichier initial.
							int ind=i+1;
							String fileUploadFileNameRetouche=nomVilleRetouche+"_"+nomActiviteRetouche+"-"+ind+"_"+
							strDateAjoutActivite+"."+extensionFichier;
							LOGGER.warn("fileUploadFileName final : "+fileUploadFileNameRetouche);
							photo.setNomPhoto("jsp/assets/images/"+nomVilleRetouche+"/"+fileUploadFileNameRetouche);
							if(provenancePhoto.get(i).equals("Autre")){
								photo.setProvenancePhoto(lienProvenancePhoto.get(i));
							}else {
								photo.setProvenancePhoto(provenancePhoto.get(i));
							}
							if(i==0) {
								photo.setTypePhoto("Activité photo principale");
							}else {
								photo.setTypePhoto("Activité photo secondaire");
							}
							
							//On construit notre liste de photo.	
							activite.getListPhotoActivite().add(photo);
							LOGGER.warn("Nom photo : "+activite.getListPhotoActivite().get(i).getNomPhoto());
							LOGGER.warn("Provenance photo : "+activite.getListPhotoActivite().get(i).getProvenancePhoto());
							LOGGER.warn("Type photo : "+activite.getListPhotoActivite().get(i).getTypePhoto());
							
							File destFile  = new File(destPath, fileUploadFileNameRetouche);
							
							//On copie chaque fichier dans le répertoire précédent.
							try {
								FileUtils.copyFile(fileUpload.get(i), destFile);
							} catch (IOException e) {
								LOGGER.info(e.getMessage());
								uploadPhotoServeur=false;
							}
						}
						//Si l'upload de toutes les photos a fonctionné, on continue.
						if(uploadPhotoServeur) {							
							//On peut finalement ajouter l'activité en base de données.						
							try {
								managerFactory.getActiviteManager().ajoutActivite(activite);
								vResult=ActionSupport.SUCCESS;
							} catch (AjoutActiviteFault_Exception e) {
								//Si deux utilisateurs postent la même activité dans la même ville le même jour, ce qui implique le même nom de photo, on aura une erreur.
								LOGGER.warn(e.getMessage());
								this.addActionError(e.getMessage());
								vResult=ActionSupport.ERROR;
							}
						}
						//Si l'upload d'une des photos sur le serveur a échoué, on aura une erreur technique.
						else {
							this.addActionError("Echec lors de l'upload de l'un des fichiers sur le serveur");
							vResult=ActionSupport.ERROR;
						}											
					}
					//Sinon, on reste sur la page du formulaire avec un message d'erreur.
					else
					{
						this.addActionError("Le format ou la taille du fichier uploadé n'est pas correct. Seuls les fichiers de moins de 100Ko de type JPEG sont autorisés.");
						vResult= ActionSupport.INPUT;
					}		
				}
				//Si aucun type d'activités n'est renseigné, on reste sur la page du formulaire avec un message d'erreur.
				else {
					this.addActionError("Veuillez sélectionner au moins un type d'activités");
					vResult= ActionSupport.INPUT;
				}
			}		
		} 
		
		//S'il y a une erreur pour récupérer les diverses listes, on sera redirigé vers la page d'erreur.
		else {
			vResult=ActionSupport.ERROR;
		}
		return vResult;			
	}
}