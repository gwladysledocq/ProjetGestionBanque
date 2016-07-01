package com.groupe1.adaming.metierGroupe;

import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.groupe1.adaming.daoGroupe.IGroupeDao;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;

/*
 * Nom : GroupeMetierImp
 * Package : com.groupe1.adaming.metierGroupe
 * Description : classe implémente IGroupeMetier
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

public class GroupeMetierImp implements IGroupeMetier{

	/*Attributs*/
	
	private IGroupeDao dao;
	Logger logger = Logger.getLogger("GroupeMetierImp");
	
	/*Setter*/
	
	public void setDao(IGroupeDao dao) {
		this.dao = dao;
		logger.info("<----------IGroupeDao a bien été injecté---------->");
	}
	
	/*Redefiniton méthode de l'interface*/
	
	@Override
	public Groupe addGroupe(Groupe g) {
		return dao.addGroupe(g);
	}

	@Override
	public Employe addEmployeToGroupe(Long idGroupe, Long idEmploye) {
		return dao.addEmployeToGroupe(idGroupe, idEmploye);
	}

	@Override
	public Collection<Groupe> getGroupes() {
		return dao.getGroupes();
	}

	@Override
	public Collection<Employe> getEmployes(Long idGroupe) {
		return dao.getEmployes(idGroupe);
	}

}
