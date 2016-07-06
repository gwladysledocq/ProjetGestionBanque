package com.groupe1.adaming.test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.BanqueBnp;
import com.groupe1.adaming.entities.BanqueCic;
import com.groupe1.adaming.entities.BanqueLcl;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.CompteCourant;
import com.groupe1.adaming.entities.CompteEpargne;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;
import com.groupe1.adaming.entities.Retrait;
import com.groupe1.adaming.entities.Verssement;
import com.groupe1.adaming.metierBanque.IBanqueMetier;
import com.groupe1.adaming.metierClient.IClientMetier;
import com.groupe1.adaming.metierCompte.ICompteMetier;
import com.groupe1.adaming.metierEmploye.IEmployeMetier;
import com.groupe1.adaming.metierGroupe.IGroupeMetier;
import com.groupe1.adaming.metierOperation.IOperationMetier;

public class DriverRemplissageBdd {

	private static IGroupeMetier metierGr;
	private static IEmployeMetier metierEmp;
	private static IClientMetier metierCl;
	private static ICompteMetier metierCo;
	private static IBanqueMetier metierBa;
	private static IOperationMetier metierOp;
	private static ClassPathXmlApplicationContext applicationContext;
	
	public static void main(String[] args) {
		
		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metierGr = (IGroupeMetier) applicationContext.getBean("metierGroupe");
		metierEmp = (IEmployeMetier) applicationContext.getBean("metierEmploye");
		metierCl = (IClientMetier) applicationContext.getBean("metierClient");
		metierCo = (ICompteMetier) applicationContext.getBean("metierCompte");
		metierBa = (IBanqueMetier) applicationContext.getBean("metierBanque");
		metierOp = (IOperationMetier) applicationContext.getBean("metierOperation");

//		metierBa.addBanque(new BanqueCic("CIC", "adrCIC", "codeCIC"));
//		metierBa.addBanque(new BanqueLcl("LCL", "adrLCL", "codeLCL"));
//		metierBa.addBanque(new BanqueBnp("BNP", "adrBNP", "codeBNP"));
//		
//		metierCl.addClient(new Client("nom1", "prenom1", "adr1"));
//		metierCl.addClient(new Client("nom2", "prenom2", "adr2"));
//		metierCl.addClient(new Client("nom3", "prenom3", "adr3"));
//		metierCl.addClient(new Client("nom4", "prenom4", "adr4"));
//		metierCl.addClient(new Client("nom5", "prenom5", "adr5"));
//		metierCl.addClient(new Client("nom6", "prenom6", "adr6"));
//		metierCl.addClient(new Client("nom7", "prenom7", "adr7"));
//		metierCl.addClient(new Client("nom8", "prenom8", "adr8"));
//		metierCl.addClient(new Client("nom9", "prenom9", "adr9"));
//		
//		metierEmp.addEmploye(new Employe("nomA"));
//		metierEmp.addEmploye(new Employe("nomB"));
//		metierEmp.addEmploye(new Employe("nomC"));
//		metierEmp.addEmploye(new Employe("nomD"));
//		metierEmp.addEmploye(new Employe("nomE"));
//		metierEmp.addEmploye(new Employe("nomF"));
//		metierEmp.addEmploye(new Employe("nomG"));
//		metierEmp.addEmploye(new Employe("nomH"));
//		metierEmp.addEmploye(new Employe("nomI"));
//		
//		metierCo.addCompte(new CompteCourant(15000, new Date(), -500), 3L, 8L, 1L);
//		metierCo.addCompte(new CompteCourant(100, new Date(), 0), 4L, 6L, 3L);
//		metierCo.addCompte(new CompteCourant(20, new Date(), -400), 9L, 2L, 1L);
//		metierCo.addCompte(new CompteCourant(1540, new Date(), -100), 7L, 6L, 2L);
//		metierCo.addCompte(new CompteCourant(1500, new Date(), -1000), 2L, 3L, 3L);
//		metierCo.addCompte(new CompteCourant(15000, new Date(), -500), 6L, 5L, 1L);
//		metierCo.addCompte(new CompteEpargne(15000, new Date(), -500, 0.2), 3L, 8L, 1L);
//		metierCo.addCompte(new CompteEpargne(100, new Date(), 0, 0.5), 4L, 6L, 3L);
//		metierCo.addCompte(new CompteEpargne(20, new Date(), -400, 0.1), 9L, 2L, 1L);
//		metierCo.addCompte(new CompteEpargne(1540, new Date(), -100, 0.02), 7L, 6L, 2L);
//		metierCo.addCompte(new CompteEpargne(1500, new Date(), -1000, 0.05), 2L, 3L, 3L);
//		metierCo.addCompte(new CompteEpargne(15000, new Date(), -500, 0), 6L, 5L, 1L);
//		
//		metierGr.addGroupe(new Groupe("g1"));
//		metierGr.addGroupe(new Groupe("g2"));
//		metierGr.addGroupe(new Groupe("g3"));
//		metierGr.addGroupe(new Groupe("g4"));
//		metierGr.addGroupe(new Groupe("g5"));
//		metierGr.addGroupe(new Groupe("g6"));
//		metierGr.addGroupe(new Groupe("g7"));
//		metierGr.addGroupe(new Groupe("g8"));
//		metierGr.addGroupe(new Groupe("g9"));
//		
//		metierOp.addOperation(new Retrait(new Date()), 2L, 3L);
//		metierOp.addOperation(new Retrait(new Date()), 8L, 5L);
//		metierOp.addOperation(new Retrait(new Date()), 2L, 7L);
//		metierOp.addOperation(new Retrait(new Date()), 6L, 3L);
//		metierOp.addOperation(new Retrait(new Date()), 7L, 3L);
//		metierOp.addOperation(new Verssement(new Date()), 2L, 3L);
//		metierOp.addOperation(new Verssement(new Date()), 8L, 5L);
//		metierOp.addOperation(new Verssement(new Date()), 2L, 7L);
//		metierOp.addOperation(new Verssement(new Date()), 6L, 3L);
//		metierOp.addOperation(new Verssement(new Date()), 7L, 3L);
		
		
	}

}
