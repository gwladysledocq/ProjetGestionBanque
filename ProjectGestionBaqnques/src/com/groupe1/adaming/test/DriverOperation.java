package com.groupe1.adaming.test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.daoClient.ClientDaoImp;
import com.groupe1.adaming.daoClient.IClientDao;
import com.groupe1.adaming.daoCompte.CompteDaoImp;
import com.groupe1.adaming.daoCompte.ICompteDao;
import com.groupe1.adaming.daoEmploye.EmployeDaoImp;
import com.groupe1.adaming.daoEmploye.IEmployeDao;
import com.groupe1.adaming.daoOperation.IOperationDao;
import com.groupe1.adaming.daoOperation.OperationDaoImp;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.CompteCourant;
import com.groupe1.adaming.entities.Retrait;
import com.groupe1.adaming.entities.Verssement;
import com.groupe1.adaming.metierClient.IClientMetier;
import com.groupe1.adaming.metierGroupe.IGroupeMetier;
import com.groupe1.adaming.metierOperation.IOperationMetier;
import com.groupe1.adaming.metierOperation.OperationMetierImp;

public class DriverOperation {

	private static IOperationMetier metier;
	private static IClientMetier metierClient;
	private static ClassPathXmlApplicationContext applicationContext;
	
	public static void main(String[] args) {

		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metier = (IOperationMetier) applicationContext.getBean("metierOperation");
		metierClient = (IClientMetier) applicationContext.getBean("metierClient");
		
		
//		daoCli.addClient(new Client("A", "a", "adr1"));
//		daoCli.addClient(new Client("B", "b", "adr2"));
//		daoCli.addClient(new Client("C", "c", "adr3"));
//		daoCli.addClient(new Client("D", "d", "adr4"));
//		daoCli.addClient(new Client("E", "e", "adr5"));
		
//		daoComp.addCompte(new CompteCourant(1000, new Date(), -500), 2L, 5L);
//		daoComp.addCompte(new CompteCourant(8000, new Date(), -100), 1L, 8L);
//		daoComp.addCompte(new CompteCourant(200, new Date(), -50), 5L, 7L);
//		daoComp.addCompte(new CompteCourant(5000, new Date(), 0), 3L, 2L);
//		daoComp.addCompte(new CompteCourant(200, new Date(), -500), 4L, 3L);
		
//		dao.addOperation(new Retrait(new Date()), 5L, 1L);
//		dao.addOperation(new Verssement(new Date()), 2L, 2L);
		
//		metier.retrait(1L, 1050);
//		metier.versement(4L, 100);
		
//		metier.virement(1L, 4L, 10);
		
//		metier.addOperation(new Retrait(new Date()), 5L, 1L);
		
	}

}
