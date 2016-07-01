package com.groupe1.adaming.metierEmploye;

import java.util.Collection;

import com.groupe1.adaming.entities.Employe;
/*
 * Classe: IEmployeMetier
 * Package: com.groupe1.adaming.metierEmploye
 * Description: Interface
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 31/06/2016
 * 
 */

public interface IEmployeMetier {
	
	public Employe addEmploye(Employe employe);
	public Collection<Employe> getListEmploye();

}

