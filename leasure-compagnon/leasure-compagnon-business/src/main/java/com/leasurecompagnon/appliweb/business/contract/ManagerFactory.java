package com.leasurecompagnon.appliweb.business.contract;

import com.leasurecompagnon.appliweb.business.contract.manager.ActiviteManager;
import com.leasurecompagnon.appliweb.business.contract.manager.AvisManager;
import com.leasurecompagnon.appliweb.business.contract.manager.DepartementManager;
import com.leasurecompagnon.appliweb.business.contract.manager.DureeManager;
import com.leasurecompagnon.appliweb.business.contract.manager.FormulaireContactManager;
import com.leasurecompagnon.appliweb.business.contract.manager.PaysManager;
import com.leasurecompagnon.appliweb.business.contract.manager.PhotoManager;
import com.leasurecompagnon.appliweb.business.contract.manager.RegionManager;
import com.leasurecompagnon.appliweb.business.contract.manager.SaisonManager;
import com.leasurecompagnon.appliweb.business.contract.manager.TypeActiviteManager;
import com.leasurecompagnon.appliweb.business.contract.manager.UtilisateurManager;
import com.leasurecompagnon.appliweb.business.contract.manager.VilleManager;

/**
 * Factory des Managers
 * @author André Monnier
 */
public interface ManagerFactory {

	PhotoManager getPhotoManager();

	FormulaireContactManager getFormulaireContactManager();

	AvisManager getAvisManager();

	ActiviteManager getActiviteManager();

	UtilisateurManager getUtilisateurManager();

	TypeActiviteManager getTypeActiviteManager();

	SaisonManager getSaisonManager();

	DureeManager getDureeManager();

	DepartementManager getDepartementManager();

	RegionManager getRegionManager();

	PaysManager getPaysManager();

	VilleManager getVilleManager();

}