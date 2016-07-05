package com.groupe1.adaming.daoCompte;
/*
 * Classe: CompteDaoImp
 * Package: com.groupe1.adaming.daoCompte
 * Description: Implementation de l'interface ICompteDao
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

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.entities.Banque;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;

public class CompteDaoImp implements ICompteDao{
	
	Logger log = Logger.getLogger("CompteDaoImp");
	SessionFactory sf = Singleton.getSf();

	@Override
	public Compte addCompte(Compte compte, Long idClient, Long idEmploye, Long idBanque) {
		
		Session ss = sf.openSession();
		ss.beginTransaction();
		Client cl = ss.get(Client.class, idClient);
		Employe e = ss.get(Employe.class, idEmploye);
		Banque b = ss.get(Banque.class, idBanque);
		compte.setClient(cl);
		compte.setEmploye(e);
		compte.setBanque(b);
		Collection<Compte> tabCompte = cl.getTabCompte();
		tabCompte.add(compte);
		cl.setTabCompte(tabCompte);
		tabCompte = b.getTabCompte();
		tabCompte.add(compte);
		b.setTabCompte(tabCompte);
		ss.save(compte);
		ss.update(cl);
		ss.update(b);
		ss.getTransaction().commit();
		
		log.info("Le compte"+compte.getIdCompte()+"appartenant à "+cl.getNomClient()+" créé par "+e.getNomEmploye()+" a bien été enregistré");
		return compte;
	}

	@Override
	public Compte deleteCompte(Long idCompte) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = (Compte) ss.get(Compte.class, idCompte);
		ss.delete(c);
		ss.getTransaction().commit();ss.close();
		log.info("Le compte"+c.getIdCompte()+" a bien été suprimmé");
		return c;
	}


	@Override
	public Compte updateCompte(Compte compte) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.saveOrUpdate(compte);
		ss.getTransaction().commit();ss.close();
		log.info("Le client"+compte.getIdCompte()+" a bien été modifié");
		return compte;
	}

	

	@Override
	public Collection<Compte> getComptesParEmploye(Long idEmploye) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Employe e = (Employe) ss.get(Employe.class, idEmploye);
		Query query = ss.createQuery("from Compte c, Employe e where c.employe.idEmploye = e.idEmploye");
		ss.getTransaction().commit();
		log.info("Il existe "+query.list().size()+" comptes créés par l'employé "+e.getNomEmploye());
		return query.list();
		
	}

	@Override
	public Compte getCompte(Long idCompte) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = ss.get(Compte.class, idCompte);
		ss.getTransaction().commit();ss.close();
		log.info("Le Compte"+c.getIdCompte()+" a bien été recupéré");
		return c;
	}

}
