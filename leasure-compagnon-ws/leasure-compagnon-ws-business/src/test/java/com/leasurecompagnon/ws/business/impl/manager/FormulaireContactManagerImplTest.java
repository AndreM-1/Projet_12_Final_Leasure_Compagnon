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

import com.leasurecompagnon.ws.business.contract.manager.FormulaireContactManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.FormulaireContactDao;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link FormulaireContactManagerImpl}
 * @author André Monnier
 *
 */
public class FormulaireContactManagerImplTest {
	
	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static FormulaireContactDao formulaireContactDaoMock=mock(FormulaireContactDao.class);
	private FormulaireContactManager formulaireContactManagerImpl = new FormulaireContactManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getFormulaireContactDao()).thenReturn(formulaireContactDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier une liste de formulaires de contact attendue.
	 * @return La liste de formulaires de contact attendue.
	 */
	public static List<FormulaireContact> createListFormulaireContactExpected() {
		FormulaireContact vFormulaireContact = new FormulaireContact();
		vFormulaireContact.setId(2);
		vFormulaireContact.setNomNa("Anderson");
		vFormulaireContact.setAdresseMailNa("gillian.anderson@gmail.com");
		vFormulaireContact.setObjet("Proposer une amélioration");
		vFormulaireContact.setMessage("Le site n'est disponible qu'en français pour le moment. Avez-vous prévu de traduire le site en plusieurs langues ?");
		
		//On instancie un GregorianCalendar avec la date souhaitée pour le champs date_form_contact.
		GregorianCalendar vGregCalDateFormContact=new GregorianCalendar(2019,2,1,10,0,15);
		XMLGregorianCalendar vXGCDateFormContact = null;
		try {
			vXGCDateFormContact = DatatypeFactory.newInstance().newXMLGregorianCalendar(vGregCalDateFormContact);
			vFormulaireContact.setDateFormContact(vXGCDateFormContact);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		List<FormulaireContact> vListFormulaireContact= new ArrayList<>();
		vListFormulaireContact.add(vFormulaireContact);
		return vListFormulaireContact;
	}
	
	/**
	 * Test de la méthode getListFormulaireContact() dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListFormulaireContactCase1() throws Exception {
		when(formulaireContactDaoMock.getListFormulaireContact()).thenReturn(createListFormulaireContactExpected());
		List<FormulaireContact> listFormulaireContact = formulaireContactManagerImpl.getListFormulaireContact();
		assertNotNull("La liste de formulaires de contact retournée ne doit pas être nulle.",listFormulaireContact);
		assertEquals("La taille de la liste de formulaires de contact est erronée.",1,listFormulaireContact .size());
	}
	
	/**
	 * Test de la méthode getListFormulaireContact() dans le cas où une erreur inattendue est survenue.
	 * On s'attend à lever une exception de type {@link TechnicalException}.
	 * @throws Exception
	 */
	@Test(expected = TechnicalException.class)
	public void getListFormulaireContactCase2() throws Exception {
		when(formulaireContactDaoMock.getListFormulaireContact()).thenThrow(new TechnicalException("Erreur technique lors de l'accès en base de données."));
		formulaireContactManagerImpl.getListFormulaireContact();
	}
	
	/**
	 * Test de la méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId) dans le cas nominal.
	 * On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test
	public void insertFormulaireContactCase1() throws Exception {
		String nomNa="Anderson";
		String adresseMailNa="gillian.anderson@gmail.com";
		String objet="Proposer une amélioration";
		String message="Amélioration à proposer.";
		int utilisateurId=-1;
		formulaireContactManagerImpl.insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
	}
	
	/**
	 * Test de la méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId) dans le cas où le champ nomNa
	 * n'a pas été renseigné correctement. On s'attend à lever une exception de type {@link FunctionalException}. 
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertFormulaireContactCase2() throws Exception {
		String nomNa="   ";
		String adresseMailNa="gillian.anderson@gmail.com";
		String objet="Proposer une amélioration";
		String message="Amélioration à proposer.";
		int utilisateurId=-1;
		formulaireContactManagerImpl.insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
	}
	
	/**
	 * Test de la méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId) dans le cas où le champ adresseMailNa
	 * n'a pas été renseigné correctement. On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertFormulaireContactCase3() throws Exception {
		String nomNa="Anderson";
		String adresseMailNa="";
		String objet="Proposer une amélioration";
		String message="Amélioration à proposer.";
		int utilisateurId=-1;
		formulaireContactManagerImpl.insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
	}
	
	/**
	 * Test de la méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId) dans le cas où aucun objet n'a été sélectionné.
	 * On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertFormulaireContactCase4() throws Exception {
		String nomNa="Anderson";
		String adresseMailNa="gillian.anderson@gmail.com";
		String objet="-1";
		String message="Amélioration à proposer.";
		int utilisateurId=-1;
		formulaireContactManagerImpl.insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
	}
	
	/**
	 * Test de la méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId) dans le cas où le champ objet
	 * n'a pas été renseigné correctement. On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertFormulaireContactCase5() throws Exception {
		String nomNa="Anderson";
		String adresseMailNa="gillian.anderson@gmail.com";
		String objet=" ";
		String message="Amélioration à proposer.";
		int utilisateurId=-1;
		formulaireContactManagerImpl.insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
	}
	
	/**
	 * Test de la méthode insertFormulaireContact(String nomNa, String adresseMailNa, String objet, String message, int utilisateurId) dans le cas où le champ message
	 * n'a pas été renseigné correctement. On s'attend à lever une exception de type {@link FunctionalException}.
	 * @throws Exception
	 */
	@Test(expected = FunctionalException.class)
	public void insertFormulaireContactCase6() throws Exception {
		String nomNa="Anderson";
		String adresseMailNa="gillian.anderson@gmail.com";
		String objet="Proposer une amélioration";
		String message="";
		int utilisateurId=-1;
		formulaireContactManagerImpl.insertFormulaireContact(nomNa, adresseMailNa, objet, message, utilisateurId);
	}
}