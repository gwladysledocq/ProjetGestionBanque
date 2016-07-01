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
	 * M�thode pour ajouter un groupe � la base de donn�es
	 * Entr�e : Groupe
	 * Sortie : Groupe
	 */
	public Groupe addGroupe(Groupe g);
	
	/*
	 * M�tthode pour joindre un employ� � un groupe
	 * Entr�e : idGroupe, idEmploye
	 * Sortie : Employe
	 */
	public Employe addEmployeToGroupe(Long idGroupe, Long idEmploye);
	
	/*
	 * M�tthode pour r�cuperer les groupes enregistr�s dans la base de donn�es
	 * Entr�e : 
	 * Sortie : liste de Groupe
	 */
	public Collection<Groupe> getGroupes();
	
	/*
	 * M�tthode pour r�cuperer les employ�s d'un groupe enregistr�s dans la base de donn�es
	 * Entr�e : idGroupe
	 * Sortie : liste d'Employ�s
	 */
	public Collection<Employe> getEmployes(Long idGroupe);
	
}
