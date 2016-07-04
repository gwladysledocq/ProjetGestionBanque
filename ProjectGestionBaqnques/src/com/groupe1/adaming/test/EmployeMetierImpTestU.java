package com.groupe1.adaming.test;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.metierEmploye.IEmployeMetier;

public class EmployeMetierImpTestU {
	
	private static IEmployeMetier metier;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier = (IEmployeMetier) context.getBean("metierEmploye");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	

	@Test
	public void testAddEmploye() {
		Employe e = new Employe("Employe 11");
		metier.addEmploye(e);
		assertNotNull(e.getIdEmploye());
	}

	@Test
	public void testGetListEmploye() {
		Collection<Employe> tab = metier.getListEmploye();
		assertTrue(tab.size()>0);
	}

}
