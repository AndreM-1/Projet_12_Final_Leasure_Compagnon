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

import com.leasurecompagnon.ws.business.contract.manager.AvisManager;
import com.leasurecompagnon.ws.consumer.contract.DaoFactory;
import com.leasurecompagnon.ws.consumer.contract.dao.AvisDao;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.bean.catalogue.StatutActiviteAvis;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Classe permettant d'effectuer des tests unitaires sur la classe {@link AvisManagerImpl}
 * @author André Monnier
 *
 */
public class AvisManagerImplTest {
	
	private static DaoFactory daoFactoryMock=mock(DaoFactory.class);
	private static PlatformTransactionManager platformTransactionManagerMock=mock(PlatformTransactionManager.class);
	private static TransactionStatus transactionStatusMock=mock(TransactionStatus.class);
	private static DefaultTransactionDefinition defaultTransactionDefinitionMock=mock(DefaultTransactionDefinition.class);
	private static AvisDao avisDaoMock=mock(AvisDao.class);
	private AvisManager avisManagerImpl = new AvisManagerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractManager.setDaoFactory(daoFactoryMock);
		AbstractManager.setPlatformTransactionManager(platformTransactionManagerMock);
		when(platformTransactionManagerMock.getTransaction(defaultTransactionDefinitionMock)).thenReturn(transactionStatusMock);
		when(daoFactoryMock.getAvisDao()).thenReturn(avisDaoMock); 
	}
	
	/**
	 * Méthode permettant d'instancier une liste d'avis attendue.
	 * @return La liste d'avis attendue.
	 */
	public static List<Avis> createListAvisExpected() {
		
		Utilisateur vUtilisateur= new Utilisateur();
		vUtilisateur.setId(2);
		
		StatutActiviteAvis vStatutActiviteAvis = new StatutActiviteAvis();
		vStatutActiviteAvis.setId(4);
		
		Avis vAvis = new Avis();
		vAvis.setId(1);
		vAvis.setCommentaire("Le lac d'Annecy est très propre et ses contours sont bien aménagés.");
		vAvis.setAppreciation("Excellent");
		
		//On instancie un GregorianCalendar avec la date souhaitée pour le champs date_poste_avis.
		GregorianCalendar vGregCalDatePosteAvis=new GregorianCalendar(2019,1,28,7,30,0);
		XMLGregorianCalendar vXGCDatePosteAvis = null;
		try {
			vXGCDatePosteAvis = DatatypeFactory.newInstance().newXMLGregorianCalendar(vGregCalDatePosteAvis);
			vAvis.setDatePosteAvis(vXGCDatePosteAvis);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		//On instancie un GregorianCalendar avec la date souhaitée pour le champs date_moderation_admin_avis.
		GregorianCalendar vGregCalDateModerationAdminAvis=new GregorianCalendar(2019,2,2,10,0,0);
		XMLGregorianCalendar vXGCDateModerationAdminAvis = null;
		try {
			vXGCDateModerationAdminAvis = DatatypeFactory.newInstance().newXMLGregorianCalendar(vGregCalDateModerationAdminAvis);
			vAvis.setDateModerationAdminAvis(vXGCDateModerationAdminAvis);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		//On instancie un GregorianCalendar avec la date souhaitée pour le champs date_mise_en_ligne_avis.
		GregorianCalendar vGregCalDateMiseEnLigneAvis=new GregorianCalendar(2019,2,2,10,0,0);
		XMLGregorianCalendar vXGCDateMiseEnLigneAvis = null;
		try {
			vXGCDateMiseEnLigneAvis = DatatypeFactory.newInstance().newXMLGregorianCalendar(vGregCalDateMiseEnLigneAvis);
			vAvis.setDateMiseEnLigneAvis(vXGCDateMiseEnLigneAvis);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	
		vAvis.setUtilisateur(vUtilisateur);
		vAvis.setStatutAvis(vStatutActiviteAvis);
		
		List<Avis> vListAvis= new ArrayList<>();
		vListAvis.add(vAvis);
		
		return vListAvis;
	}
	
	/**
	 * Test de la méthode getListAvisUtilisateur(int utilisateurId, String statutAvis) dans le cas nominal.
	 * @throws Exception
	 */
	@Test
	public void getListAvisUtilisateurCase1() throws Exception {
		int utilisateurId=2;
		String statutAvis="MEL";
		when(avisDaoMock.getListAvisUtilisateur(utilisateurId, statutAvis)).thenReturn(createListAvisExpected());
		List<Avis> listAvis = avisManagerImpl.getListAvisUtilisateur(utilisateurId, statutAvis);
		assertNotNull("La liste d'avis retournée ne doit pas être nulle.",listAvis);
		assertEquals("La taille de la liste d'avis est erronée.",1,listAvis.size());
	}
	
	/**
	 * Test de la méthode getListAvisUtilisateur(int utilisateurId, String statutAvis) dans le cas où aucun avis n'a le statut souhaité pour l'utilisateur demandé.
	 * On s'attend à lever une exception de type {@link NotFoundException}.
	 * @throws Exception
	 */
	@Test(expected = NotFoundException.class)
	public void getListAvisUtilisateurCase2() throws Exception {
		int utilisateurId=2;
		String statutAvis="ECDM";
		when(avisDaoMock.getListAvisUtilisateur(utilisateurId, statutAvis)).thenThrow(new NotFoundException("Aucun avis avec le statut souhaité pour "
				+ "l'utilisateur demandé ou aucun avis posté par l'utilisateur"));
		avisManagerImpl.getListAvisUtilisateur(utilisateurId, statutAvis);
	}
}
