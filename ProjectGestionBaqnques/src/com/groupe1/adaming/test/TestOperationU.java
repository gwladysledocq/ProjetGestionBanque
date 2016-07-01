package com.groupe1.adaming.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Operation;
import com.groupe1.adaming.entities.Retrait;
import com.groupe1.adaming.metierCompte.ICompteMetier;
import com.groupe1.adaming.metierGroupe.IGroupeMetier;
import com.groupe1.adaming.metierOperation.IOperationMetier;

public class TestOperationU {

	private static IOperationMetier metier;
	private static ICompteMetier metierComp;
	private static ClassPathXmlApplicationContext applicationContext;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metier = (IOperationMetier) applicationContext.getBean("metierOperation");
		metierComp = (ICompteMetier) applicationContext.getBean("metierCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		applicationContext.close();
	}

	@Test
	public void testAddOperation() {
		Operation o = metier.addOperation(new Retrait(new Date()), 4L, 1L);
		assertNotNull(o.getIdOperation());
	}

	@Test
	public void testRetrait() {
		Compte c1 = metierComp.getCompte(5L);
		double solde1 = c1.getSolde();
		metier.retrait(5L, 10);
		Compte c2 = metierComp.getCompte(5L);
		double solde2 = c2.getSolde();
		assertTrue(solde1 == solde2 + 10);
	}

	@Test
	public void testVersement() {
		Compte c1 = metierComp.getCompte(2L);
		double solde1 = c1.getSolde();
		metier.versement(4L, 10);
		Compte c2 = metierComp.getCompte(2L);
		double solde2 = c2.getSolde();
		assertTrue(solde1 == solde2 - 10);
	}

	@Test
	public void testVirement() {
		Compte c1 = metierComp.getCompte(5L);
		double solde1 = c1.getSolde();
		Compte c2 = metierComp.getCompte(2L);
		double solde2 = c2.getSolde();
		metier.virement(5L, 4L, 10);
		Compte c3 = metierComp.getCompte(5L);
		double solde3 = c3.getSolde();
		Compte c4 = metierComp.getCompte(2L);
		double solde4 = c4.getSolde();
		assertTrue(solde1 == solde3 + 10 && solde2 == solde4 - 10);
	}

}
