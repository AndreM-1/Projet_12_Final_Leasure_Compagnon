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

import com.leasurecompagnon.ws.business.contract.manager.DureeManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.DureeDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link DureeManagerImpl}
 * @author André Monnier
 *
 */
public class DureeManagerImplTest {

	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static DureeDao dureeDaoMock=mock(DureeDao.class);
	private DureeManager dureeManagerImpl = new DureeManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getDureeDao()).thenReturn(dureeDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier le bean durée attendu.
	 * @return La durée attendue.
	 */
	public static Duree createDureeExpected() {
		Duree vDuree =  new Duree();
		vDuree.setId(1);
		vDuree.setDureeConseillee("Moins de 30 minutes");
		return vDuree;
	}
	
	/**
	 * Méthode permettant d'instancier une liste de durées attendue.
	 * @return La liste de durées attendue.
	 */
	public static List<Duree> createListDureeExpected() {
		Duree vDuree =  new Duree();
		vDuree.setId(2);
		vDuree.setDureeConseillee("Entre 30 minutes et 1 heure");
		List<Duree> vListDuree = new ArrayList<>();
		vListDuree.add(createDureeExpected());
		vListDuree.add(vDuree);
		return vListDuree;
	}
	
	/**
	 * Test de la méthode getListDuree() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListDureeCase1() throws Exception {
		when(dureeDaoMock.getListDuree()).thenReturn(createListDureeExpected());
		List<Duree> listDuree=dureeManagerImpl.getListDuree();
		assertNotNull("La liste de durées retournée ne doit pas être nulle.",listDuree);
		assertEquals("La taille de la liste de durées est erronée.",2,listDuree.size());
	}
	
	/**
	 * Test de la méthode getListDuree() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListDureeCase2() throws Exception {
		when(dureeDaoMock.getListDuree()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		dureeManagerImpl.getListDuree();
	}
	
	
	/**
	 * Test de la méthode getDuree(int dureeId) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getDureeCase1() throws Exception {
		int dureeId=1;
		when(dureeDaoMock.getDuree(dureeId)).thenReturn(createDureeExpected());
		Duree duree=dureeManagerImpl.getDuree(dureeId);
		assertNotNull("Le bean durée retourné ne doit pas être nul",duree);
	}
	
	/**
	 * Test de la méthode getDuree(int dureeId) dans le cas où aucune durée ne correspond à l'identifiant demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getDureeCase2() throws Exception {
		int dureeId=-1;
		when(dureeDaoMock.getDuree(dureeId)).thenThrow(new NotFoundException("Aucune durée ne correspond à l'id demandé"));
		dureeManagerImpl.getDuree(dureeId);
	}
}