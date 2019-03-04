package com.leasurecompagnon.ws.business.contract;

import com.leasurecompagnon.ws.business.contract.manager.ActiviteManager;
import com.leasurecompagnon.ws.business.contract.manager.AvisManager;
import com.leasurecompagnon.ws.business.contract.manager.DepartementManager;
import com.leasurecompagnon.ws.business.contract.manager.DureeManager;
import com.leasurecompagnon.ws.business.contract.manager.FormulaireContactManager;
import com.leasurecompagnon.ws.business.contract.manager.PaysManager;
import com.leasurecompagnon.ws.business.contract.manager.PhotoManager;
import com.leasurecompagnon.ws.business.contract.manager.RegionManager;
import com.leasurecompagnon.ws.business.contract.manager.SaisonManager;
import com.leasurecompagnon.ws.business.contract.manager.TypeActiviteManager;
import com.leasurecompagnon.ws.business.contract.manager.UtilisateurManager;
import com.leasurecompagnon.ws.business.contract.manager.VilleManager;

/**
 * Factory des Managers
 * @author André Monnier
 */
public interface ManagerFactory {

	VilleManager getVilleManager();

	PaysManager getPaysManager();

	RegionManager getRegionManager();

	DepartementManager getDepartementManager();

	DureeManager getDureeManager();

	SaisonManager getSaisonManager();

	TypeActiviteManager getTypeActiviteManager();

	UtilisateurManager getUtilisateurManager();

	ActiviteManager getActiviteManager();

	AvisManager getAvisManager();

	FormulaireContactManager getFormulaireContactManager();

	PhotoManager getPhotoManager();

}