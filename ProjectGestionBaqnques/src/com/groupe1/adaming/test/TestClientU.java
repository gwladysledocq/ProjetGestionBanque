package com.groupe1.adaming.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.metierClient.IClientMetier;

public class TestClientU {
	private static IClientMetier metier;
	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metier = (IClientMetier) applicationContext.getBean("metierClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		applicationContext.close();
	}

	@Test
	public void testAddClient() {
		Client cli = metier.addClient(new Client("nomA", "prenomA", "adrA"));
		assertNotNull(cli.getIdClient());
	}

	@Test
	public void testDeleteClient(){
		List<Client> tab1 = (List<Client>) metier.getClientParMC("");
		metier.deleteClient(3L);
		List<Client> tab2 = (List<Client>) metier.getClientParMC("");
		assertTrue(tab1.size()+1 == tab2.size());
			
	}
	
	@Test
	public void testUpdateClient(){
		Client temp = metier.addClient(new Client("nomB", "prenomB", "adrB"));
		temp.setNomClient("nomC");
		temp.setPrenomClient("prenomC");
		temp.setAdrClient("adrC");
		metier.updateClient(temp);
		assertTrue(temp.getNomClient() == "nomC" && temp.getPrenomClient() == "prenomC" && temp.getAdrClient() == "adrC");
	}
	
	@Test
	public void testGetComptes(){
		Client cli = metier.addClient(new Client("nomC","prenomC","adrC"));
		Collection<Compte> tabCompte = metier.getComptes(cli.getIdClient());
		assertNotNull(tabCompte);
	}
	
	@Test
	public void testGetClientParMC(){
		Collection<Client> tabClient = metier.getClientParMC("nom");
		assertNotNull(tabClient);
		
	}
}
