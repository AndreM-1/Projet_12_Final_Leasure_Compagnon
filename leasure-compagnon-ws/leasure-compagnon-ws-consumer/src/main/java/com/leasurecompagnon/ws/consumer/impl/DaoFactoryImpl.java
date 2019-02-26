package com.leasurecompagnon.ws.consumer.impl;

import javax.inject.Inject;

import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.ws.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.ws.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.ws.consumer.contract.dao.VilleDao;

/**
 * Implémentation de la {@link DaoFactory}
 */
public class DaoFactoryImpl implements DaoFactory{

	@Inject
	private VilleDao villeDao;
	
	@Inject
	private PaysDao paysDao;
	
	@Inject
	private RegionDao regionDao; 
	
	@Inject
	private DepartementDao departementDao;
	
	@Inject
	private DureeDao dureeDao;
	
	@Inject
	private SaisonDao saisonDao;

	
	@Override
	public VilleDao getVilleDao() {
		return villeDao;
	}
	
	@Override
	public PaysDao getPaysDao() {
		return paysDao;
	}

	@Override
	public RegionDao getRegionDao() {
		return regionDao;
	}

	@Override
	public DepartementDao getDepartementDao() {
		return departementDao;
	}

	@Override
	public DureeDao getDureeDao() {
		return dureeDao;
	}

	@Override
	public SaisonDao getSaisonDao() {
		return saisonDao;
	}
}