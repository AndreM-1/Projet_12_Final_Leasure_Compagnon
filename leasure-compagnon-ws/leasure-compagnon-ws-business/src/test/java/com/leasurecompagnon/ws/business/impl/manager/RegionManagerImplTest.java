package com.leasurecompagnon.ws.business.impl.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.leasurecompagnon.ws.business.contract.manager.RegionManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.RegionDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link RegionManagerImpl}
 * @author André Monnier
 *
 */
public class RegionManagerImplTest {
	
	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static RegionDao regionDaoMock=mock(RegionDao.class);
	private RegionManager regionManagerImpl = new RegionManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getRegionDao()).thenReturn(regionDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier une liste de régions attendue.
	 * @return La liste de régions attendue.
	 */
	public static List<Region> createListRegionExpected() {
		Region vRegion = new Region();
		vRegion.setId(1);
		vRegion.setNomRegion("Auvergne-Rhône-Alpes");
		List<Region> vListRegion = new ArrayList<>();
		vListRegion.add(vRegion);
		return vListRegion;
	}
	
	/**
	 * Test de la méthode getListRegion() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListRegionCase1() throws Exception {
		when(regionDaoMock.getListRegion()).thenReturn(createListRegionExpected());
		List<Region> listRegion = regionManagerImpl.getListRegion();
		assertNotNull("La liste de régions retournée ne doit pas être nulle.",listRegion);
		assertEquals("La taille de la liste de régions est erronée.",1,listRegion.size());
	}
	
	/**
	 * Test de la méthode getListRegion() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListRegionCase2() throws Exception {
		when(regionDaoMock.getListRegion()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		regionManagerImpl.getListRegion();
	}
}