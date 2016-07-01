package com.groupe1.adaming.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.daoEmploye.EmployeDaoImp;
import com.groupe1.adaming.daoEmploye.IEmployeDao;
import com.groupe1.adaming.daoGroupe.GroupeDaoImp;
import com.groupe1.adaming.daoGroupe.IGroupeDao;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;
import com.groupe1.adaming.metierGroupe.GroupeMetierImp;
import com.groupe1.adaming.metierGroupe.IGroupeMetier;

public class DriverGroupe {

	private static IGroupeMetier metier;
	private static ClassPathXmlApplicationContext applicationContext;
	
	public static void main(String[] args) {

		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metier = (IGroupeMetier) applicationContext.getBean("metierGroupe");
		
//		metier.addGroupe(new Groupe("groupe21"));
		
//		dao.addGroupe(new Groupe("groupe1"));
//		dao.addGroupe(new Groupe("groupe2"));
//		dao.addGroupe(new Groupe("groupe3"));
//		dao.addGroupe(new Groupe("groupe4"));
//		dao.addGroupe(new Groupe("groupe5"));
//		dao.addGroupe(new Groupe("groupe6"));
//		dao.addGroupe(new Groupe("groupe7"));
//		dao.addGroupe(new Groupe("groupe8"));
//		dao.addGroupe(new Groupe("groupe9"));
//		dao.addGroupe(new Groupe("groupe10"));
		
//		daoEmp.addEmploye(new Employe("Employe1"));
//		daoEmp.addEmploye(new Employe("Employe3"));
//		daoEmp.addEmploye(new Employe("Employe4"));
//		daoEmp.addEmploye(new Employe("Employe5"));
//		daoEmp.addEmploye(new Employe("Employe6"));
//		daoEmp.addEmploye(new Employe("Employe7"));
//		daoEmp.addEmploye(new Employe("Employe8"));
//		daoEmp.addEmploye(new Employe("Employe9"));
//		daoEmp.addEmploye(new Employe("Employe2"));
//		daoEmp.addEmploye(new Employe("Employe10"));
		
//		dao.addEmployeToGroupe(1L, 5L);
//		dao.addEmployeToGroupe(1L, 7L);
//		dao.addEmployeToGroupe(2L, 4L);
//		dao.addEmployeToGroupe(3L, 7L);
//		dao.addEmployeToGroupe(4L, 2L);
//		dao.addEmployeToGroupe(5L, 1L);
//		dao.addEmployeToGroupe(6L, 3L);
//		dao.addEmployeToGroupe(7L, 8L);
//		dao.addEmployeToGroupe(8L, 3L);
//		dao.addEmployeToGroupe(9L, 2L);
//		dao.addEmployeToGroupe(10L, 9L);
//		dao.addEmployeToGroupe(10L, 1L);
//		dao.addEmployeToGroupe(4L, 6L);
		
//		dao.getGroupes();
		
//		dao.getEmployes(2L);
		
	}

}
