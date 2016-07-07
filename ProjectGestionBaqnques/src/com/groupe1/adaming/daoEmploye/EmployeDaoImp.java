package com.groupe1.adaming.daoEmploye;
/*
 * Classe: EmployeDaoImp
 * Package: com.groupe1.adaming.daoEmploye
 * Description: Implementation de l'interface IEmployeDao
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 30/06/2016
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.metierClient.ClientMetierImp;
import com.groupe1.adaming.metierClient.IClientMetier;

public class EmployeDaoImp implements IEmployeDao {
	
	Logger log = Logger.getLogger("EmployeDaoImp");
	SessionFactory sf = Singleton.getSf();
	
	private IClientMetier metierCl = new ClientMetierImp();

	@Override
	public Employe addEmploye(Employe employe) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(employe);
		ss.getTransaction().commit();ss.close();
		log.info("L'employe "+employe.getNomEmploye()+" a bien été enregistré");
		return employe;
	}

	@Override
	public Collection<Employe> getListEmploye() {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Query query = ss.createQuery("from Employe e");
		ss.getTransaction().commit();
		log.info("Il existe "+query.list().size()+" employés");
		return query.list();
	}
	
	@Override
	public Collection<Compte> getComptesParEmploye(Long idEmploye) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Employe e = ss.get(Employe.class, idEmploye);
		Query query = ss.createQuery("select c from Compte c where c.employe.idEmploye = :x");
		query.setParameter("x",idEmploye);
		@SuppressWarnings("unchecked")
		Collection<Compte> tabCompte = (Collection<Compte>) query.list();
		ss.getTransaction().commit();
		log.info("Il existe "+tabCompte.size()+" comptes créés par l'employé "+e.getNomEmploye());
		return tabCompte;
		
	}

}
