package com.leasurecompagnon.ws.business.impl.manager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.leasurecompagnon.ws.business.contract.manager.PhotoManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link PhotoManagerImpl}
 * @author André Monnier
 *
 */
public class PhotoManagerImplTest {

	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static PhotoDao photoDaoMock=mock(PhotoDao.class);
	private PhotoManager photoManagerImpl = new PhotoManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getPhotoDao()).thenReturn(photoDaoMock); 
	}
	
	/**
	 * Test de la méthode insertPhotoUtilisateur(String nomPhoto, int utilisateurId) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void insertPhotoUtilisateurCase1() throws Exception {
		String nomPhoto="jsp/assets/images/utilisateur/utilisateur-5_2019-03-06.jpg";
		int utilisateurId = 5;
		photoManagerImpl.insertPhotoUtilisateur(nomPhoto, utilisateurId);
	}
}