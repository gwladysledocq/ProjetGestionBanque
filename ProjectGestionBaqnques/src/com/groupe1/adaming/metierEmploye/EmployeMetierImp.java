package com.groupe1.adaming.metierEmploye;

import java.util.Collection;
import java.util.logging.Logger;

import com.groupe1.adaming.daoEmploye.IEmployeDao;
import com.groupe1.adaming.entities.Employe;
/*
 * Classe: EmployeMetierImp
 * Package: com.groupe1.adaming.metierCompte
 * Description: Implementation de l'interface IEmployeMetier
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 31/06/2016
 * 
 */

public class EmployeMetierImp implements IEmployeMetier{
	
	//Attributs//
		private IEmployeDao dao;
		//Logger//
		Logger log = Logger.getLogger("CompteMetierImp");
		
		
		//Setter//
		public void setDao(IEmployeDao dao) {
			this.dao = dao;
			log.info("<----------daoEmploye injectée-------->");
		}

		
		@Override
		public Employe addEmploye(Employe employe) {
			return dao.addEmploye(employe);
		}

		@Override
		public Collection<Employe> getListEmploye() {
			return dao.getListEmploye();
		}


}
