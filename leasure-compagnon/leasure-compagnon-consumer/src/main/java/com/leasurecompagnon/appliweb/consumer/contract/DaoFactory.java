package com.leasurecompagnon.appliweb.consumer.contract;

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
 * Factory des DAO
 * @author André Monnier
 */
public interface DaoFactory {

	PhotoDao getPhotoDao();

	FormulaireContactDao getFormulaireContactDao();

	AvisDao getAvisDao();

	ActiviteDao getActiviteDao();

	UtilisateurDao getUtilisateurDao();

	TypeActiviteDao getTypeActiviteDao();

	SaisonDao getSaisonDao();

	DureeDao getDureeDao();

	DepartementDao getDepartementDao();

	RegionDao getRegionDao();

	PaysDao getPaysDao();

	VilleDao getVilleDao();

}