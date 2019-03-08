package com.leasurecompagnon.appliweb.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leasurecompagnon.appliweb.business.contract.manager.VilleManager;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Ville;
import com.leasurecompagnon.appliweb.model.exception.GetListNomVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleRechercheFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetVilleFault_Exception;

@Named
public class VilleManagerImpl extends AbstractManager implements VilleManager {

	private List<Ville> listVille;	
	private Ville ville;
	private List<String> listNomVille;
	
	//Définition du LOGGER
	private static final Logger LOGGER=(Logger) LogManager.getLogger(VilleManagerImpl.class);
	
	@Override
	public List<Ville> getListVille(int nbVille) throws GetListVilleFault_Exception {
		LOGGER.info("Méthode getListVille(int nbVille)");
		try {
			listVille = getDaoFactory().getVilleDao().getListVille(nbVille);
		} catch (GetListVilleFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListVilleFault_Exception(e.getMessage());
		}
		return listVille;
	}
	
	@Override
	public Ville getVille(int villeId) throws GetVilleFault_Exception {
		LOGGER.info("Méthode getVille(int villeId)");
		try {
			ville = getDaoFactory().getVilleDao().getVille(villeId);
		} catch (GetVilleFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetVilleFault_Exception (e.getMessage());
		}
		return ville;
	}
	
	@Override
	public List<String> getListNomVille() throws GetListNomVilleFault_Exception {
		LOGGER.info("Méthode getListNomVille()");
		try {
			listNomVille = getDaoFactory().getVilleDao().getListNomVille();
		} catch (GetListNomVilleFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListNomVilleFault_Exception(e.getMessage());
		}
		return listNomVille;
	}
	
	@Override
	public List<Ville> getListVilleRecherche(String nomRecherche) throws GetListVilleRechercheFault_Exception {
		LOGGER.info("Méthode getListVilleRecherche(String nomRecherche)");
		try {
			listVille = getDaoFactory().getVilleDao().getListVilleRecherche(nomRecherche);
		} catch (GetListVilleRechercheFault_Exception e) {
			LOGGER.info(e.getMessage());
			throw new GetListVilleRechercheFault_Exception(e.getMessage());
		}
		return listVille;
	}
}