package com.leasurecompagnon.appliweb.webapp.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.ManagerFactory;
import com.leasurecompagnon.appliweb.model.exception.GetListNomActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListNomVilleFault_Exception;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe d'action permettant de gérer les appels asynchrones.
 * @author André Monnier
 *
 */
public class GestionAppelAjaxAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5797053781961651979L;
	
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Paramètres
	private List<String> listVilleActivite;
	
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionAppelAjaxAction.class);


	// ===================== Getters/Setters =====================
	public List<String> getListVilleActivite() {
		return listVilleActivite;
	}
	
	
	// ===================== Méthodes ============================
	
	/**
	 * Méthode permettant de renvoyer l'ensemble des noms de villes et d'activités.
	 * @return success / error
	 */
	public String doAjaxGetListVilleActivite() {
		LOGGER.info("Méthode doAjaxGetListVilleActivite()");
		String vResult;
		try {
			listVilleActivite=managerFactory.getVilleManager().getListNomVille();
			try {
				listVilleActivite.addAll(managerFactory.getActiviteManager().getListNomActivite());
				vResult=ActionSupport.SUCCESS;
			} catch (GetListNomActiviteFault_Exception e) {
				LOGGER.info(e.getMessage());
				this.addActionError(e.getMessage());
				vResult=ActionSupport.ERROR;
			}
			
		} catch (GetListNomVilleFault_Exception e) {
			LOGGER.info(e.getMessage());
			this.addActionError(e.getMessage());
			vResult=ActionSupport.ERROR;
		}
		return vResult;
	}
}
