package com.groupe1.adaming.metierOperation;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.daoOperation.IOperationDao;
import com.groupe1.adaming.entities.Compte;
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
	
	/*Redefiniton méthode de l'interface*/
	
	@Override
	public Operation addOperation(Operation o) {
		return dao.addOperation(o);
	}

	@Override
	public Retrait retrait(Retrait r, Long idCompte) {
		try{
			Session ss = sf.openSession();
			ss.beginTransaction();
			Compte c = (Compte) ss.get(Compte.class, idCompte);
			if(r.getMontant() > c.getSolde()){
				throw new ExceptionSoldeInsuffisant("Le solde est inssufisant");
			}
			c.setSolde(c.getSolde() - r.getMontant());
			ss.update(c);
			ss.getTransaction().commit();
			ss.close();
			logger.info("Le retrait : " + r + " depuis le compte " + c + " a bien été effectué.");
		}catch(ExceptionSoldeInsuffisant e){
			logger.warning(e.getMessage());
		}
		return r;
	}

	@Override
	public Verssement versement(Verssement v, Long idCompte) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Compte c = (Compte) ss.get(Compte.class, idCompte);
		c.setSolde(c.getSolde() + v.getMontant());
		ss.update(c);
		ss.getTransaction().commit();
		ss.close();
		logger.info("Le retrait : " + v + " depuis le compte " + c + " a bien été effectué.");
		return v;
	}

	@Override
	public Retrait virement(Retrait r, Long idCompteDebite, Verssement v, Long idCompteCredite) {
		try{
			if(r.getMontant() != v.getMontant()){
				throw new ExceptionMontantDifferent("Les montants sont différents !");
			}
		}catch(ExceptionMontantDifferent e){
			logger.warning(e.getMessage());
		}
		try{
			Session ss = sf.openSession();
			ss.beginTransaction();
			Compte cDebite = (Compte) ss.get(Compte.class, idCompteDebite);
			Compte cCredite = (Compte) ss.get(Compte.class, idCompteCredite);
			if(r.getMontant() > cDebite.getSolde()){
				throw new ExceptionSoldeInsuffisant("Le solde est inssufisant");
			}
			cDebite.setSolde(cDebite.getSolde() - r.getMontant());
			cCredite.setSolde(cCredite.getSolde() + v.getMontant());
			ss.update(cDebite);
			ss.update(cCredite);
			ss.getTransaction().commit();
			ss.close();
			logger.info("Le virement : " + r + ", " + v + " a bien été effectué.");
		}catch(ExceptionSoldeInsuffisant e){
			logger.warning(e.getMessage());
		}
		return r;
	}

}
