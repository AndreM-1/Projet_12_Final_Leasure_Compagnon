package com.leasurecompagnon.ws.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.leasurecompagnon.ws.business.contract.ManagerFactory;
import com.leasurecompagnon.ws.business.contract.manager.DepartementManager;
import com.leasurecompagnon.ws.business.contract.manager.DureeManager;
import com.leasurecompagnon.ws.business.contract.manager.PaysManager;
import com.leasurecompagnon.ws.business.contract.manager.RegionManager;
import com.leasurecompagnon.ws.business.contract.manager.SaisonManager;
import com.leasurecompagnon.ws.business.contract.manager.VilleManager;

/**
 * Implémentation de la {@link ManagerFactory}.
 */
@Named
public class ManagerFactoryImpl implements ManagerFactory{
	
	@Inject
	private VilleManager villeManager;
	
	@Inject
	private PaysManager paysManager;
	
	@Inject
	private RegionManager regionManager;
	
	@Inject
	private DepartementManager departementManager; 
	
	@Inject
	private DureeManager dureeManager;
	
	@Inject
	private SaisonManager saisonManager; 

	
	@Override
	public VilleManager getVilleManager() {
		return villeManager;
	}
	
	@Override
	public PaysManager getPaysManager() {
		return paysManager;
	}

	@Override
	public RegionManager getRegionManager() {
		return regionManager;
	}

	@Override
	public DepartementManager getDepartementManager() {
		return departementManager;
	}

	@Override
	public DureeManager getDureeManager() {
		return dureeManager;
	}

	@Override
	public SaisonManager getSaisonManager() {
		return saisonManager;
	}
}