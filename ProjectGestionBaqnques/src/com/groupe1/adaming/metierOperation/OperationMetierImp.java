package com.groupe1.adaming.metierOperation;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.daoOperation.IOperationDao;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Operation;
import com.groupe1.adaming.entities.Retrait;
import com.groupe1.adaming.entities.Verssement;
import com.groupe1.adaming.exception.ExceptionMontantDifferent;
import com.groupe1.adaming.exception.ExceptionSoldeInsuffisant;

/*
 * Nom : OperationMetierImp
 * Package : com.groupe1.adaming.metierOperation
 * Description : classe implémente IOperationMetier
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

public class OperationMetierImp implements IOperationMetier{

	/*Attributs*/
	
	private IOperationDao dao;
	Logger logger = Logger.getLogger("OperationMetierImp");
	SessionFactory sf = Singleton.getSf();
	
	/*Setter*/
	
	public void setDao(IOperationDao dao) {
		this.dao = dao;
		logger.info("<----------IOperationDao a bien été injecté---------->");
	}
	
	/*Redefinition des méthodes de l'interface*/

	@Override
	public Operation addOperation(Operation o, Long idCompte, Long idEmploye) {
		return dao.addOperation(o, idCompte, idEmploye);
	}

	@Override
	public Retrait retrait(Long idRetrait, double montant) {
		Retrait r = null;
		try{
			Session ss = sf.openSession();
			ss.beginTransaction();
			r = ss.get(Retrait.class, idRetrait);
			if(r.getCompte().getSolde() - r.getCompte().getDecouvert() < montant){
				throw new ExceptionSoldeInsuffisant("Le solde n'est pas suffisant !");
			}
			r.getCompte().setSolde(r.getCompte().getSolde() - montant);
			ss.update(r.getCompte());
			ss.getTransaction().commit();
			ss.close();
			logger.info("Le retrait " + r + " du montant " + montant + " a bien été effectué.");
		}catch(ExceptionSoldeInsuffisant e){
			logger.warning(e.getMessage());
		}
		return r;
	}

	@Override
	public Verssement versement(Long idVersement, double montant) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Verssement v = ss.get(Verssement.class, idVersement);
		v.getCompte().setSolde(v.getCompte().getSolde() + montant);
		ss.update(v.getCompte());
		ss.getTransaction().commit();
		ss.close();
		logger.info("Le versement " + v + " du montant " + montant + " a bien été effectué.");		
		return v;
	}

	@Override
	public Retrait virement(Long idRetrait, Long idVersement, double montant) {
		Retrait r = null;
		try{
			Session ss = sf.openSession();
			ss.beginTransaction();
			r = ss.get(Retrait.class, idRetrait);
			if(r.getCompte().getSolde() - r.getCompte().getDecouvert() < montant){
				throw new ExceptionSoldeInsuffisant("Le solde n'est pas suffisant !");
			}
			Verssement v = ss.get(Verssement.class, idVersement);
			retrait(idRetrait, montant);
			versement(idVersement, montant);
			ss.getTransaction().commit();
			ss.close();
			logger.info("Le virement du montant " + montant + " a bien été effectué.");	
		}catch(ExceptionSoldeInsuffisant e){
			logger.warning(e.getMessage());
		}
		return r;
	}
	
}
