package com.leasurecompagnon.ws.batch.mail;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leasurecompagnon.ws.batch.generated.catalogueservice.DeleteActiviteFault_Exception;
import com.leasurecompagnon.ws.batch.generated.catalogueservice.GetListActiviteFault_Exception;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;

/**
 * Classe relative à l'envoi de mails de refus pour indiquer aux utilisateurs que
 * le ou les activités postées n'ont pas été mises en ligne et mettre à jour la base de 
 * données en conséquence.
 * @author André Monnier
 *
 */
@Component
public class EnvoiMailRefus extends AbstractEnvoiMail{
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(EnvoiMailRefus.class);
	
	//Paramètres
	List<Activite> listActivite;
	private List<Utilisateur> listUtilisateur;
	
	/**
	 * Constructeur avec paramètres.
	 * @param configuration : On récupère le bean configuration
	 */
	public EnvoiMailRefus(ConfigurationMail configuration) {
		this.configuration=configuration;
	}
	
	/**
	 * Méthode permettant d'envoyer des mails de refus aux utilisateurs suivant une fréquence déterminée
	 * pour leur indiquer que le ou les activités postées n'ont pas été mises en ligne et mettre à jour la base
	 * de données en conséquence.
	 */
	@Scheduled(cron = "${mail.refus.cron}")
	public void sendMail() {
		
		try {
			//On récupère dans un premier temps toutes les activités qui ont un statut du type Validé ou Refusé.
			listActivite = getCatalogueService().getListActivite(-1, "VR");
			
			LOGGER.warn("Taille de la liste d'activités avec un statut du type validé/refusé : "+listActivite.size());
			
			//On sélectionne uniquement les activités qui ont un statut du type Refusé.		
			for(int i=0;i<listActivite.size();i++) {
				if(!listActivite.get(i).getStatutActivite().getStatutActiviteAvis().equals("Refusé")) {
					listActivite.remove(i);
				}
			}
			
			LOGGER.warn("Taille de la liste d'activités avec un statut du type refusé : "+listActivite.size());
			
			//A partir de là, on récupère les utilisateurs concernés.
			listUtilisateur=new ArrayList<>();
			int utilisateurId=-1;
			for(Activite vActivite:listActivite) {
				if(vActivite.getUtilisateur().getId()!=utilisateurId) {
					listUtilisateur.add(vActivite.getUtilisateur());
					utilisateurId=vActivite.getUtilisateur().getId();
				}
			}

			//Attention, la liste d'activités n'étant pas triée par utilisateur, on est obligé de faire cette seconde manipulation
			//pour enlever les doublons d'utilisateur.
			int tailleListeUtilisateur=listUtilisateur.size();
			for(int i=0;i<tailleListeUtilisateur;i++) {
				int vUtilisateurId=listUtilisateur.get(i).getId();
				for(int j=i+1;j<tailleListeUtilisateur;j++) {
					if(listUtilisateur.get(j).getId()==vUtilisateurId) {
						listUtilisateur.remove(j);
						tailleListeUtilisateur--;
					}
				}
			}			
			
			LOGGER.warn("Taille liste utilisateur : "+tailleListeUtilisateur);
			
			//On va envoyer un mail de refus aux utilisateurs concernés.
			for (Utilisateur vUtilisateur : listUtilisateur) {
				//Instanciation du bean mail.
				Mail mail=new Mail();

				//Adresse mail du destinataire.
				mail.setTo(vUtilisateur.getAdresseMail());

				//Objet du mail.
				mail.setSubject(configuration.getTitreRefus());
				
				//Construction du contenu du mail avec des balises HTML
				String contenuMail="<html><body>";
				contenuMail+="Bonjour "+vUtilisateur.getCivilite()+" "+vUtilisateur.getPrenom()+" "+vUtilisateur.getNom()+",";
				contenuMail+="<p>";
				contenuMail+=configuration.getPremierMessageRefus();
				contenuMail+="</p>";
			
				for(Activite vActivite:listActivite) {
					if(vActivite.getUtilisateur().getId()==vUtilisateur.getId()) {
						contenuMail+="<p>";
						contenuMail+="Nom de l'activité : ";
						contenuMail+=vActivite.getNomActivite()+" ";
						contenuMail+="<br/>";
						if(vActivite.getAdresse()!=null) {
							contenuMail+="Adresse : ";
							contenuMail+=vActivite.getAdresse()+" ";
							contenuMail+="<br/>";
						}
						contenuMail+="Code Postal : ";
						contenuMail+=vActivite.getVille().getCodePostal()+" ";
						contenuMail+="<br/>";
						contenuMail+="Ville : ";
						contenuMail+=vActivite.getVille().getNomVille()+" ";
						contenuMail+="</p>";							
					}					
				}
				contenuMail+="<p>";
				contenuMail+=configuration.getDeuxiemeMessageRefus();
				contenuMail+="</p>";
				contenuMail+="<p>";
				contenuMail+=configuration.getConclusion();
				contenuMail+="</p>";
				contenuMail+="<p>";
				contenuMail+=configuration.getSignature();
				contenuMail+="</p>";
				contenuMail+="</body></html>";
				mail.setBody(contenuMail);
				this.sendMimeMessage(mail);				
			}
			
			//Finalement, après avoir envoyé tous les mails, on met à jour la base de données.
			//On va supprimer de la base de données toutes les activités qui ont un statut "Refusé".
			for(Activite vActivite : listActivite) {	
				try {
					getCatalogueService().deleteActivite(vActivite.getId());
				} catch (DeleteActiviteFault_Exception e) {
					//Dans ce cas là, la suppression de l'activité en base de données a échoué.
					LOGGER.warn(e.getMessage());
				}
			}				
		} catch (GetListActiviteFault_Exception e) {
			//Aucune activité avec le statut Validé ou Refusé.
			//Pas d'envoi de mails dans ce cas là.
			LOGGER.warn(e.getMessage());
		}
	}
}