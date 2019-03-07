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

import com.leasurecompagnon.ws.business.contract.manager.DepartementManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.DepartementDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link DepartementManagerImpl}
 * @author André Monnier
 *
 */
public class DepartementManagerImplTest {
	
	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static DepartementDao departementDaoMock=mock(DepartementDao.class);
	private DepartementManager departementManagerImpl = new DepartementManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getDepartementDao()).thenReturn(departementDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier une liste de départements attendue.
	 * @return La liste de départements attendue.
	 */
	public static List<Departement> createListDepartementExpected() {
		Departement vDepartement = new Departement();
		vDepartement.setId(1);
		vDepartement.setNomDepartement("Haute-Savoie");
		List<Departement> vListDepartement = new ArrayList<>();
		vListDepartement.add(vDepartement);
		return vListDepartement;
	}
	
	/**
	 * Test de la méthode getListDepartement() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListDepartementCase1() throws Exception{
		when(departementDaoMock.getListDepartement()).thenReturn(createListDepartementExpected());
		List<Departement> listDepartement = departementManagerImpl.getListDepartement();
		assertNotNull("La liste de départements retournée ne doit pas être nulle.",listDepartement);
		assertEquals("La taille de la liste de départements est erronée.",1,listDepartement.size());
	}
	
	/**
	 * Test de la méthode getListDepartement() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListDepartementCase2() throws Exception {
		when(departementDaoMock.getListDepartement()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		departementManagerImpl.getListDepartement();
	}
}