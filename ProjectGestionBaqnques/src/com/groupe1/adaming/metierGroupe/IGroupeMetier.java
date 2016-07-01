package com.groupe1.adaming.metierGroupe;

import java.util.Collection;

import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;

/*
 * Nom : IGroupeMetier
 * Package : com.groupe1.adaming.metierGroupe
 * Description : interface 
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

public interface IGroupeMetier {

	/*
	 * Méthode pour ajouter un groupe à la base de données
	 * Entrée : Groupe
	 * Sortie : Groupe
	 */
	public Groupe addGroupe(Groupe g);
	
	/*
	 * Métthode pour joindre un employé à un groupe
	 * Entrée : idGroupe, idEmploye
	 * Sortie : Employe
	 */
	public Employe addEmployeToGroupe(Long idGroupe, Long idEmploye);
	
	/*
	 * Métthode pour récuperer les groupes enregistrés dans la base de données
	 * Entrée : 
	 * Sortie : liste de Groupe
	 */
	public Collection<Groupe> getGroupes();
	
	/*
	 * Métthode pour récuperer les employés d'un groupe enregistrés dans la base de données
	 * Entrée : idGroupe
	 * Sortie : liste d'Employés
	 */
	public Collection<Employe> getEmployes(Long idGroupe);
	
}
