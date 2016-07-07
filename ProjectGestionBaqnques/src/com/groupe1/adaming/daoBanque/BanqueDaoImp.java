package com.groupe1.adaming.daoBanque;

/*Class: BanqueDaoImp
 * Classe qui implemente IBanqueDao
 * Package: com.groupe1.adaming.daoBanque
 * Author: Philippe
 * Version: 1.0.1
 * Date: 07/07/16
 */
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.entities.Banque;

public class BanqueDaoImp implements IBanqueDao {

	/* import du singleton */
	SessionFactory sf = Singleton.getSf();

	/* creation du logger */
	Logger logger = Logger.getLogger("BanqueDaoImp");

	/*
	 * methode qui ajoute une banque sachant les clients, les comptes et les
	 * employes 
	 * Entree : Banque, Collection<Long>, Collection<Long>, Collection<Long> 
	 * Sortie : Banque
	 */
	@Override
	public Banque addBanque(Banque banque) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(banque);
		ss.getTransaction().commit();
		ss.close();
		logger.info("addBanque (nomAgence) : " + banque.getNomAgence());
		return banque;
	}

	/*
	 * methode qui recupere la liste des banques 
	 * Entree : void 
	 * Sortie : Collection<Banque>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Banque> getBanques() {

		Session ss = sf.openSession();
		ss.beginTransaction();
		Query req = ss.createQuery("from Banque");
		Collection<Banque> tabBanque = req.list();
		ss.getTransaction().commit();
		for (Banque b : tabBanque) {
			logger.info("getBanques (nomAgence) : " + b.getNomAgence());
		}
		return tabBanque;
	}

	/* methode qui recupere une liste de banques en fonction d un id
	 * Entree : Long
	 * Sortie : Collection<Banque>
	 */
	@Override
	public Collection<Banque> getBanquesById(Long idBanque) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Query req = ss.createQuery("from Banque b where b.idBanque=:x");
		req.setParameter("x",idBanque);
		Collection<Banque> tabBanque = req.list();
		ss.getTransaction().commit();
		for (Banque b : tabBanque) {
			logger.info("getBanquesById : " + b.getNomAgence());
		}
		return tabBanque;
	}

	/* methode qui recupere une banque en fonction d un id
	 * Entree : Long
	 * Sortie Banque
	 */
	@Override
	public Banque getBanqueById(Long idBanque) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Query req = ss.createQuery("from Banque b where b.idBanque=:x");
		req.setParameter("x",idBanque);
		Banque ban = (Banque) req.list().get(0);
		ss.getTransaction().commit();
		logger.info("getBanque : " + ban.getNomAgence());
		return ban;
	}

}
