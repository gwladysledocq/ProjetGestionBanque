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

import java.util.Collection;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.entities.Employe;

public class EmployeDaoImp implements IEmployeDao {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Logger log = Logger.getLogger("EmployeDaoImp");
	//SessionFactory sf = Singleton.getSf();

	@Override
	public Employe addEmploye(Employe employe) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(employe);
		ss.getTransaction().commit();ss.close();
		log.info("L'employe"+employe.getNomEmploye()+" a bien �t� enregistr�");
		return employe;
	}

	@Override
	public Collection<Employe> getListEmploye() {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Query query = ss.createQuery("from Employe e");
		ss.getTransaction().commit();
		log.info("Il existe"+query.list().size()+" employ�s");
		return query.list();
	}

}
