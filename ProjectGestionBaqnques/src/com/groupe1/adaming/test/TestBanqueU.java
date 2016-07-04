package com.groupe1.adaming.test;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Banque;
import com.groupe1.adaming.entities.BanqueCic;
import com.groupe1.adaming.metierBanque.IBanqueMetier;

public class TestBanqueU {
	private static IBanqueMetier metier;
	private static ClassPathXmlApplicationContext applicationContext;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metier = (IBanqueMetier) applicationContext.getBean("metierBanque");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		applicationContext.close();
	}
	
	@Test
	public void testAddBanque() {
		Banque ban = metier.addBanque(new BanqueCic("nomAgenceA", "adresseA", "codePostalA"));
		assertNotNull(ban.getIdBanque());
	}
	
	@Test
	public void testGetBanques(){
		Collection<Banque> tabBanque = metier.getBanques();
		assertNotNull(tabBanque);
	}
}
