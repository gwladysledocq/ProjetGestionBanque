package com.groupe1.adaming.daoEmploye;
/*
 * Classe: IEmployeDao
 * Package: com.groupe1.adaming.daoEmploye
 * Description: Interface
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 30/06/2016
 * 
 */

import java.util.Collection;

import com.groupe1.adaming.entities.Employe;

public interface IEmployeDao {
	
	public Employe addEmploye(Employe employe);
	public Collection<Employe> getListEmploye();

}
