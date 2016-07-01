package com.groupe1.adaming.daoOperation;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.entities.Operation;

/*
 * Nom : OperationDaoImp
 * Package : com.groupe1.adaming.daoOperation
 * Description : classe implemente IOperationDao
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

public class OperationDaoImp implements IOperationDao {

	/*Attributs*/
	
	Logger logger = Logger.getLogger("OperationDaoImp");
	SessionFactory sf = Singleton.getSf();
	
	/*Redéfinition des méthodes de l'interface*/
	
	@Override
	public Operation addOperation(Operation o) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(o);
		ss.getTransaction().commit();
		ss.close();
		logger.info("L'operation " + o + " a bien été ajouté.");
		return o;
	}

}
