package com.groupe1.adaming.metierOperation;

import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Operation;
import com.groupe1.adaming.entities.Retrait;
import com.groupe1.adaming.entities.Verssement;

/*
 * Nom : IOperationMetier
 * Package : com.groupe1.adaming.metierOperation
 * Description : interface 
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

public interface IOperationMetier {

	/*
	 * Méthode pour ajouter une opération à la base de données
	 * Entrée : Operation, Compte, Employe
	 * Sortie : Operation
	 */
	public Operation addOperation(Operation o, Long idCompte, Long idEmploye);
	
	/*
	 * Méthode pour réaliser un retrait depuis un compte
	 * Entrée : Retrait, montant
	 * Sortie : Retrait
	 */
	public Retrait retrait(Long idRetrait, double montant);
	
	/*
	 * Méthode pour réaliser un versement vers un compte
	 * Entrée : Versement, montant
	 * Sortie : Versement
	 */
	public Verssement versement(Long idVersement, double montant);
	
	/*
	 * Méthode pour réaliser un virement entre 2 comptes
	 * Entrée : Retrait, Versement, montant
	 * Sortie : Versement
	 */
	public Retrait virement(Long idRetrait, Long idVersement, double montant);
	
}
