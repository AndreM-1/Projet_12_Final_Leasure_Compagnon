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

import com.leasurecompagnon.ws.business.contract.manager.PaysManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.PaysDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link PaysManagerImpl}
 * @author André Monnier
 *
 */
public class PaysManagerImplTest {

	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static PaysDao paysDaoMock=mock(PaysDao.class);
	private PaysManager paysManagerImpl = new PaysManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getPaysDao()).thenReturn(paysDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier une liste de pays attendue.
	 * @return La liste de pays attendue.
	 */
	public static List<Pays> createListPaysExpected() {
		Pays vPays = new Pays();
		vPays.setId(1);
		vPays.setNomPays("France");
		List<Pays> vListPays = new ArrayList<>();
		vListPays.add(vPays);
		return vListPays;
	}
	
	/**
	 * Test de la méthode getListPays() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListPaysCase1() throws Exception {
		when(paysDaoMock.getListPays()).thenReturn(createListPaysExpected());
		List<Pays> listPays = paysManagerImpl.getListPays();
		assertNotNull("La liste de pays retournée ne doit pas être nulle.",listPays);
		assertEquals("La taille de la liste de pays est erronée.",1,listPays.size());
	}
	
	/**
	 * Test de la méthode getListPays() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListPaysCase2() throws Exception {
		when(paysDaoMock.getListPays()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		paysManagerImpl.getListPays();
	}
}
