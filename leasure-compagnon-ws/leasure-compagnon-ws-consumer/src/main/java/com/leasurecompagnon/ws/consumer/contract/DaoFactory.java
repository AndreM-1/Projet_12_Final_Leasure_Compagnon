package com.leasurecompagnon.ws.consumer.contract;

import com.leasurecompagnon.ws.consumer.contract.dao.ActiviteDao;
import com.leasurecompagnon.ws.consumer.contract.dao.AvisDao;
import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.ws.consumer.contract.dao.FormulaireContactDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.ws.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.ws.consumer.contract.dao.TypeActiviteDao;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.consumer.contract.dao.VilleDao;

/**
 * Factory des DAO
 * @author André Monnier
 */
public interface DaoFactory {

	VilleDao getVilleDao();

	PaysDao getPaysDao();

	RegionDao getRegionDao();

	DepartementDao getDepartementDao();

	DureeDao getDureeDao();

	SaisonDao getSaisonDao();

	TypeActiviteDao getTypeActiviteDao();

	UtilisateurDao getUtilisateurDao();

	ActiviteDao getActiviteDao();

	AvisDao getAvisDao();

	FormulaireContactDao getFormulaireContactDao();

	PhotoDao getPhotoDao();

	CoordonneeGPSDao getCoordonneeGPSDao();

}