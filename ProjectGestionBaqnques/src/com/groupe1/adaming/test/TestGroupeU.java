package com.groupe1.adaming.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;
import com.groupe1.adaming.metierGroupe.IGroupeMetier;

public class TestGroupeU {

	private static IGroupeMetier metier;
	private static ClassPathXmlApplicationContext applicationContext;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metier = (IGroupeMetier) applicationContext.getBean("metierGroupe");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		applicationContext.close();
	}

	@Test
	public void testAddGroupe() {
		Groupe g = metier.addGroupe(new Groupe("Groupe25"));
		assertNotNull(g.getIdGroupe());
	}

	@Test
	public void testAddEmployeToGroupe() {
		Employe e = metier.addEmployeToGroupe(5L, 3L);
		List<Groupe> tabGroupe = (List<Groupe>) metier.getGroupes();
		Groupe g = tabGroupe.get(4);
		assertNotNull(g.getTabEmploye());
	}

	@Test
	public void testGetGroupes() {
		Collection<Groupe> tabGroupe = metier.getGroupes();
		assertNotNull(tabGroupe);
	}

	@Test
	public void testGetEmployes() {
		Collection<Employe> tabEmploye = metier.getEmployes(3L);
		assertNotNull(tabEmploye);
	}

}
