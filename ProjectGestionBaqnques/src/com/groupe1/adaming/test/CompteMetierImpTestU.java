package com.groupe1.adaming.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.CompteCourant;
import com.groupe1.adaming.entities.CompteEpargne;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.metierCompte.ICompteMetier;
import com.groupe1.adaming.metierEmploye.IEmployeMetier;



public class CompteMetierImpTestU {
	
	private static ICompteMetier metier;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier = (ICompteMetier) context.getBean("metierCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	/*@Test
	public void testAddCompte() {
		Compte c = new CompteEpargne(11000, new Date(), -500, 2.5);
		metier.addCompte(c, 6L, 8L, 3L);
		assertNotNull(c.getIdCompte());
	}
*/
	/*@Test
	public void testDeleteCompte() {
		Compte c =metier.getCompte(1L);
		metier.deleteCompte(1L);
		assertNotNull(c.getIdCompte());
	}*/

	

	/*@Test
	public void testUpdateCompte() {
		Compte c = metier.getCompte(2L);
		c.setSolde(15000);
		metier.updateCompte(c);
		Compte cc = metier.getCompte(2L);
		assertTrue(cc.getSolde()==(15000));
	}*/

	/*@Test
	public void testGetCompte() {
		Compte c = metier.getCompte(2L);
		assertTrue(c.getIdCompte()!=null);
	}*/

}
