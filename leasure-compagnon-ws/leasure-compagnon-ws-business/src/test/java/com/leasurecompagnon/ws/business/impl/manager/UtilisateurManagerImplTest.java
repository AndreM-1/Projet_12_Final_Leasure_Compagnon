package com.leasurecompagnon.ws.business.impl.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.leasurecompagnon.ws.business.contract.manager.UtilisateurManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.UtilisateurDao;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link UtilisateurManagerImpl}
 * @author André Monnier
 *
 */
public class UtilisateurManagerImplTest {
	
	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static UtilisateurDao utilisateurDaoMock=mock(UtilisateurDao.class);
	private UtilisateurManager utilisateurManagerImpl=new UtilisateurManagerImpl();
	private static String civilite;
	private static String nom;
	private static String prenom;
	private static String pseudo;
	private static String adresseMail;
	private static String motDePasse;
	private static String confirmationMotDePasse;
	private static boolean conditionsUtilisation;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getUtilisateurDao()).thenReturn(utilisateurDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier le bean utilisateur attendu.
	 * @return L'utilisateur attendu.
	 */
	public static Utilisateur createUtilisateurExpected() {
		Utilisateur vUtilisateur=new Utilisateur();
		vUtilisateur.setId(2);
		vUtilisateur.setCivilite("Monsieur");
		vUtilisateur.setNom("Durand");
		vUtilisateur.setPrenom("Martin");
		vUtilisateur.setPseudo("Martin D");
		vUtilisateur.setAdresseMail("andre.monnier@hotmail.fr");
		vUtilisateur.setSalt("nwhMGwRv5k1HTLIGjmrdyQsoBSYmcb");
		vUtilisateur.setMotDePasseSecurise("96MJCGUsI6yzRM53HIugWIF/s1E5ykiQ+GIe1BXi8XM=");
		
		//On instancie un GregorianCalendar avec la date actuelle.
		GregorianCalendar vGregCalDateInscription=new GregorianCalendar();
		XMLGregorianCalendar vXGCDateInscription = null;
		try {
			vXGCDateInscription = DatatypeFactory.newInstance().newXMLGregorianCalendar(vGregCalDateInscription);
			vUtilisateur.setDateInscription(vXGCDateInscription);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		vUtilisateur.setTelephone("06-31-47-36-82");
		
		//On instancie un GregorianCalendar avec la date souhaitée.
		GregorianCalendar vGregCalDateNaissance=new GregorianCalendar(1982,9,3);
		XMLGregorianCalendar vXGCDateNaissance = null;
		try {
			vXGCDateNaissance = DatatypeFactory.newInstance().newXMLGregorianCalendar(vGregCalDateNaissance);
			vUtilisateur.setDateNaissance(vXGCDateNaissance);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	
		vUtilisateur.setAdresse("1 AVENUE BERTHOLLET");
		vUtilisateur.setCodePostal("74000");
		vUtilisateur.setVille("ANNECY");
		vUtilisateur.setPays("France");
		vUtilisateur.setEnvoiMailInformatif(true);
		vUtilisateur.setAdministrateur(false);
		return vUtilisateur;	
	}
	
	public static void initializeAttribute() {
		civilite ="Madame";
		nom ="Anderson";
		prenom="Gillian";
		pseudo ="AG";
		adresseMail="a.gillan@gmail.com";
		motDePasse="VeritéAilleurs";
		confirmationMotDePasse="VeritéAilleurs";
		conditionsUtilisation=true;
	}
	
	/**
	 * Test de la méthode public Utilisateur getUtilisateur(int utilisateurId) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getUtilisateurCase1() throws Exception {
		int utilisateurId=2;
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenReturn(createUtilisateurExpected());
		Utilisateur utilisateur=utilisateurManagerImpl.getUtilisateur(utilisateurId);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul",utilisateur);
	}
	
	/**
	 * Test de la méthode public Utilisateur getUtilisateur(int utilisateurId) dans le cas où aucun utilisateur
	 * ne correspond à l'identifiant demandé. On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getUtilisateurCase2() throws Exception {
		int utilisateurId=5;
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenThrow(new NotFoundException("Aucun utilisateur ne correspond à l'id demandé"));
		utilisateurManagerImpl.getUtilisateur(utilisateurId);
	}
	
	/**
	 * Test de la méthode public Utilisateur getUtilisateur(String adresseMail, String motDePasse) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getUtilisateurAMCase1() throws Exception {
		String adresseMail="andre.monnier@hotmail.fr";
		String motDePasse="M@rt1R@778?";
		when(utilisateurDaoMock.getUtilisateur(adresseMail)).thenReturn(createUtilisateurExpected());
		Utilisateur utilisateur=utilisateurManagerImpl.getUtilisateur(adresseMail, motDePasse);
		assertNotNull("Le bean utilisateur retourné ne doit pas être nul",utilisateur);
	}
	
	/**
	 * Test de la méthode public Utilisateur getUtilisateur(String adresseMail, String motDePasse) dans le cas où aucun utilisateur
	 * ne correspond à l'adresse mail demandée. On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getUtilisateurAMCase2() throws Exception {
		String adresseMail="a.test@gmail.com";
		String motDePasse="M@rt1R@778?";
		when(utilisateurDaoMock.getUtilisateur(adresseMail)).thenThrow(new NotFoundException("Aucun utilisateur ne correspond à l'adresse mail demandée."));
		utilisateurManagerImpl.getUtilisateur(adresseMail, motDePasse);
	}
	
	/**
	 * Test de la méthode public Utilisateur getUtilisateur(String adresseMail, String motDePasse) dans le cas où l'adresse mail est correcte
	 * mais pas le mot de passe. On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getUtilisateurAMCase3() throws Exception {
		String adresseMail="andre.monnier@hotmail.fr";
		String motDePasse="Azerty?";
		when(utilisateurDaoMock.getUtilisateur(adresseMail)).thenReturn(createUtilisateurExpected());
		utilisateurManagerImpl.getUtilisateur(adresseMail, motDePasse);	
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void insertUtilisateurCase1() throws Exception {
		initializeAttribute();
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où les conditions d'utilisation
	 * ne sont pas acceptées. On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase2() throws Exception {
		initializeAttribute();
		conditionsUtilisation=false;
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le champ civilite est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase3() throws Exception {
		initializeAttribute();
		String civilite =" ";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le champ nom est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase4() throws Exception {
		initializeAttribute();
		String nom ="   ";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le champ prénom est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase5() throws Exception {
		initializeAttribute();
		String prenom="";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le champ pseudo est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase6() throws Exception {
		initializeAttribute();
		String pseudo ="AAAAAAAAAAAAAAAAAAAAA";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le champ adresse mail est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase7() throws Exception {
		initializeAttribute();
		String adresseMail="";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le format de l'adresse mail est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase8() throws Exception {
		initializeAttribute();
		String adresseMail="a.gillan@gmailcom";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le champ mot de passe est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase9() throws Exception {
		initializeAttribute();
		String motDePasse="";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où le champ confirmation mot de passe est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase10() throws Exception {
		initializeAttribute();
		String confirmationMotDePasse="";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	/**
	 * Test de la méthode insertUtilisateur(String civilite, String nom, ... , boolean conditionsUtilisation) dans le cas où les champs mot de passe
	 * et confirmation mot de passe ne sont pas égaux.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertUtilisateurCase11() throws Exception {
		initializeAttribute();
		String motDePasse="VeritéAilleurs";
		String confirmationMotDePasse="TrueOutThere";
		utilisateurManagerImpl.insertUtilisateur(civilite, nom, prenom, pseudo, adresseMail, motDePasse, confirmationMotDePasse, conditionsUtilisation);
	}
	
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void updateCoordUtilisateurCase1() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ civilite est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase2() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setCivilite(" ");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ nom est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase3() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setNom("");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ prénom est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase4() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setPrenom("");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ pseudo est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase5() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setPseudo(" ");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ adresse mail est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase6() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setAdresseMail(" ");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le format de l'adresse mail est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase7() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setAdresseMail("andre.monnier@hotmailfr");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ téléphone est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase8() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setTelephone("00-31-47-36-82");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ adresse est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase9() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setAdresse("AdresseFictiveAdresseFictiveAdresseFictiveAdresseFictiveAdresseFictiveAdresseFictiveAdresseFictiveAdresseFictive"
				+ "AdresseFictiveAdresseFictiveAdresseFictive");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ code postal est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase10() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setCodePostal("74340743401");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ ville est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase11() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setVille("VilleFictiveVilleFictiveVilleFictiveVilleFictiveVilleFictiveVilleFictiveVilleFictiveVilleFictiveVilleFictive"
				+ "VilleFictiveVilleFictiveVilleFictiveVilleFictiveVilleFictive");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateCoordUtilisateur(int id, String civilite, String nom, ... , String pays) dans le cas où le champ pays est incorrect.
	 * On s'attend à lever une exception de type {@link FunctionalException}
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateCoordUtilisateurCase12() throws Exception {
		Utilisateur vUtilisateurExpected=createUtilisateurExpected();
		vUtilisateurExpected.setPays("PaysFictifPaysFictifPaysFictifPaysFictifPaysFictifPaysFictifPaysFictifPaysFictifPaysFictifPaysFictifPaysFictif"
				+ "PaysFictifPaysFictifPaysFictifPaysFictifPaysFictifPaysFictif");
		utilisateurManagerImpl.updateCoordUtilisateur(vUtilisateurExpected.getId(), vUtilisateurExpected.getCivilite(), vUtilisateurExpected.getNom(), 
				vUtilisateurExpected.getPrenom(), vUtilisateurExpected.getPseudo(), vUtilisateurExpected.getAdresseMail(), vUtilisateurExpected.getTelephone(),
				vUtilisateurExpected.getDateNaissance(), vUtilisateurExpected.getAdresse(), vUtilisateurExpected.getCodePostal(), vUtilisateurExpected.getVille(), 
				vUtilisateurExpected.getPays());
	}
	
	/**
	 * Test de la méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void updateMdpUtilisateurCase1() throws Exception {
		int utilisateurId=2;
		String actuelMdp="M@rt1R@778?";
		String nouveauMdp="Azerty?";
		String confirmationNouveauMdp="Azerty?";
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenReturn(createUtilisateurExpected());
		utilisateurManagerImpl.updateMdpUtilisateur(utilisateurId, actuelMdp, nouveauMdp, confirmationNouveauMdp);
	}
	
	/**
	 * Test de la méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp) dans le cas où aucun utilisateur
	 * ne correspond à l'identifiant demandé. On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void updateMdpUtilisateurCase2() throws Exception {
		int utilisateurId=5;
		String actuelMdp="M@rt1R@778?";
		String nouveauMdp="Azerty?";
		String confirmationNouveauMdp="Azerty?";
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenThrow(new NotFoundException("Aucun utilisateur ne correspond à l'id demandé"));
		utilisateurManagerImpl.updateMdpUtilisateur(utilisateurId, actuelMdp, nouveauMdp, confirmationNouveauMdp);
	}
	
	/**
	 * Test de la méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp) dans le cas où le champ mot de passe actuel
	 * est incorrect. On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateMdpUtilisateurCase3() throws Exception {
		int utilisateurId=2;
		String actuelMdp="M@rt1R@7781F?";
		String nouveauMdp="Azerty?";
		String confirmationNouveauMdp="Azerty?";
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenReturn(createUtilisateurExpected());
		utilisateurManagerImpl.updateMdpUtilisateur(utilisateurId, actuelMdp, nouveauMdp, confirmationNouveauMdp);
	}
	
	/**
	 * Test de la méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp) dans le cas où le champ nouveau mot de passe
	 * est incorrect. On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateMdpUtilisateurCase4() throws Exception {
		int utilisateurId=2;
		String actuelMdp="M@rt1R@778?";
		String nouveauMdp="  ";
		String confirmationNouveauMdp="Azerty?";
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenReturn(createUtilisateurExpected());
		utilisateurManagerImpl.updateMdpUtilisateur(utilisateurId, actuelMdp, nouveauMdp, confirmationNouveauMdp);
	}
	
	/**
	 * Test de la méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp) dans le cas où le champ confirmation nouveau 
	 * mot de passe est incorrect. On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateMdpUtilisateurCase5() throws Exception {
		int utilisateurId=2;
		String actuelMdp="M@rt1R@778?";
		String nouveauMdp="Azerty?";
		String confirmationNouveauMdp="";
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenReturn(createUtilisateurExpected());
		utilisateurManagerImpl.updateMdpUtilisateur(utilisateurId, actuelMdp, nouveauMdp, confirmationNouveauMdp);
	}
	
	/**
	 * Test de la méthode updateMdpUtilisateur(int id, String actuelMdp, String nouveauMdp, String confirmationNouveauMdp) dans le cas où les champs nouveau mot de passe
	 * et confirmation nouveau mot de passe ne sont pas égaux. On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void updateMdpUtilisateurCase6() throws Exception {
		int utilisateurId=2;
		String actuelMdp="M@rt1R@778?";
		String nouveauMdp="Azerty?";
		String confirmationNouveauMdp="AzertyUiop";
		when(utilisateurDaoMock.getUtilisateur(utilisateurId)).thenReturn(createUtilisateurExpected());
		utilisateurManagerImpl.updateMdpUtilisateur(utilisateurId, actuelMdp, nouveauMdp, confirmationNouveauMdp);
	}
	
	/**
	 * Test de la méthode updateParametresUtilisateur(int id, boolean envoiMailInformatif) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void updateParametresUtilisateurCase1() throws Exception {
		int utilisateurId=2;
		boolean envoiMailInformatif =true;
		utilisateurManagerImpl.updateParametresUtilisateur(utilisateurId, envoiMailInformatif);
	}
	
	/**
	 * Test de la méthode getListUtilisateur(String optEnvoiMailInformatif) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListUtilisateurCase1() throws Exception {
		List<Utilisateur> vListUtilisateurExpected = new ArrayList<>();
		vListUtilisateurExpected.add(createUtilisateurExpected());
		String optEnvoiMailInformatif="OPT_ACTIVE";
		when(utilisateurDaoMock.getListUtilisateur(optEnvoiMailInformatif)).thenReturn(vListUtilisateurExpected);
		List<Utilisateur> vListUtilisateur = utilisateurManagerImpl.getListUtilisateur(optEnvoiMailInformatif);
		assertNotNull("La liste d'utilisateurs retournée ne doit pas être nulle.",vListUtilisateur);
		assertEquals("La taille de la liste d'utilisateurs est erronée.",1,vListUtilisateur.size());
	}
	
	/**
	 * Test de la méthode getListUtilisateur(String optEnvoiMailInformatif) dans le cas où aucun utilisateur n'a la valeur d'option
	 * d'envoi mail informatif demandé. On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListUtilisateurCase2() throws Exception {
		String optEnvoiMailInformatif="OPT_DESACTIVE";
		when(utilisateurDaoMock.getListUtilisateur(optEnvoiMailInformatif))
		.thenThrow(new NotFoundException("Aucun utilisateur avec la valeur d'option d'envoi mail informatif demandé."));
		utilisateurManagerImpl.getListUtilisateur(optEnvoiMailInformatif);
	}
}