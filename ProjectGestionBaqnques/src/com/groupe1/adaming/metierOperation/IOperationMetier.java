package com.groupe1.adaming.metierOperation;

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
	 * Entrée : Operation
	 * Sortie : Operation
	 */
	public Operation addOperation(Operation o);
	
	/*
	 * Méthode pour réaliser un retrait depuis un compte
	 * Entrée : Retrait, idCompte
	 * Sortie : Retrait
	 */
	public Retrait retrait(Retrait r, Long idCompte);
	
	/*
	 * Méthode pour réaliser un versement vers un compte
	 * Entrée : Versement, idCompte
	 * Sortie : Versement
	 */
	public Verssement versement(Verssement v, Long idCompte);
	
	/*
	 * Méthode pour réaliser un virement entre 2 comptes
	 * Entrée : Retrait, idCompteDebite, Versement, idCompteCredite
	 * Sortie : Versement
	 */
	public Retrait virement(Retrait r, Long idCompteDebite, Verssement v, Long idCompteCredite);
	
}
