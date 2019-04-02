package com.leasurecompagnon.ws.batch.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leasurecompagnon.ws.batch.generated.catalogueservice.GetListActiviteFault_Exception;
import com.leasurecompagnon.ws.batch.generated.utilisateurservice.GetListUtilisateurFault_Exception;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;

/**
 * Classe relative à l'envoi de mails informatifs au sujet des dernières activités mises en ligne.
 * @author André Monnier
 *
 */
@Component
public class EnvoiMailInformatif extends AbstractEnvoiMail {

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(EnvoiMailInformatif.class);

	//Paramètres
	List<Activite> listActivite;
	private List<Utilisateur> listUtilisateur;

	/**
	 * Constructeur avec paramètres.
	 * @param configuration : On récupère le bean configuration
	 */
	public EnvoiMailInformatif(ConfigurationMail configuration) {
		this.configuration=configuration;
	}


	/**
	 * Méthode permettant d'envoyer des mails informatifs aux utilisateurs au sujet des dernières activités mises en ligne suivant une fréquence déterminée.
	 */
	@Scheduled(cron = "${mail.informatif.cron}")
	public void sendMail() {
		//Définition du DateFormat pour l'affichage de la date d'envoie du mail.
		DateFormat dfEnvoiMailInformatif = new SimpleDateFormat("dd/MM/yyyy HH mm ss SSS");
		LOGGER.warn("--------------------------------------------");	
		LOGGER.warn("Entrée dans la méthode d'envoi des mails informatifs le "+dfEnvoiMailInformatif .format(new Date()));
		LOGGER.warn("Adresse Web Service Catalogue : "+configuration.getAdresseCatalogueService());
		LOGGER.warn("Mail - Titre : "+configuration.getTitreInformatif());
		LOGGER.warn("Mail - Premier message : "+configuration.getPremierMessageInformatif());
		LOGGER.warn("Mail - Deuxième message : "+configuration.getDeuxiemeMessageInformatif());
		LOGGER.warn("Mail - Conclusion : "+configuration.getConclusion());
		LOGGER.warn("Mail - Signature : "+configuration.getSignature());
		LOGGER.warn("--------------------------------------------");

		//Appel au web service.
		try {
			//On récupère les 5 dernières activités mises en ligne.
			listActivite = getCatalogueService().getListActivite(5, "MEL");

			try {
				//A partir de là, on récupère les utilisateurs qui ont activé l'option de réception de mail informatif.
				listUtilisateur=getUtilisateurService().getListUtilisateur("OPT_ACTIVE");
				
				//On va envoyer un mail informatif au sujet des dernières activités mises en ligne à chaque utilisateur.
				for(Utilisateur vUtilisateur:listUtilisateur) {
					LOGGER.warn("--------------------------------------------");
					LOGGER.warn("Nom : "+vUtilisateur.getNom());
					LOGGER.warn("Prénom : "+vUtilisateur.getPrenom());
					LOGGER.warn("Adresse Mail :"+vUtilisateur.getAdresseMail());

					//Instanciation du bean mail.
					Mail mail=new Mail();

					//Adresse mail du destinataire.
					mail.setTo(vUtilisateur.getAdresseMail());

					//Objet du mail.
					mail.setSubject(configuration.getTitreInformatif());

					//Construction du contenu du mail avec des balises HTML
					String contenuMail="<html><body>";
					contenuMail+="Bonjour "+vUtilisateur.getCivilite()+" "+vUtilisateur.getPrenom()+" "+vUtilisateur.getNom()+",";
					contenuMail+="<p>";
					contenuMail+=configuration.getPremierMessageInformatif();
					contenuMail+="</p>";

					//Définition du DateFormat pour l'affichage des dates dans le mail.
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

					for(Activite vActivite:listActivite) {					
						LOGGER.warn("Nom de l'activité : "+vActivite.getNomActivite());
						LOGGER.warn("Adresse : "+vActivite.getAdresse());
						LOGGER.warn("Code Postal : "+vActivite.getVille().getCodePostal());
						LOGGER.warn("Ville : "+vActivite.getVille().getNomVille());
						LOGGER.warn("Date de demande d'ajout : "+vActivite.getDateDemandeAjout());
						LOGGER.warn("Date de mise en ligne : "+vActivite.getDateMiseEnLigne());
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
						contenuMail+=df.format(vActivite.getDateMiseEnLigne().toGregorianCalendar().getTime());
						contenuMail+="</p>";	
					}	
					contenuMail+="<p>";
					contenuMail+=configuration.getDeuxiemeMessageInformatif();
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
			} catch (GetListUtilisateurFault_Exception e) {
				//Aucun utilisateur n'a la valeur d'option de réception de mail informatif demandé, à savoir activé.
				//Dans ce cas là, on n'envoie pas de mails.
				LOGGER.warn(e.getMessage());
			}
		} catch (GetListActiviteFault_Exception e) {
			//Dans ce cas là, aucune activité n'est mise en ligne.
			//Ce cas n'est pas censé se produire.
			LOGGER.warn(e.getMessage());
		}	
	}
}