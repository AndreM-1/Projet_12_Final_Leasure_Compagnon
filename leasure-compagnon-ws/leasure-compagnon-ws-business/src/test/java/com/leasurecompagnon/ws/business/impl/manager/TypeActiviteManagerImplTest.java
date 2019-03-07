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

import com.leasurecompagnon.ws.business.contract.manager.TypeActiviteManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.TypeActiviteDao;
import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link TypeActiviteManagerImpl}
 * @author André Monnier
 *
 */
public class TypeActiviteManagerImplTest {

	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static TypeActiviteDao typeActiviteDaoMock=mock(TypeActiviteDao.class);
	private TypeActiviteManager typeActiviteManagerImpl = new TypeActiviteManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getTypeActiviteDao()).thenReturn(typeActiviteDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier le bean TypeActivite attendu.
	 * @return Le bean TypeActivite attendu.
	 */
	public static TypeActivite createTypeActiviteExpected() {
		TypeActivite vTypeActivite =  new TypeActivite();
		vTypeActivite.setId(1);
		vTypeActivite.setTypeActivite("Les incontournables");
		return vTypeActivite;
	}
	
	/**
	 * Méthode permettant d'instancier une liste de TypeActivite attendue.
	 * @return La liste de TypeActivite attendue.
	 */
	public static List<TypeActivite> createListTypeActiviteExpected() {
		TypeActivite vTypeActivite =  new TypeActivite();
		vTypeActivite.setId(2);
		vTypeActivite.setTypeActivite("Sites et monuments");
		List<TypeActivite> vListTypeActivite = new ArrayList<>();
		vListTypeActivite.add(createTypeActiviteExpected());
		vListTypeActivite.add(vTypeActivite);
		return vListTypeActivite;
	}
	 
	/**
	 * Test de la méthode getListTypeActivite() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListTypeActiviteCase1() throws Exception {
		when(typeActiviteDaoMock.getListTypeActivite()).thenReturn(createListTypeActiviteExpected());
		List<TypeActivite> listTypeActivite = typeActiviteManagerImpl.getListTypeActivite();
		assertNotNull("La liste de TypeActivite retournée ne doit pas être nulle.",listTypeActivite);
		assertEquals("La taille de la liste de TypeActivite est erronée.",2,listTypeActivite.size());
	}
	
	/**
	 * Test de la méthode getListTypeActivite() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListTypeActiviteCase2() throws Exception {
		when(typeActiviteDaoMock.getListTypeActivite()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		typeActiviteManagerImpl.getListTypeActivite();
	}
	
	/**
	 * Test de la méthode getTypeActivite(int typeActiviteId) dans le cas nominal. 
	 * @throws Exception
	 */
	@Test
	public void getTypeActiviteCase1() throws Exception {
		int typeActiviteId = 1;
		when(typeActiviteDaoMock.getTypeActivite(typeActiviteId)).thenReturn(createTypeActiviteExpected());
		TypeActivite typeActivite = typeActiviteManagerImpl.getTypeActivite(typeActiviteId);
		assertNotNull("Le bean typeActivite retourné ne doit pas être nul",typeActivite);
	}
	
	/**
	 * Test de la méthode getTypeActivite(int typeActiviteId) dans le cas où aucun type d'activité ne correspond à l'identifiant demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getTypeActiviteCase2() throws Exception {
		int typeActiviteId = -1;
		when(typeActiviteDaoMock.getTypeActivite(typeActiviteId)).thenThrow(new NotFoundException("Aucun type d'activité ne correspond à l'id demandé"));
		typeActiviteManagerImpl.getTypeActivite(typeActiviteId);
	}
}