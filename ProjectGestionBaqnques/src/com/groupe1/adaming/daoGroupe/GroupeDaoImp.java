package com.groupe1.adaming.daoGroupe;

import java.util.Collection;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;

/*
 * Nom : GroupeDaoImp
 * Package : com.groupe1.adaming.daoGroupe
 * Description : classe qui implemente IGroupeDao 
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

public class GroupeDaoImp implements IGroupeDao {

	/*Attributs*/
	
	Logger logger = Logger.getLogger("GroupeDaoImp");
	SessionFactory sf = Singleton.getSf();
	
	/*Redéfinition des méthodes de l'interface*/

	@Override
	public Groupe addGroupe(Groupe g) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(g);
		ss.getTransaction().commit();
		ss.close();
		logger.info("Le groupe " + g + " a bien été ajouté.");
		return g;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employe addEmployeToGroupe(Long idGroupe, Long idEmploye) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Groupe g = (Groupe) ss.get(Groupe.class, idGroupe);
		Employe e = (Employe) ss.get(Employe.class, idEmploye);
		g.getTabEmploye().add(e);
		e.getTabGroupe().add(g);
		ss.update(g);
		ss.update(e);
		ss.getTransaction().commit();
		logger.info("L'employe " + e + " a bien été ajouté au groupe " + g);
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Groupe> getGroupes() {
		Collection<Groupe> tabGroupe;
		Session ss = sf.openSession();
		ss.beginTransaction();
		Query req = ss.createQuery("Select g from Groupe g");
		tabGroupe = req.list();
		ss.getTransaction().commit();
		ss.close();
		logger.info("Les groupes ont été récupérés :" + tabGroupe);
		return tabGroupe;
	}

	@Override
	public Collection<Employe> getEmployes(Long idGroupe) {
		Collection<Employe> tabEmploye;
		Session ss = sf.openSession();
		ss.beginTransaction();
		Groupe g = ss.get(Groupe.class, idGroupe);
		tabEmploye = g.getTabEmploye();
		ss.getTransaction().commit();
		for(Employe e : tabEmploye){
			logger.info("Les employés ont été récupérés : " + e.getNomEmploye());
		}
		return tabEmploye;
	}
	


}
