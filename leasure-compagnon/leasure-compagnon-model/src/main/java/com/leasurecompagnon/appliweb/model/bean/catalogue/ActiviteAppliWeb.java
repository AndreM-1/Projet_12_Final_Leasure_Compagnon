package com.leasurecompagnon.appliweb.model.bean.catalogue;

/**
 * Classe du modèle lié au bean ActiviteAppliWeb
 * @author André Monnier
 *
 */
public class ActiviteAppliWeb {

	// ==================== Attributs ====================
	protected Activite activite;
	protected String nomPhotoPrincipale;
	protected double appreciationMoyenneDouble;
	protected int nombreAvis;
	protected String typeActiviteRattache;
	protected String messageInformatif;
	
	// ==================== Constructeurs ====================
	/**
	 * Constructeur par défaut.
	 */
	public ActiviteAppliWeb() {
		
	}

	// ==================== Getters/Setters ====================
	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	
	public String getNomPhotoPrincipale() {
		return nomPhotoPrincipale;
	}

	public void setNomPhotoPrincipale(String nomPhotoPrincipale) {
		this.nomPhotoPrincipale = nomPhotoPrincipale;
	}

	public double getAppreciationMoyenneDouble() {
		return appreciationMoyenneDouble;
	}

	public void setAppreciationMoyenneDouble(double appreciationMoyenneDouble) {
		this.appreciationMoyenneDouble = appreciationMoyenneDouble;
	}

	public int getNombreAvis() {
		return nombreAvis;
	}

	public void setNombreAvis(int nombreAvis) {
		this.nombreAvis = nombreAvis;
	}

	public String getTypeActiviteRattache() {
		return typeActiviteRattache;
	}

	public void setTypeActiviteRattache(String typeActiviteRattache) {
		this.typeActiviteRattache = typeActiviteRattache;
	}

	public String getMessageInformatif() {
		return messageInformatif;
	}

	public void setMessageInformatif(String messageInformatif) {
		this.messageInformatif = messageInformatif;
	}		
}