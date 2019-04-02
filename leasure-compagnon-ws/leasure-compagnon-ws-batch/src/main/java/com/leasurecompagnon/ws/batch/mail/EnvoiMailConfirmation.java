package com.leasurecompagnon.ws.batch.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leasurecompagnon.ws.batch.generated.catalogueservice.GetListActiviteFault_Exception;
import com.leasurecompagnon.ws.batch.generated.catalogueservice.UpdateStatutActiviteFault_Exception;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;

/**
 * Classe relative à l'envoi de mails de confirmation pour indiquer aux utilisateurs que
 * le ou les activités postées ont bien été mises en ligne et mettre à jour la base de 
 * données en conséquence.
 * @author André Monnier
 *
 */
@Component
public class EnvoiMailConfirmation extends AbstractEnvoiMail{
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(EnvoiMailConfirmation.class);
	
	//Paramètres
	List<Activite> listActivite;
	private List<Utilisateur> listUtilisateur;
	
	/**
	 * Constructeur avec paramètres.
	 * @param configuration : On récupère le bean configuration
	 */
	public EnvoiMailConfirmation(ConfigurationMail configuration) {
		this.configuration=configuration;
	}
	
	/**
	 * Méthode permettant d'envoyer des mails de confirmation aux utilisateurs suivant une fréquence déterminée
	 * pour leur indiquer que le ou les activités postées ont bien été mises en ligne et mettre à jour la base
	 * de données en conséquence.
	 */
	@Scheduled(cron = "${mail.confirmation.cron}")
	public void sendMail() {
		
		try {
			//On récupère dans un premier temps toutes les activités qui ont un statut du type Validé ou Refusé.
			listActivite = getCatalogueService().getListActivite(-1, "VR");
			
			LOGGER.warn("Taille de la liste d'activités avec un statut du type validé/refusé : "+listActivite.size());
			
			//On sélectionne uniquement les activités qui ont un statut du type Validé.		
			for(int i=0;i<listActivite.size();i++) {
				if(!listActivite.get(i).getStatutActivite().getStatutActiviteAvis().equals("Validé")) {
					listActivite.remove(i);
				}
			}
			
			LOGGER.warn("Taille de la liste d'activités avec un statut du type validé : "+listActivite.size());
			
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
			
			//On va envoyer un mail de confirmation aux utilisateurs concernés.
			for (Utilisateur vUtilisateur : listUtilisateur) {
				//Instanciation du bean mail.
				Mail mail=new Mail();

				//Adresse mail du destinataire.
				mail.setTo(vUtilisateur.getAdresseMail());

				//Objet du mail.
				mail.setSubject(configuration.getTitreConfirmation());
				
				//Construction du contenu du mail avec des balises HTML
				String contenuMail="<html><body>";
				contenuMail+="Bonjour "+vUtilisateur.getCivilite()+" "+vUtilisateur.getPrenom()+" "+vUtilisateur.getNom()+",";
				contenuMail+="<p>";
				contenuMail+=configuration.getPremierMessageConfirmation();
				contenuMail+="</p>";

				//Définition du DateFormat pour l'affichage des dates dans le mail.
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
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
						contenuMail+="<br/>";
						contenuMail+="Date de mise en ligne : ";
						contenuMail+=df.format(new Date());
						contenuMail+="</p>";							
					}					
				}
				contenuMail+="<p>";
				contenuMail+=configuration.getDeuxiemeMessageConfirmation();
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
			//Le statut de l'activité passera de "Validé" à "Mise en ligne".
			for(Activite vActivite : listActivite) {
				try {
					getCatalogueService().updateStatutActivite(vActivite.getId(), 4, "DATE_MEL");
				} catch (UpdateStatutActiviteFault_Exception e) {
					//Dans ce cas là, l'update du statut de l'activité a échoué.
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