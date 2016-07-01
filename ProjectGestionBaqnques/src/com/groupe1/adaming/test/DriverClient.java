
package com.groupe1.adaming.test;

import java.util.Collection;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.CompteEpargne;
import com.groupe1.adaming.metierClient.ClientMetierImp;
import com.groupe1.adaming.metierClient.IClientMetier;
import com.groupe1.adaming.metierCompte.ICompteMetier;

public class DriverClient {
	private static IClientMetier metier;
	
	private static ICompteMetier metier2;
	
	//private static ClassPathXmlApplicationContext applicationContext;
	
	public static void main(String[] args) {
		//applicationContext = new ClassPathXmlApplicationContext("app.xml");
		//metier = (IClientMetier) applicationContext.getBean("metierClient");
		
		metier = new ClientMetierImp();
//		Client cli1 = metier.addClient(new Client("nom1", "prenom1", "adr1"));
//		Client cli2 = metier.addClient(new Client("nom2", "prenom2", "adr2"));
//		Client cli3 = metier.addClient(new Client("nom3", "prenom3", "adr3"));
//		Client cli4 = metier.addClient(new Client("nom4", "prenom4", "adr4"));
//		Client cli5 = metier.addClient(new Client("nom5", "prenom5", "adr5"));
//		Client cli6 = metier.addClient(new Client("nom6", "prenom6", "adr6"));
//		Long id1 = cli1.getIdClient();
//		Client cli7 = metier.deleteClient(id1);
//		
//		Client cli8 = metier.addClient(new Client("nom8", "prenom8", "adr8"));
//		
//		
//		metier.updateClient(cli8);
//		
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<->?"+cli3);
//		
//		Compte compte1 = new CompteEpargne(10.5,new Date(),6.8,4.5);
//        
//		metier2.addCompte(compte1, 1L, null);
		
		Collection<Compte> tab = metier.getComptes(3L);

		
		
	}

}

