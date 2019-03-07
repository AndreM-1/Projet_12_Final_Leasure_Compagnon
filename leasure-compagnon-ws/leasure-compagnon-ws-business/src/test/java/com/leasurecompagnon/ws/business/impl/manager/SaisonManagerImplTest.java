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

import com.leasurecompagnon.ws.business.contract.manager.SaisonManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.SaisonDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link SaisonManagerImpl}
 * @author André Monnier
 *
 */
public class SaisonManagerImplTest {

	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static SaisonDao saisonDaoMock=mock(SaisonDao.class);
	private SaisonManager saisonManagerImpl = new SaisonManagerImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getSaisonDao()).thenReturn(saisonDaoMock); 
	}

	/**
	 * Méthode permettant d'instancier le bean saison attendu.
	 * @return La saison attendue.
	 */
	public static Saison createSaisonExpected() {
		Saison vSaison =  new Saison();
		vSaison.setId(1);
		vSaison.setNomSaison("Printemps");
		return vSaison;
	}

	/**
	 * Méthode permettant d'instancier une liste de saisons attendue.
	 * @return La liste de saisons attendue.
	 */
	public static List<Saison> createListSaisonExpected() {
		Saison vSaison =  new Saison();
		vSaison.setId(2);
		vSaison.setNomSaison("Eté");
		List<Saison> vListSaison = new ArrayList<>();
		vListSaison.add(createSaisonExpected());
		vListSaison.add(vSaison);
		return vListSaison;
	}

	/**
	 * Test de la méthode getListSaison() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListSaisonCase1() throws Exception {
		when(saisonDaoMock.getListSaison()).thenReturn(createListSaisonExpected());
		List<Saison> listSaison = saisonManagerImpl.getListSaison();
		assertNotNull("La liste de saisons retournée ne doit pas être nulle.",listSaison);
		assertEquals("La taille de la liste de saisons est erronée.",2,listSaison.size());
	}

	/**
	 * Test de la méthode getListSaison() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListSaisonCase2() throws Exception {
		when(saisonDaoMock.getListSaison()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		saisonManagerImpl.getListSaison();
	}

	/**
	 * Test de la méthode getSaison(int saisonId) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getSaisonCase1() throws Exception {
		int saisonId=1;
		when(saisonDaoMock.getSaison(saisonId)).thenReturn(createSaisonExpected());
		Saison saison = saisonManagerImpl.getSaison(saisonId);
		assertNotNull("Le bean saison retourné ne doit pas être nul",saison);
	}


	/**
	 * Test de la méthode getSaison(int saisonId) dans le cas où aucune saison ne correspond à l'identifiant demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getSaisonCase2() throws Exception {
		int saisonId=-1;
		when(saisonDaoMock.getSaison(saisonId)).thenThrow(new NotFoundException("Aucune saison ne correspond à l'id demandé"));
		saisonManagerImpl.getSaison(saisonId);
	}
}