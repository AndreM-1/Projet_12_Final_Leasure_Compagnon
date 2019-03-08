package com.leasurecompagnon.appliweb.webapp.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Ville;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action relative à l'affichage de la page d'accueil.
 *  @author André Monnier
 *
 */
public class GestionAccueilAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6801468525150319094L;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres
	private List<Ville> listVille;	

	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAccueilAction.class);
	
	// ===================== Getters/Setters =====================
	public List<Ville> getListVille() {
		return listVille;
	}

	/**
	 * Méthode permettant de renvoyer une liste de villes qui seront affichées sur la page d'accueil.
	 * @return success /error
	 */
	public String doListVille() {
		LOGGER.info("Méthode doListVille()");
		String vResult;
		try {
			listVille=managerFactory.getVilleManager().getListVille(-1);
			LOGGER.info("Nom de la ville : "+listVille.get(0).getNomVille());
			LOGGER.info("Nom de la ville : "+listVille.get(10).getNomVille());
			vResult=ActionSupport.SUCCESS;
		} catch (GetListVilleFault_Exception e) {
			LOGGER.info(e.getMessage());
			vResult=ActionSupport.ERROR;
		}
		return vResult;
	}
}