package com.leasurecompagnon.ws.batch.mail;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.leasurecompagnon.ws.batch.generated.catalogueservice.CatalogueService;



public abstract class AbstractEnvoiMail {

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(AbstractEnvoiMail.class);
	
	protected ConfigurationMail configuration;
	
	private JavaMailSenderImpl eMailSenderImpl=new JavaMailSenderImpl();
	
	private CatalogueService catalogueService;
	
	/**
	 * Méthode permettant de récupérer un objet de type {@link CatalogueService}
	 * @return Un objet de type {@link CatalogueService}
	 */
	protected CatalogueService getCatalogueService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		LOGGER.warn("Adresse Web service -  CatalogueService : "+configuration.getAdresseCatalogueService());
        factory.setAddress(configuration.getAdresseCatalogueService());
        factory.setServiceClass(CatalogueService.class);
        catalogueService=(CatalogueService)factory.create();
		return catalogueService;
	}
	
	
	/**
	 * Multipurpose Internet Mail Extensions (MIME) ou Extensions multifonctions du courrier Internet est un standard internet qui étend le format de données
	 * des courriels pour supporter des textes en différents codage de caractères autres que l'ASCII, des contenus non textuels, des contenus multiples, et des 
	 * informations d'en-tête en d'autres codages que l'ASCII. Les courriels étant généralement envoyés via le protocole SMTP au format MIME, ces courriels sont 
	 * souvent appelés courriels SMTP/MIME. Avec l'apparition du multimédia et l'utilisation croissante des applications bureautiques, le besoin s'est fait sentir 
	 * d'échanger, en plus des fichiers textes, des fichiers binaires (format des applications bureautiques, images, sons, fichiers compressés). Cette méthode
	 * permet donc d'envoyer ce type de message. 
	 * @param mail : Un bean de type {@link Mail}
	 */
	protected void sendMimeMessage(Mail mail) {
		LOGGER.warn("Entrée dans la méthode sendMimeMessage");
		LOGGER.warn("Serveur SMTP Gmail - Host : "+configuration.getServeurSmtpHost());
		LOGGER.warn("Serveur SMTP Gmail - Port : "+configuration.getServeurSmtpPort());
		LOGGER.warn("Serveur SMTP Gmail - UserName : "+configuration.getServeurSmtpUsername());
		LOGGER.warn("Serveur SMTP Gmail - Password : "+configuration.getServeurSmtpPassword());
		LOGGER.warn("Serveur SMTP Gmail - Protocol Transport : "+configuration.getServeurSmtpProtocol());
		LOGGER.warn("Serveur SMTP Gmail - Auth : "+configuration.getServeurSmtpAuth());
		LOGGER.warn("Serveur SMTP Gmail - TlsEnable : "+configuration.getServeurSmtpTlsEnable());
		LOGGER.warn("Serveur SMTP Gmail - TlsRequired : "+configuration.getServeurSmtpTlsRequired());
		LOGGER.warn("Serveur SMTP Gmail - Connection Timeout : "+configuration.getServeurSmtpConnectionTimeout());
		LOGGER.warn("Serveur SMTP Gmail - Timeout : "+configuration.getServeurSmtpTimeout());
		LOGGER.warn("Serveur SMTP Gmail - Write Timeout : "+configuration.getServeurSmtpWriteTimeout());
		LOGGER.warn("Serveur SMTP Gmail - Debug : "+configuration.getServeurSmtpDebug());
		LOGGER.warn("Serveur SMTP Gmail - Default Encoding : "+configuration.getServeurSmtpDefaultEncoding());
		LOGGER.warn("--------------------------------------------");	

		eMailSenderImpl.setHost(configuration.getServeurSmtpHost());
		eMailSenderImpl.setPort(configuration.getServeurSmtpPort());
		eMailSenderImpl.setUsername(configuration.getServeurSmtpUsername());
		eMailSenderImpl.setPassword(configuration.getServeurSmtpPassword());
		eMailSenderImpl.setProtocol(configuration.getServeurSmtpProtocol());
		eMailSenderImpl.setDefaultEncoding(configuration.getServeurSmtpDefaultEncoding());

		Properties props = eMailSenderImpl.getJavaMailProperties();
		props.put("mail.smtp.auth", configuration.getServeurSmtpAuth());
		props.put("mail.smtp.starttls.enable", configuration.getServeurSmtpTlsEnable());
		props.put("mail.smtp.starttls.required", configuration.getServeurSmtpTlsRequired());
		props.put("mail.smtp.connectiontimeout", configuration.getServeurSmtpConnectionTimeout());
		props.put("mail.smtp.timeout", configuration.getServeurSmtpTimeout());
		props.put("mail.smtp.writetimeout", configuration.getServeurSmtpWriteTimeout());
		props.put("mail.debug", configuration.getServeurSmtpDebug());

		LOGGER.warn("Vérification des propriétés de l'eMailSender.");
		LOGGER.warn("mail.smtp.auth :"+props.getProperty("mail.smtp.auth"));
		LOGGER.warn("mail.smtp.starttls.enable :"+props.getProperty("mail.smtp.starttls.enable"));
		LOGGER.warn("mail.smtp.starttls.required :"+props.getProperty("mail.smtp.starttls.required"));
		LOGGER.warn("mail.smtp.connectiontimeout :"+props.getProperty("mail.smtp.connectiontimeout"));
		LOGGER.warn("mail.smtp.timeout :"+props.getProperty("mail.smtp.timeout"));
		LOGGER.warn("mail.smtp.writetimeout :"+props.getProperty("mail.smtp.writetimeout"));
		LOGGER.warn("mail.debug :"+props.getProperty("mail.debug"));
		LOGGER.warn("Host : "+eMailSenderImpl.getHost());
		LOGGER.warn("Port : "+eMailSenderImpl.getPort());
		LOGGER.warn("Username : "+eMailSenderImpl.getUsername());
		LOGGER.warn("Password : "+eMailSenderImpl.getPassword());
		LOGGER.warn("Protocol : "+eMailSenderImpl.getProtocol());
		LOGGER.warn("Default Encoding : "+eMailSenderImpl.getDefaultEncoding());

		MimeMessage mimeMessage = eMailSenderImpl.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {
			mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setTo(mail.getTo());
			mimeMessageHelper.setSubject(mail.getSubject());
			mimeMessageHelper.setText(mail.getBody(),true);
			eMailSenderImpl.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
