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

import com.leasurecompagnon.ws.business.contract.manager.ActiviteManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.ActiviteDao;
import com.leasurecompagnon.ws.consumer.contract.dao.CoordonneeGPSDao;
import com.leasurecompagnon.ws.consumer.contract.dao.PhotoDao;
import com.leasurecompagnon.ws.consumer.contract.dao.TypeActiviteDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.StatutActiviteAvis;
import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link ActiviteManagerImpl}
 * @author André Monnier
 *
 */
public class ActiviteManagerImplTest {

	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static ActiviteDao activiteDaoMock=mock(ActiviteDao.class);
	private static CoordonneeGPSDao coordonneeGPSDaoMock=mock(CoordonneeGPSDao.class);
	private static PhotoDao photoDaoMock=mock(PhotoDao.class);
	private static TypeActiviteDao typeActiviteDaoMock=mock(TypeActiviteDao.class);
	private ActiviteManager activiteManagerImpl = new ActiviteManagerImpl(); 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getActiviteDao()).thenReturn(activiteDaoMock); 
		when(daoFactoryMock.getCoordonneeGPSDao()).thenReturn(coordonneeGPSDaoMock);
		when(daoFactoryMock.getPhotoDao()).thenReturn(photoDaoMock);
		when(daoFactoryMock.getTypeActiviteDao()).thenReturn(typeActiviteDaoMock);
	}

	/**
	 * Méthode permettant d'instancier le bean activité attendu.
	 * @return L'activité attendue.
	 */
	public static Activite createActiviteExpected() {
		Utilisateur vUtilisateur= new Utilisateur();
		vUtilisateur.setId(1);

		Ville vVille = new Ville();
		vVille.setId(1);

		StatutActiviteAvis vStatutActiviteAvis = new StatutActiviteAvis();
		vStatutActiviteAvis.setId(4);

		TypeActivite vTypeActivite1 = new TypeActivite();
		vTypeActivite1.setId(1);

		TypeActivite vTypeActivite4 = new TypeActivite();
		vTypeActivite4.setId(4);

		Activite vActivite = new Activite();
		vActivite.setId(1);
		vActivite.setNomActivite("Lac d'Annecy");
		vActivite.setUtilisateur(vUtilisateur);
		vActivite.setVille(vVille);
		vActivite.setStatutActivite(vStatutActiviteAvis);
		vActivite.getListTypeActivite().add(vTypeActivite1);
		vActivite.getListTypeActivite().add(vTypeActivite4);
		return vActivite;

	}

	/**
	 * Méthode permettant d'instancier une liste d'activités attendue.
	 * @return La liste d'activités attendue.
	 */
	public static List<Activite> createListActiviteExpected() {
		Utilisateur vUtilisateur= new Utilisateur();
		vUtilisateur.setId(1);

		Ville vVille = new Ville();
		vVille.setId(1);

		StatutActiviteAvis vStatutActiviteAvis = new StatutActiviteAvis();
		vStatutActiviteAvis.setId(4);

		TypeActivite vTypeActivite1 = new TypeActivite();
		vTypeActivite1.setId(1);

		TypeActivite vTypeActivite2 = new TypeActivite();
		vTypeActivite2.setId(2);

		Activite vActivite = new Activite();
		vActivite.setId(2);
		vActivite.setNomActivite("La Vieille Ville");
		vActivite.setUtilisateur(vUtilisateur);
		vActivite.setVille(vVille);
		vActivite.setStatutActivite(vStatutActiviteAvis);
		vActivite.getListTypeActivite().add(vTypeActivite1);
		vActivite.getListTypeActivite().add(vTypeActivite2);

		List<Activite> vListActivite = new ArrayList<>();
		vListActivite.add(createActiviteExpected());
		vListActivite.add(vActivite);

		return vListActivite;
	}

	/**
	 * Test de la méthode getActivite(int activiteId) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getActiviteCase1() throws Exception {
		int activiteId=1;
		when(activiteDaoMock.getActivite(activiteId)).thenReturn(createActiviteExpected());
		Activite activite=activiteManagerImpl.getActivite(activiteId);
		assertNotNull("Le bean activité retourné ne doit pas être nul",activite);
	}

	/**
	 * Test de la méthode getActivite(int activiteId) dans le cas où aucune activité ne correspond à l'identifiant demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getActiviteCase2() throws Exception {
		int activiteId=-1;
		when(activiteDaoMock.getActivite(activiteId)).thenThrow(new NotFoundException("Aucune activité ne correspond à l'id demandé"));
		activiteManagerImpl.getActivite(activiteId);
	}

	/**
	 * Test de la méthode getListActivite(int nbActivite, String statutActivite) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListActiviteCase1() throws Exception {
		int nbActivite = 2;
		String statutActivite="MEL";
		when(activiteDaoMock.getListActivite(nbActivite, statutActivite)).thenReturn(createListActiviteExpected());
		List<Activite> listActivite=activiteManagerImpl.getListActivite(nbActivite, statutActivite);
		assertNotNull("La liste d'activités retournée ne doit pas être nulle.",listActivite);
		assertEquals("La taille de la liste d'activités est erronée.",2,listActivite.size());
	}

	/**
	 * Test de la méthode getListActivite(int nbActivite, String statutActivite) dans le cas où aucune activité n'a le statut demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListActiviteCase2() throws Exception {
		int nbActivite = 2;
		String statutActivite="ECDM";
		when(activiteDaoMock.getListActivite(nbActivite, statutActivite)).thenThrow(new NotFoundException("Aucune activité avec le statut demandé"));
		activiteManagerImpl.getListActivite(nbActivite, statutActivite);
	}
	
	
	/**
	 * Test de la méthode getListActiviteVille(int villeId, String statutActivite) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListActiviteVilleCase1() throws Exception {
		int villeId=1;
		String statutActivite="MEL";
		when(activiteDaoMock.getListActiviteVille(villeId, statutActivite)).thenReturn(createListActiviteExpected());
		List<Activite> listActivite = activiteManagerImpl.getListActiviteVille(villeId, statutActivite);
		assertNotNull("La liste d'activités retournée ne doit pas être nulle.",listActivite);
		assertEquals("La taille de la liste d'activités est erronée.",2,listActivite.size());
	}
	
	/**
	 * Test de la méthode getListActiviteVille(int villeId, String statutActivite) dans le cas où aucune activité n'a le statut demandé dans la ville demandée.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListActiviteVilleCase2() throws Exception {
		int villeId=1;
		String statutActivite="ECDM";
		when(activiteDaoMock.getListActiviteVille(villeId, statutActivite)).thenThrow(new NotFoundException("Aucune activité avec le statut désiré pour la ville "
				+ "demandée ou aucune activité pour la ville demandée"));
		activiteManagerImpl.getListActiviteVille(villeId, statutActivite);
	}
	
	/**
	 * Test de la méthode getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite) dans le cas nominal.
	 * throws Exception
	 */
	@Test
	public void getListActiviteVilleTACase1() throws Exception {
		int villeId=1;
		int typeActiviteId=1;
		String statutActivite="MEL";
		when(activiteDaoMock.getListActiviteVilleTA(villeId, typeActiviteId, statutActivite)).thenReturn(createListActiviteExpected());
		List<Activite> listActivite = activiteManagerImpl.getListActiviteVilleTA(villeId, typeActiviteId, statutActivite);
		assertNotNull("La liste d'activités retournée ne doit pas être nulle.",listActivite);
		assertEquals("La taille de la liste d'activités est erronée.",2,listActivite.size());
	}
	
	/**
	 * Test de la méthode getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite) dans le cas où aucune activité ne correspond au statut et au 
	 * type d'activité demandés dans la ville demandée. On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListActiviteVilleTACase2() throws Exception {
		int villeId=1;
		int typeActiviteId=1;
		String statutActivite="ECDM";
		when(activiteDaoMock.getListActiviteVilleTA(villeId, typeActiviteId, statutActivite)).thenThrow(new NotFoundException("Aucune activité correspondant au "
				+ "type d'activité et au statut désirés pour la ville demandée ou aucune activité pour la ville demandée"));
		activiteManagerImpl.getListActiviteVilleTA(villeId, typeActiviteId, statutActivite);
	}
	
	/**
	 * Test de la méthode getListActiviteUtilisateur(int utilisateurId, String statutActivite) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListActiviteUtilisateurCase1() throws Exception {
		int utilisateurId=1;
		String statutActivite="MEL";
		when(activiteDaoMock.getListActiviteUtilisateur(utilisateurId, statutActivite)).thenReturn(createListActiviteExpected());
		List<Activite> listActivite = activiteManagerImpl.getListActiviteUtilisateur(utilisateurId, statutActivite);
		assertNotNull("La liste d'activités retournée ne doit pas être nulle.",listActivite);
		assertEquals("La taille de la liste d'activités est erronée.",2,listActivite.size());
	}
	
	/**
	 * Test de la méthode getListActiviteUtilisateur(int utilisateurId, String statutActivite) dans le cas où aucune activité n'a le statut souhaité pour l'utilisateur demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListActiviteUtilisateurCase2() throws Exception {
		int utilisateurId=1;
		String statutActivite="ECDM";
		when(activiteDaoMock.getListActiviteUtilisateur(utilisateurId, statutActivite)).thenThrow(new NotFoundException("Aucune activité avec le statut souhaité "
				+ "pour l'utilisateur demandé ou aucune activité postée par l'utilisateur"));
		activiteManagerImpl.getListActiviteUtilisateur(utilisateurId, statutActivite);
	}
	
	/**
	 * Test de la méthode getListNomActivite() dans le cas nominal.
	 */
	@Test
	public void getListNomActiviteCase1() throws Exception {
		List<String> listNomActivite =new ArrayList<>();
		listNomActivite.add("Lac d'Annecy");
		listNomActivite.add("La Vieille Ville");
		when(activiteDaoMock.getListNomActivite()).thenReturn(listNomActivite);
		List<String> listNomActiviteRetournee=activiteManagerImpl.getListNomActivite();
		assertNotNull("La liste de nom d'activités retournée ne doit pas être nulle.",listNomActiviteRetournee);
		assertEquals("La taille de la liste de nom d'activités est erronée.",2,listNomActiviteRetournee.size());
	}
	
	/**
	 * Test de la méthode getListNomActivite() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListNomActiviteCase2() throws Exception {
		when(activiteDaoMock.getListNomActivite()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		activiteManagerImpl.getListNomActivite();
	}
	
	
	/**
	 * Test de la méthode getListActiviteRecherche(String nomRecherche, String statutActivite) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListActiviteRechercheCase1() throws Exception {
		String nomRecherche="lac";
		String statutActivite="MEL";
		List<Activite> listActivite=new ArrayList<>();
		listActivite.add(createActiviteExpected());
		when(activiteDaoMock.getListActiviteRecherche("%"+nomRecherche+"%", statutActivite)).thenReturn(listActivite); 
		List<Activite> listActiviteRetournee = activiteManagerImpl.getListActiviteRecherche(nomRecherche, statutActivite);
		assertNotNull("La liste d'activités retournée ne doit pas être nulle.",listActiviteRetournee); 
		assertEquals("La taille de la liste d'activités est erronée.",1,listActiviteRetournee.size()); 
	}
	
	/**
	 * Test de la méthode getListActiviteRecherche(String nomRecherche, String statutActivite) dans le cas où le nombre de caractères renseigné n'est pas suffisant.
	 * On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void getListActiviteRechercheCase2() throws Exception {
		String nomRecherche="la";
		String statutActivite="MEL";
		activiteManagerImpl.getListActiviteRecherche(nomRecherche, statutActivite);
	}
	
	/**
	 * Test de la méthode getListActiviteRecherche(String nomRecherche, String statutActivite) dans le cas où aucune activité ne correspond à la chaîne de caractères 
	 * recherchée en fonction du statut demandé. On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListActiviteRechercheCase3() throws Exception {
		String nomRecherche="lac";
		String statutActivite="ECDM";
		when(activiteDaoMock.getListActiviteRecherche("%"+nomRecherche+"%", statutActivite)).thenThrow(new NotFoundException("Aucune activité ne correspond à la chaîne de "
				+ "caractères recherchée en fonction du statut demandé"));
		activiteManagerImpl.getListActiviteRecherche(nomRecherche, statutActivite);
	}
	
	/**
	 * Test de la méthode getListActiviteVille(String nomVille, String statutActivite) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListActiviteVilleStrCase1() throws Exception {
		String nomVille = "Annecy"; 
		String statutActivite = "MEL";
		when(activiteDaoMock.getListActiviteVille(nomVille, statutActivite)).thenReturn(createListActiviteExpected());
		List<Activite> listActivite = activiteManagerImpl.getListActiviteVille(nomVille, statutActivite);
		assertNotNull("La liste d'activités retournée ne doit pas être nulle.",listActivite);
		assertEquals("La taille de la liste d'activités est erronée.",2,listActivite.size());
	}
	
	/**
	 * Test de la méthode getListActiviteVille(String nomVille, String statutActivite) dans le cas où aucune activité n'a le statut demandé dans la ville demandée.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListActiviteVilleStrCase2() throws Exception {
		String nomVille = "Annecy"; 
		String statutActivite="ECDM";
		when(activiteDaoMock.getListActiviteVille(nomVille, statutActivite)).thenThrow(new NotFoundException("Aucune activité avec le statut désiré pour la ville "
				+ "demandée ou aucune activité pour la ville demandée"));
		activiteManagerImpl.getListActiviteVille(nomVille, statutActivite);
	}
	
	/**
	 * Test de la méthode getActivite(String nomActivite) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getActiviteStrCase1() throws Exception {
		String nomActivite="Lac d'Annecy";
		when(activiteDaoMock.getActivite(nomActivite)).thenReturn(createActiviteExpected());
		Activite activite=activiteManagerImpl.getActivite(nomActivite);
		assertNotNull("Le bean activité retourné ne doit pas être nul",activite);
	}
	
	/**
	 * Test de la méthode getActivite(String nomActivite) dans le cas où aucune activité ne correspond au nom demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getActiviteStrCase2() throws Exception {
		String nomActivite="Activité Test";
		when(activiteDaoMock.getActivite(nomActivite)).thenThrow(new NotFoundException("Aucune activité ne correspond au nom demandé"));
		activiteManagerImpl.getActivite(nomActivite);
	}
	
	/**
	 * Test de la méthode ajoutActivite(Activite activite) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void ajoutActiviteCase1() throws Exception {
		int sequenceActivite=26;
		Activite vActivite=createActiviteExpected();
		when(activiteDaoMock.getSequenceActivite()).thenReturn(sequenceActivite);
		activiteManagerImpl.ajoutActivite(vActivite);
	}
	
	/**
	 * Test de la méthode updateStatutActivite(int activiteId, int statutActiviteId, String dateAModifier) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void updateStatutActiviteCase1() throws Exception {
		int activiteId=26;
		int statutActiviteId=2;
		String dateAModifier="DATE_MODERATION_ADMIN";
		activiteManagerImpl.updateStatutActivite(activiteId, statutActiviteId, dateAModifier);
	}
	
	/**
	 * Test de la méthode deleteActivite(int activiteId) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void deleteActiviteCase1() throws Exception {
		int activiteId=26;
		activiteManagerImpl.deleteActivite(activiteId);
	}
}