package com.leasurecompagnon.appliweb.consumer.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.leasurecompagnon.appliweb.consumer.contract.DaoFactory;
import com.leasurecompagnon.appliweb.consumer.contract.dao.ActiviteDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.AvisDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.FormulaireContactDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.TypeActiviteDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.appliweb.consumer.contract.dao.VilleDao;


/**
 * Implémentation de la {@link DaoFactory}
 */
@Named
public class DaoFactoryImpl implements DaoFactory {
	
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
	
	@Inject
	private TypeActiviteDao typeActiviteDao;
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	@Inject
	private ActiviteDao activiteDao;
	
	@Inject
	private AvisDao avisDao;
	
	@Inject
	private FormulaireContactDao formulaireContactDao;
	
	@Inject
	private PhotoDao photoDao;

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

	@Override
	public TypeActiviteDao getTypeActiviteDao() {
		return typeActiviteDao;
	}

	@Override
	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	@Override
	public ActiviteDao getActiviteDao() {
		return activiteDao;
	}

	@Override
	public AvisDao getAvisDao() {
		return avisDao;
	}

	@Override
	public FormulaireContactDao getFormulaireContactDao() {
		return formulaireContactDao;
	}

	@Override
	public PhotoDao getPhotoDao() {
		return photoDao;
	}
}