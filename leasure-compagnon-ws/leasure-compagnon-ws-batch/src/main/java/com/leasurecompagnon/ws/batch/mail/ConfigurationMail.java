package com.leasurecompagnon.ws.batch.mail;

import javax.inject.Named;


import org.springframework.beans.factory.annotation.Value;

@Named("configuration")
public class ConfigurationMail {

	@Value("${adresse.catalogueService}")
	private String adresseCatalogueService;

	@Value("${adresse.utilisateurService}")
	private String adresseUtilisateurService;
	
	@Value("${adresse.formulaireContactService}")
	private String adresseFormulaireContactService;

	@Value("${mail.informatif.titre}")
	private String titreInformatif;

	@Value("${mail.informatif.premier.message}")
	private String premierMessageInformatif;

	@Value("${mail.informatif.deuxieme.message}")
	private String deuxiemeMessageInformatif;

	@Value("${mail.confirmation.titre}")
	private String titreConfirmation;

	@Value("${mail.confirmation.premier.message}")
	private String premierMessageConfirmation;

	@Value("${mail.confirmation.deuxieme.message}")
	private String deuxiemeMessageConfirmation;

	@Value("${mail.refus.titre}")
	private String titreRefus;

	@Value("${mail.refus.premier.message}")
	private String premierMessageRefus;

	@Value("${mail.refus.deuxieme.message}")
	private String deuxiemeMessageRefus;

	@Value("${mail.conclusion}")
	private String conclusion;

	@Value("${mail.signature}")
	private String signature;

	@Value("${spring.mail.host}")
	private String serveurSmtpHost;

	@Value("${spring.mail.port}")
	private int serveurSmtpPort;

	@Value("${spring.mail.username}")
	private String serveurSmtpUsername;

	@Value("${spring.mail.password}")
	private String serveurSmtpPassword;

	@Value("${spring.mail.protocol}")
	private String serveurSmtpProtocol;

	@Value("${spring.mail.properties.mail.smtp.auth}")
	private String serveurSmtpAuth;

	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private String serveurSmtpTlsEnable;

	@Value("${spring.mail.properties.mail.smtp.starttls.required}")
	private String serveurSmtpTlsRequired;

	@Value("${spring.mail.properties.mail.smtp.connectiontimeout}")
	private String serveurSmtpConnectionTimeout;

	@Value("${spring.mail.properties.mail.smtp.timeout}")
	private String serveurSmtpTimeout;

	@Value("${spring.mail.properties.mail.smtp.writetimeout}")
	private String serveurSmtpWriteTimeout;

	@Value("${spring.mail.properties.mail.debug}")
	private String serveurSmtpDebug;

	@Value("${spring.mail.default-encoding}")
	private String serveurSmtpDefaultEncoding;
	
	//On a uniquement besoin des getters.
	public String getAdresseCatalogueService() {
		return adresseCatalogueService;
	}

	public String getAdresseUtilisateurService() {
		return adresseUtilisateurService;
	}

	public String getAdresseFormulaireContactService() {
		return adresseFormulaireContactService;
	}

	public String getTitreInformatif() {
		return titreInformatif;
	}

	public String getPremierMessageInformatif() {
		return premierMessageInformatif;
	}

	public String getDeuxiemeMessageInformatif() {
		return deuxiemeMessageInformatif;
	}

	public String getTitreConfirmation() {
		return titreConfirmation;
	}

	public String getPremierMessageConfirmation() {
		return premierMessageConfirmation;
	}

	public String getDeuxiemeMessageConfirmation() {
		return deuxiemeMessageConfirmation;
	}

	public String getTitreRefus() {
		return titreRefus;
	}

	public String getPremierMessageRefus() {
		return premierMessageRefus;
	}

	public String getDeuxiemeMessageRefus() {
		return deuxiemeMessageRefus;
	}

	public String getConclusion() {
		return conclusion;
	}

	public String getSignature() {
		return signature;
	}

	public String getServeurSmtpHost() {
		return serveurSmtpHost;
	}

	public int getServeurSmtpPort() {
		return serveurSmtpPort;
	}

	public String getServeurSmtpUsername() {
		return serveurSmtpUsername;
	}

	public String getServeurSmtpPassword() {
		return serveurSmtpPassword;
	}

	public String getServeurSmtpProtocol() {
		return serveurSmtpProtocol;
	}

	public String getServeurSmtpAuth() {
		return serveurSmtpAuth;
	}

	public String getServeurSmtpTlsEnable() {
		return serveurSmtpTlsEnable;
	}

	public String getServeurSmtpTlsRequired() {
		return serveurSmtpTlsRequired;
	}

	public String getServeurSmtpConnectionTimeout() {
		return serveurSmtpConnectionTimeout;
	}

	public String getServeurSmtpTimeout() {
		return serveurSmtpTimeout;
	}

	public String getServeurSmtpWriteTimeout() {
		return serveurSmtpWriteTimeout;
	}

	public String getServeurSmtpDebug() {
		return serveurSmtpDebug;
	}

	public String getServeurSmtpDefaultEncoding() {
		return serveurSmtpDefaultEncoding;
	}	
}