package com.leasurecompagnon.ws.consumer.contract;

import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.ws.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.ws.consumer.contract.dao.SaisonDao;
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

}