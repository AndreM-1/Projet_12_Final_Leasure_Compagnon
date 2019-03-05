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

import com.leasurecompagnon.ws.business.contract.manager.VilleManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.VilleDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

public class VilleManagerImplTest {

	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static VilleDao villeDaoMock=mock(VilleDao.class);
	private VilleManager villeManagerImpl = new VilleManagerImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getVilleDao()).thenReturn(villeDaoMock); 
	}

	/**
	 * Méthode permettant d'instancier le bean ville attendu.
	 * @return La ville attendue.
	 */
	public static Ville createVilleExpected() {
		Ville vVille = new Ville();
		vVille.setId(1);
		vVille.setNomVille("Annecy");
		vVille.setCodePostal("74000");
		vVille.setDescription("Annecy est une ville des Alpes située dans le sud-est de la France.");
		vVille.setNbHabitant(126419);
		return vVille;
	}

	/**
	 * Méthode permettant d'instancier une liste de villes attendue.
	 * @return La liste d'activité attendue.
	 */
	public static List<Ville> createListVilleExpected() {
		Ville vVille = new Ville();
		vVille.setId(10);
		vVille.setNomVille("Annemasse");
		vVille.setCodePostal("74100");
		vVille.setDescription("Annemasse est le centre de la deuxième agglomération de Haute-Savoie.");
		vVille.setNbHabitant(35041);

		List<Ville> vListVille = new ArrayList<>();
		vListVille.add(createVilleExpected());
		vListVille.add(vVille);
		return vListVille;
	}

	/**
	 * Test de la méthode getListVille(int nbVille) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListVilleCase1() throws Exception {
		int nbVille = 2;
		when(villeDaoMock.getListVille(nbVille)).thenReturn(createListVilleExpected());
		List<Ville> listVille = villeManagerImpl.getListVille(nbVille);
		assertNotNull("La liste de ville retournée ne doit pas être nulle.",listVille);
		assertEquals("La taille de la liste de ville est erronée.",2,listVille.size());
	}

	/**
	 * Test de la méthode getListVille(int nbVille) dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListVilleCase2() throws Exception {
		int nbVille = 2;
		when(villeDaoMock.getListVille(nbVille)).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		villeManagerImpl.getListVille(nbVille);
	}
	
	/**
	 * Test de la méthode getVille(int villeId) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getVilleCase1() throws Exception {
		int villeId = 1;
		when(villeDaoMock.getVille(villeId)).thenReturn(createVilleExpected());
		Ville ville = villeManagerImpl.getVille(villeId);
		assertNotNull("La ville retournée ne doit pas être nulle.",ville);
	}
	
	/**
	 * Test de la méthode getVille(int villeId) dans le cas où aucune ville ne correspond à l'identifiant demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getVilleCase2() throws Exception {
		int villeId = -1;
		when(villeDaoMock.getVille(villeId)).thenThrow(new NotFoundException("Aucune ville ne correspond à l'id demandé"));
		villeManagerImpl.getVille(villeId);
	}
	
	/**
	 * Test de la méthode getListNomVille() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListNomVilleCase1() throws Exception {
		List<String> listNomVille = new ArrayList<>();
		listNomVille.add("Annecy");
		listNomVille.add("Annemasse");
		when(villeDaoMock.getListNomVille()).thenReturn(listNomVille);
		List<String> listNomVilleRetournee = villeManagerImpl.getListNomVille();
		assertNotNull("La liste de nom de villes retournée ne doit pas être nulle.",listNomVilleRetournee);
		assertEquals("La taille de la liste de nom de villes est erronée.",2,listNomVilleRetournee.size());
	}
	
	/**
	 * Test de la méthode getListNomVille() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListNomVilleCase2() throws Exception {
		when(villeDaoMock.getListNomVille()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		villeManagerImpl.getListNomVille();
	}
	
	/**
	 * Test de la méthode getListVilleRecherche(String nomRecherche) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListVilleRechercheCase1() throws Exception {
		String nomRecherche="anne";
		List<Ville> listVille=new ArrayList<>();
		listVille.addAll(createListVilleExpected());
		when(villeDaoMock.getListVilleRecherche("%"+nomRecherche+"%")).thenReturn(listVille);
		List<Ville> listVilleRetournee=villeManagerImpl.getListVilleRecherche(nomRecherche);
		assertNotNull("La liste de ville retournée ne doit pas être nulle.",listVilleRetournee); 
		assertEquals("La taille de la liste de ville est erronée.",2,listVilleRetournee.size());
	}
	
	/**
	 * Test de la méthode getListVilleRecherche(String nomRecherche) dans le cas où le nombre de caractères renseigné n'est pas suffisant.
	 * On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void getListVilleRechercheCase2() throws Exception {
		String nomRecherche="  a  n ";
		villeManagerImpl.getListVilleRecherche(nomRecherche);
	}
	
	/**
	 * Test de la méthode getListVilleRecherche(String nomRecherche) dans le cas où aucune ville ne correspond à la chaîne de caractères recherchée.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListVilleRechercheCase3() throws Exception {
		String nomRecherche="zxy";
		when(villeDaoMock.getListVilleRecherche("%"+nomRecherche+"%")).thenThrow(new NotFoundException("Aucune ville ne correspond à la chaîne de caractères recherchée"));
		villeManagerImpl.getListVilleRecherche(nomRecherche);
	}
}
