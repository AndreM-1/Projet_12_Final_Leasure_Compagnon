package com.leasurecompagnon.ws.testbusiness.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.bean.catalogue.CoordonneeGPS;
import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.bean.catalogue.Photo;
import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests d'intégration 
 * au niveau du module business.
 * @author André Monnier
 *
 */
public class TestIntegration extends BusinessTestCase {

	//ATTENTION à l'ordre à cause des contraintes de clés étrangères !!!
	private static final String[] TABNOMTABLESBDD= {"public.photo","public.formulaire_contact","public.avis","public.coordonnee_gps","public.activite_type_activite",
			"public.activite","public.utilisateur","public.ville","public.departement","public.region","public.pays","public.type_activite","public.duree",
			"public.saison","public.statut_activite_avis"};

	private static final String[] TABNOMSEQUENCESBDD= {"public.photo_id_seq","public.formulaire_contact_id_seq","public.avis_id_seq","public.coordonnee_gps_id_seq",
			"public.activite_id_seq","public.utilisateur_id_seq","public.ville_id_seq","public.departement_id_seq","public.region_id_seq","public.pays_id_seq",
			"public.type_activite_id_seq","public.duree_id_seq","public.saison_id_seq","public.statut_activite_avis_id_seq"};
	
	@Before
	public void setUp() throws Exception {
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		//On efface les données des tables de la base de données.
		for(String str:TABNOMTABLESBDD) {
			String vSQL= "DELETE FROM "+ str;
			try {
				vJdbcTemplate.update(vSQL);
			} catch (DataAccessException e) {
				getPlatformTransactionManager().rollback(vTransactionStatus);
				throw new TechnicalException("Erreur d'accès à la base de données");
			}
		}

		//On réinitialise les séquences de toutes les tables.
		for(String str:TABNOMSEQUENCESBDD) {
			try {
				vJdbcTemplate.update("ALTER SEQUENCE "+ str+" RESTART 1");
			} catch (DataAccessException e) {
				getPlatformTransactionManager().rollback(vTransactionStatus);
				throw new TechnicalException("Erreur d'accès à la base de données");
			}
		}

		//On remplit les tables de la base de données avec un jeu de données de démo pour les tests d'intégration.
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setSqlScriptEncoding("UTF-8");
		try {
			populator.addScripts(new ClassPathResource("02_Insertion_donnees_DB_Systeme_information_leasure_compagnon_TI_v1.sql"));
			populator.execute(getDataSource());
			getPlatformTransactionManager().commit(vTransactionStatus);
		} catch (ScriptException e) {
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new TechnicalException("Erreur d'accès à la base de données");

		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		TransactionStatus vTransactionStatus= getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		//On efface les données des tables de la base de données.
		for(String str:TABNOMTABLESBDD) {
			String vSQL= "DELETE FROM "+ str;
			try {
				vJdbcTemplate.update(vSQL);
			} catch (DataAccessException e) {
				getPlatformTransactionManager().rollback(vTransactionStatus);
				throw new TechnicalException("Erreur d'accès à la base de données");
			}
		}

		//On réinitialise les séquences de toutes les tables.
		for(String str:TABNOMSEQUENCESBDD) {
			try {
				vJdbcTemplate.update("ALTER SEQUENCE "+ str+" RESTART 1");
			} catch (DataAccessException e) {
				getPlatformTransactionManager().rollback(vTransactionStatus);
				throw new TechnicalException("Erreur d'accès à la base de données");
			}
		}

		//On remplit les tables de la base de données avec le jeu de données initiales de démo.
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setSqlScriptEncoding("UTF-8");
		try {
			populator.addScripts(new ClassPathResource("02_Insertion_donnees_DB_Systeme_information_leasure_compagnon_v1.sql"));
			populator.execute(getDataSource());
			getPlatformTransactionManager().commit(vTransactionStatus);
		} catch (ScriptException e) {
			getPlatformTransactionManager().rollback(vTransactionStatus);
			throw new TechnicalException("Erreur d'accès à la base de données");
		}
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Activite}.
	 * @throws Exception
	 */
	@Test
	public void testSelectActivite() throws Exception {
		//Méthode getActivite(int activiteId)
		int activiteId = 4;
		Activite vActiviteBDD=getManagerFactory().getActiviteManager().getActivite(activiteId);
		assertNotNull("Le bean activité retourné ne doit pas être nul.",vActiviteBDD);
		
		//Méthode getListActivite(int nbActivite, String statutActivite)
		int nbActivite = -1; 
		String statutActivite = "MEL";
		List<Activite> vListActiviteBDD = getManagerFactory().getActiviteManager().getListActivite(nbActivite, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",25,vListActiviteBDD.size());
		
		nbActivite = 3; 
		statutActivite = "ALL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActivite(nbActivite, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",3,vListActiviteBDD.size());
		
		//Méthode getListActiviteVille(int villeId, String statutActivite)
		int villeId = 1;
		statutActivite="MEL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteVille(villeId, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",12,vListActiviteBDD.size());
		
		villeId = 2;
		statutActivite="ALL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteVille(villeId, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",10,vListActiviteBDD.size());
		
		//Méthode getListActiviteVilleTA(int villeId, int typeActiviteId, String statutActivite)
		villeId = 1;
		statutActivite ="MEL";
		int typeActiviteId = 1;
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteVilleTA(villeId, typeActiviteId, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",5,vListActiviteBDD.size());
		
		villeId = 3;
		statutActivite ="MEL";
		typeActiviteId = 4;
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteVilleTA(villeId, typeActiviteId, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",2,vListActiviteBDD.size());
		
		//Méthode getListActiviteUtilisateur(int utilisateurId, String statutActivite)
		int utilisateurId=1;
		statutActivite="MEL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteUtilisateur(utilisateurId, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",25,vListActiviteBDD.size());
		
		//Méthode getListNomActivite()
		List<String> vListNomActiviteBDD = getManagerFactory().getActiviteManager().getListNomActivite();
		assertNotNull("La liste de nom d'activités ne doit pas être nulle.",vListNomActiviteBDD);
		assertEquals("La taille de la liste de nom d'activités est erronée.",25,vListNomActiviteBDD.size());
		
		//Méthode getListActiviteRecherche(String nomRecherche, String statutActivite)
		String nomRecherche = " A  n n";
		statutActivite="MEL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteRecherche(nomRecherche, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",3,vListActiviteBDD.size());
		
		nomRecherche = "Château";
		statutActivite="ALL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteRecherche(nomRecherche, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",2,vListActiviteBDD.size());
		
		//Méthode getListActiviteVille(String nomVille, String statutActivite)
		String nomVille="Annecy";
		statutActivite="MEL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteVille(nomVille, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",12,vListActiviteBDD.size());
		
		nomVille="Sixt-Fer-à-Cheval";
		statutActivite="ALL";
		vListActiviteBDD = getManagerFactory().getActiviteManager().getListActiviteVille(nomVille, statutActivite);
		assertNotNull("La liste d'activités ne doit pas être nulle.",vListActiviteBDD);
		assertEquals("La taille de la liste d'activités est erronée.",2,vListActiviteBDD.size());
		
		//Méthode getActivite(String nomActivite)
		String nomActivite="Voie Verte du Lac d'Annecy";
		vActiviteBDD=getManagerFactory().getActiviteManager().getActivite(nomActivite);
		assertNotNull("Le bean activité retourné ne doit pas être nul.",vActiviteBDD);
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Avis}.
	 * @throws Exception
	 */
	@Test
	public void testSelectAvis() throws Exception {
		//Méthode getListAvisUtilisateur(int utilisateurId, String statutAvis)
		int utilisateurId = 2;
		String statutAvis = "MEL";
		List<Avis> vListAvisBDD = getManagerFactory().getAvisManager().getListAvisUtilisateur(utilisateurId, statutAvis);
		assertNotNull("La liste d'avis ne doit pas être nulle.",vListAvisBDD);
		assertEquals("La taille de la liste d'avis est erronée.",9,vListAvisBDD.size());
		
		utilisateurId = 3;
		statutAvis = "ALL";
		vListAvisBDD = getManagerFactory().getAvisManager().getListAvisUtilisateur(utilisateurId, statutAvis);
		assertNotNull("La liste d'avis ne doit pas être nulle.",vListAvisBDD);
		assertEquals("La taille de la liste d'avis est erronée.",7,vListAvisBDD.size());
		
		utilisateurId = 4;
		statutAvis = "ALL";
		vListAvisBDD = getManagerFactory().getAvisManager().getListAvisUtilisateur(utilisateurId, statutAvis);
		assertNotNull("La liste d'avis ne doit pas être nulle.",vListAvisBDD);
		assertEquals("La taille de la liste d'avis est erronée.",4,vListAvisBDD.size());
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Departement}.
	 * @throws Exception
	 */
	@Test
	public void testSelectDepartement() throws Exception {
		//Méthode getListDepartement()
		List<Departement> vListDepartementBDD = getManagerFactory().getDepartementManager().getListDepartement();
		assertNotNull("La liste de départements ne doit pas être nulle.",vListDepartementBDD);
		assertEquals("La taille de la liste de départements est erronée.",1,vListDepartementBDD.size());
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Region}.
	 * @throws Exception
	 */
	@Test
	public void testSelectRegion() throws Exception {
		//Méthode getListRegion()
		List<Region> vListRegionBDD = getManagerFactory().getRegionManager().getListRegion();
		assertNotNull("La liste de régions ne doit pas être nulle.",vListRegionBDD);
		assertEquals("La taille de la liste de régions est erronée.",1,vListRegionBDD.size());
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Pays}.
	 * @throws Exception
	 */
	@Test
	public void testSelectPays() throws Exception {
		//Méthode getListPays()
		List<Pays> vListPaysBDD = getManagerFactory().getPaysManager().getListPays();
		assertNotNull("La liste de pays ne doit pas être nulle.",vListPaysBDD);
		assertEquals("La taille de la liste de pays est erronée.",1,vListPaysBDD.size());
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Duree}.
	 * @throws Exception
	 */
	@Test
	public void testSelectDuree() throws Exception {
		//Méthode getListDuree()
		List<Duree> vListDureeBDD = getManagerFactory().getDureeManager().getListDuree();
		assertNotNull("La liste de durées ne doit pas être nulle.",vListDureeBDD);
		assertEquals("La taille de la liste de durées est erronée.",9,vListDureeBDD.size());
		
		//Méthode getDuree(int dureeId)
		int dureeId=4;
		Duree vDureeBDD=getManagerFactory().getDureeManager().getDuree(dureeId);
		assertNotNull("Le bean durée retourné ne doit pas être nul.",vDureeBDD);
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link FormulaireContact}.
	 * @throws Exception
	 */
	@Test
	public void testSelectFormulaireContact() throws Exception {
		//Méthode getListFormulaireContact()
		List<FormulaireContact> vListFormulaireContactBDD = getManagerFactory().getFormulaireContactManager().getListFormulaireContact();
		assertNotNull("La liste de formulaires de contact ne doit pas être nulle.",vListFormulaireContactBDD);
		assertEquals("La taille de la liste de formulaires de contact est erronée.",6,vListFormulaireContactBDD.size());
	}
	
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Saison}.
	 * @throws Exception
	 */
	@Test
	public void testSelectSaison() throws Exception {
		//Méthode getListSaison()
		List<Saison> vListSaisonBDD = getManagerFactory().getSaisonManager().getListSaison();
		assertNotNull("La liste de saisons ne doit pas être nulle.",vListSaisonBDD);
		assertEquals("La taille de la liste de saisons est erronée.",11,vListSaisonBDD.size());
		
		//Méthode getSaison(int saisonId)
		int saisonId=11;
		Saison vSaisonBDD = getManagerFactory().getSaisonManager().getSaison(saisonId);
		assertNotNull("Le bean saison retourné ne doit pas être nul.",vSaisonBDD);
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link TypeActivite}.
	 * @throws Exception
	 */
	@Test
	public void testSelectTypeActivite() throws Exception {
		//Méthode getListTypeActivite()
		List<TypeActivite> vListTypeActiviteBDD=getManagerFactory().getTypeActiviteManager().getListTypeActivite();
		assertNotNull("La liste de type d'activités ne doit pas être nulle.",vListTypeActiviteBDD);
		assertEquals("La taille de la liste de type d'activités est erronée.",9,vListTypeActiviteBDD.size());
		
		//Méthode getTypeActivite(int typeActiviteId)
		int typeActiviteId = 3;
		TypeActivite vTypeActiviteBDD=getManagerFactory().getTypeActiviteManager().getTypeActivite(typeActiviteId);
		assertNotNull("Le bean type d'activités retourné ne doit pas être nul.",vTypeActiviteBDD);
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Utilisateur}.
	 * @throws Exception
	 */
	@Test
	public void testSelectUtilisateur() throws Exception {
		//Méthode getUtilisateur(int utilisateurId)
		int utilisateurId=1;
		Utilisateur vUtilisateurBDD=getManagerFactory().getUtilisateurManager().getUtilisateur(utilisateurId);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul.",vUtilisateurBDD);
		
		//Méthode getUtilisateur(String adresseMail, String motDePasse)
		String adresseMail = "andre.monnier@hotmail.fr";
		String motDePasse ="M@rt1R@778?";
		vUtilisateurBDD=getManagerFactory().getUtilisateurManager().getUtilisateur(adresseMail, motDePasse);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul.",vUtilisateurBDD);	
	}
	
	/**
	 * Méthode qui permet de tester la lecture de la base de données pour les beans de type {@link Ville}.
	 * @throws Exception
	 */
	@Test
	public void testSelectVille() throws Exception {
		//Méthode getListVille(int nbVille)
		int nbVille = -1;
		List<Ville> vListVilleBDD = getManagerFactory().getVilleManager().getListVille(nbVille);
		assertNotNull("La liste de villes ne doit pas être nulle.",vListVilleBDD);
		assertEquals("La taille de la liste de villes est erronée.",10,vListVilleBDD.size());
		
		nbVille = 5;
		vListVilleBDD = getManagerFactory().getVilleManager().getListVille(nbVille);
		assertNotNull("La liste de villes ne doit pas être nulle.",vListVilleBDD);
		assertEquals("La taille de la liste de villes est erronée.",5,vListVilleBDD.size());
		
		//Méthode getVille(int villeId)
		int villeId = 4;
		Ville vVilleBDD = getManagerFactory().getVilleManager().getVille(villeId);
		assertNotNull("Le bean ville retourné ne doit pas être nul.",vVilleBDD);
		
		//Méthode getListNomVille()
		List<String> vListNomVille = getManagerFactory().getVilleManager().getListNomVille();
		assertNotNull("La liste de nom de villes ne doit pas être nulle.",vListNomVille);
		assertEquals("La taille de la liste de nom de villes est erronée.",10,vListNomVille.size());
		
		//Méthode getListVilleRecherche(String nomRecherche)
		String nomRecherche="-LES-";
		vListVilleBDD = getManagerFactory().getVilleManager().getListVilleRecherche(nomRecherche);
		assertNotNull("La liste de villes ne doit pas être nulle.",vListVilleBDD);
		assertEquals("La taille de la liste de villes est erronée.",2,vListVilleBDD.size());
	}
	
	/**
	 * Méthode qui permet de tester l'ajout en base de données pour les beans de type {@link Photo}.
	 * @throws Exception
	 */
	@Test
	public void testInsertPhoto() throws Exception {
		//Méthode insertPhotoUtilisateur(String nomPhoto, int utilisateurId)
		String nomPhoto = "jsp/assets/images/utilisateur/utilisateur-4.jpg";
		int utilisateurId = 4;
		getManagerFactory().getPhotoManager().insertPhotoUtilisateur(nomPhoto, utilisateurId);
	}
	
	/**
	 * Méthode qui permet de tester l'ajout en base de données pour les beans de type {@link Utilisateur}.
	 * @throws Exception
	 */
	@Test
	public void testInsertUtilisateur() throws Exception {
		//Méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation)
		String civilite="Madame"; 
		String nom="Anderson";
		String prenom="Gillian"; 
		String pseudo ="AG";
		String adresseMail="g.anderson@gmail.com"; 
		String motDePasse="Azerty";
		String confirmationMotDePasse="Azerty"; 
		boolean conditionsUtilisation=true;
		getManagerFactory().getUtilisateurManager().insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
		Utilisateur vUtilisateurBDD = getManagerFactory().getUtilisateurManager().getUtilisateur(adresseMail, motDePasse);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul.",vUtilisateurBDD);
		assertEquals("Le nom de l'utilisateur est erroné.",nom,vUtilisateurBDD.getNom());
		assertEquals("La prénom de l'utilisateur est erroné.",prenom,vUtilisateurBDD.getPrenom());
	}
	
	
	/**
	 * Méthode qui permet de tester l'ajout en base de données pour les beans de type {@link Activite}.
	 * @throws Exception
	 */
	@Test
	public void testInsertActivite() throws Exception {
		
		//On définit le bean activité attendu.
		Activite vActiviteExpected= new Activite();
		vActiviteExpected.setNomActivite("Le Fabuleux Village des Flottins");
		vActiviteExpected.setDescription("Depuis 2007, la ville d'Evian toute entière se métamorphose au plein coeur de l'hiver, à la période des fêtes...");
		vActiviteExpected.setAdresse("Place Charles de Gaulle");
		vActiviteExpected.setLienHoraireOuverture("");
		
		Utilisateur vUtilisateurExpected = new Utilisateur();
		vUtilisateurExpected.setId(1);
		vActiviteExpected.setUtilisateur(vUtilisateurExpected);
		
		Ville vVilleExpected = new Ville();
		vVilleExpected.setId(5);
		vActiviteExpected.setVille(vVilleExpected);
		
		Duree vDuree = new Duree();
		vDuree.setId(9);
		vActiviteExpected.setDuree(vDuree);
		
		Saison vSaison = new Saison();
		vSaison.setId(4);
		vActiviteExpected.setSaison(vSaison);
		
		CoordonneeGPS vCoordonneeGPS = new CoordonneeGPS();
		vCoordonneeGPS.setLatitude(46.400800);
		vCoordonneeGPS.setLongitude(6.588610);
		vActiviteExpected.setCoordonnee(vCoordonneeGPS);
		
		Photo vPhotoActivite1 = new Photo();
		vPhotoActivite1.setNomPhoto("jsp/assets/images/evian-les-bains/evian-les-bains_le-fabuleux-village-des-flottins-1_2019-03-29.jpg");
		vPhotoActivite1.setProvenancePhoto("Personnelle");
		vPhotoActivite1.setTypePhoto("Activité photo principale");
		
		Photo vPhotoActivite2 = new Photo();
		vPhotoActivite2.setNomPhoto("jsp/assets/images/evian-les-bains/evian-les-bains_le-fabuleux-village-des-flottins-2_2019-03-29.jpg");
		vPhotoActivite2.setProvenancePhoto("Libre de droits");
		vPhotoActivite2.setTypePhoto("Activité photo secondaire");
		
		Photo vPhotoActivite3 = new Photo();
		vPhotoActivite3.setNomPhoto("jsp/assets/images/evian-les-bains/evian-les-bains_le-fabuleux-village-des-flottins-3_2019-03-29.jpg");
		vPhotoActivite3.setProvenancePhoto("https://www.flickr.com/photos/jomenager/31350098324/");
		vPhotoActivite3.setTypePhoto("Activité photo secondaire");
		
		List<Photo> vListPhotoActivite = new ArrayList<>();
		vListPhotoActivite.add(vPhotoActivite1);
		vListPhotoActivite.add(vPhotoActivite2);
		vListPhotoActivite.add(vPhotoActivite3);
		
		vActiviteExpected.getListPhotoActivite().addAll(vListPhotoActivite);
		
		TypeActivite vTypeActivite1 = new TypeActivite();
		vTypeActivite1.setId(1);
		
		TypeActivite vTypeActivite2 = new TypeActivite();
		vTypeActivite2.setId(2);
		
		List<TypeActivite> vListTypeActivite = new ArrayList<>();
		vListTypeActivite.add(vTypeActivite1);
		vListTypeActivite.add(vTypeActivite2);
		
		vActiviteExpected.getListTypeActivite().addAll(vListTypeActivite);
		
		getManagerFactory().getActiviteManager().ajoutActivite(vActiviteExpected);
		
		Activite vActiviteBDD = getManagerFactory().getActiviteManager().getActivite(vActiviteExpected.getId());
		assertNotNull("Le bean activité retourné ne doit pas être nul.",vActiviteBDD);
		assertEquals("Le nom de l'activité est erroné.",vActiviteExpected.getNomActivite(),vActiviteBDD.getNomActivite());
		assertEquals("La description de l'activité est erroné.",vActiviteExpected.getDescription(),vActiviteBDD.getDescription());
		assertEquals("L'utilisateur est erroné.",vActiviteExpected.getUtilisateur().getId(),vActiviteBDD.getUtilisateur().getId());
	}
	
	/**
	 *  Méthode qui permet de tester l'ajout en base de données pour les beans de type {@link Avis}.
	 * @throws Exception
	 */
	@Test
	public void testInsertAvis() throws Exception {
		String commentaire="Commentaire de l'utilisateur";
		String appreciation="Excellent";
		int utilisateurId=1;
		int activiteId=1;
		
		getManagerFactory().getAvisManager().insertAvis(commentaire, appreciation, utilisateurId, activiteId);
		
		List<Avis> vListAvisBDD = getManagerFactory().getAvisManager().getListAvisUtilisateur(utilisateurId, "ECDM");
		assertNotNull("Le liste d'avis retournée ne doit pas être nulle.",vListAvisBDD);
		assertEquals("La taille de la liste d'avis retournée est erronée.",1,vListAvisBDD.size());
		assertEquals("Le commentaire de l'avis est erroné.",commentaire,vListAvisBDD.get(0).getCommentaire());
		assertEquals("L'appréciation de l'avis est erroné.",appreciation,vListAvisBDD.get(0).getAppreciation());
	}
	
	/**
	 * Méthode qui permet de tester l'ajout en base de données pour les beans de type {@link FormulaireContact}.
	 * @throws Exception
	 */
	@Test
	public void testInsertFormulaireContact() throws Exception {
		String nomNa="Anderson";
		String adresseMailNa="gillian.anderson@gmail.com";
		String objet="Proposer une amélioration";
		String message="Amélioration à proposer.";
		int utilisateurId=-1;
		getManagerFactory().getFormulaireContactManager().insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
		
		List<FormulaireContact> vListFormulaireContactBDD = getManagerFactory().getFormulaireContactManager().getListFormulaireContact();
		assertNotNull("La liste de formulaires de contact ne doit pas être nulle.",vListFormulaireContactBDD);
		assertEquals("La taille de la liste de formulaires de contact est erronée.",7,vListFormulaireContactBDD.size());
		
		nomNa="Martin D";
		adresseMailNa="andre.monnier@hotmail.fr";
		objet="Proposer une amélioration";
		message="Amélioration à proposer.";
		utilisateurId=2;
		
		getManagerFactory().getFormulaireContactManager().insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
		
		vListFormulaireContactBDD = getManagerFactory().getFormulaireContactManager().getListFormulaireContact();
		assertNotNull("La liste de formulaires de contact ne doit pas être nulle.",vListFormulaireContactBDD);
		assertEquals("La taille de la liste de formulaires de contact est erronée.",8,vListFormulaireContactBDD.size());
	}
	
	/**
	 * Méthode qui permet de tester la mise à jour de la base de données pour les beans de type {@link Utilisateur}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateUtilisateur() throws Exception {
		//Méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays)
		int id = 1; 
		String civilite="Monsieur" ;
		String nom="Monnier" ;
		String prenom="André" ;
		String pseudo="André M.";
		String adresseMail="andre_monnier@yahoo.fr";
		String telephone="06-74-13-53-09";
		
		GregorianCalendar vGregCalDateNaissance =new GregorianCalendar(1982,4,4);
		XMLGregorianCalendar vXGCDateDateNaissance = null;
		try {
			vXGCDateDateNaissance = DatatypeFactory.newInstance().newXMLGregorianCalendar(vGregCalDateNaissance);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		String adresse="666 Chemin de sur la ville";
		String codePostal="74340";
		String ville="Samoëns"; 
		String pays ="France";
		
		getManagerFactory().getUtilisateurManager().updateCoordUtilisateur(id, civilite, nom, prenom, pseudo, adresseMail, telephone, vXGCDateDateNaissance, adresse, 
				codePostal, ville, pays);
		Utilisateur vUtilisateurBDD = getManagerFactory().getUtilisateurManager().getUtilisateur(id);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul.",vUtilisateurBDD);
		assertEquals("Le téléphone de l'utilisateur est erroné.",telephone,vUtilisateurBDD.getTelephone());
		assertEquals("La date de naissance de l'utilisateur est erronée.",vXGCDateDateNaissance,vUtilisateurBDD.getDateNaissance());
		assertEquals("L'adresse de l'utilisateur est erronée.",adresse,vUtilisateurBDD.getAdresse());
		assertEquals("Le code postal de l'utilisateur est erroné.",codePostal,vUtilisateurBDD.getCodePostal());
		assertEquals("La ville de l'utilisateur est erronée.",ville,vUtilisateurBDD.getVille());
		
		//Méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp)
		id=2; 
		String actuelMdp ="M@rt1R@778?";
		String nouveauMdp="MdpTest";
		String confirmationNouveauMdp="MdpTest";
		getManagerFactory().getUtilisateurManager().updateMdpUtilisateur(id, actuelMdp, nouveauMdp, confirmationNouveauMdp);
		vUtilisateurBDD = getManagerFactory().getUtilisateurManager().getUtilisateur(id);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul.",vUtilisateurBDD);
		
		//Méthode updateParametresUtilisateur(int id, boolean envoiMailInformatif)
		id=3;
		boolean envoiMailInformatif=false;
		getManagerFactory().getUtilisateurManager().updateParametresUtilisateur(id, envoiMailInformatif);
		vUtilisateurBDD = getManagerFactory().getUtilisateurManager().getUtilisateur(id);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul.",vUtilisateurBDD);
		assertEquals("La ville de l'utilisateur est erronée.",envoiMailInformatif,vUtilisateurBDD.isEnvoiMailInformatif());	
	}
	
	/**
	 * Méthode qui permet de tester la mise à jour de la base de données pour les beans de type {@link Activite}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateStatutActivite() throws Exception {
		int activiteId = 1; 
		int statutActiviteId = 2; 
		String dateAModifier = "DATE_MODERATION_ADMIN";
		
		getManagerFactory().getActiviteManager().updateStatutActivite(activiteId, statutActiviteId, dateAModifier);
		Activite vActiviteBDD = getManagerFactory().getActiviteManager().getActivite(activiteId);
		assertNotNull("Le bean activité retourné ne doit pas être nul.",vActiviteBDD);
		assertEquals("L'identifiant du statut de l'activité est erroné.",statutActiviteId,vActiviteBDD.getStatutActivite().getId());
		
		activiteId = 1; 
		statutActiviteId = 4; 
		dateAModifier = "DATE_MEL";
		getManagerFactory().getActiviteManager().updateStatutActivite(activiteId, statutActiviteId, dateAModifier);
		vActiviteBDD = getManagerFactory().getActiviteManager().getActivite(activiteId);
		assertNotNull("Le bean activité retourné ne doit pas être nul.",vActiviteBDD);
		assertEquals("L'identifiant du statut de l'activité est erroné.",statutActiviteId,vActiviteBDD.getStatutActivite().getId());
	}
	
	
	/**
	 * Méthode qui permet de tester la mise à jour de la base de données pour les beans de type {@link Avis}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateStatutAvis() throws Exception {
		int avisId=1;
		int statutAvisId = 4;
		int utilisateurId=2;
		getManagerFactory().getAvisManager().updateStatutAvis(avisId, statutAvisId);
		
		List<Avis> vListAvisBDD = getManagerFactory().getAvisManager().getListAvisUtilisateur(utilisateurId, "MEL");
		assertNotNull("Le liste d'avis retournée ne doit pas être nulle.",vListAvisBDD);
		assertEquals("La taille de la liste d'avis retournée est erronée.",9,vListAvisBDD.size());
	}
	
	/**
	 * Méthode qui permet de tester la suppression de la base de données pour les beans de type {@link Activite}.
	 * Une fois l'activité supprimée, on ne doit plus la retrouver en base de données.
	 * On s'attend donc à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void testDeleteActivite() throws Exception {
		//On sélectionne une activité qui n'a pas d'avis.
		int activiteId = 25;
		getManagerFactory().getActiviteManager().deleteActivite(activiteId);
		getManagerFactory().getActiviteManager().getActivite(activiteId);
	}
	
	/**
	 * Méthode qui permet de tester la suppression de la base de données pour les beans de type {@link Avis}
	 * @throws Exception
	 */
	@Test
	public void testDeleteAvis() throws Exception {
		int avisId = 1;
		getManagerFactory().getAvisManager().deleteAvis(avisId);
		
		List<Avis> vListAvisBDD = getManagerFactory().getAvisManager().getListAvisUtilisateur(-1, "MEL");
		assertNotNull("Le liste d'avis retournée ne doit pas être nulle.",vListAvisBDD);
		assertEquals("La taille de la liste d'avis retournée est erronée.",19,vListAvisBDD.size());
	}
}