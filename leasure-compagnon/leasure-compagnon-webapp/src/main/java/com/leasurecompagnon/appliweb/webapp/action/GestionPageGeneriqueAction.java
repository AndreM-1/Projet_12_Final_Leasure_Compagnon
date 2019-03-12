package com.leasurecompagnon.appliweb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant la gestion des pages génériques.
 * @author André Monnier
 */
public class GestionPageGeneriqueAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8715130011758354367L;
	
	// ===================== Méthodes ============================
	
	/**
	 * Méthode de la classe d'action exécutée par défaut.
	 * @return success
	 */
	public String execute() {
		return ActionSupport.SUCCESS;
	}
}