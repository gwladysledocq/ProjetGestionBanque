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
	 * M�thode pour ajouter une op�ration � la base de donn�es
	 * Entr�e : Operation
	 * Sortie : Operation
	 */
	public Operation addOperation(Operation o);
	
	/*
	 * M�thode pour r�aliser un retrait depuis un compte
	 * Entr�e : Retrait, idCompte
	 * Sortie : Retrait
	 */
	public Retrait retrait(Retrait r, Long idCompte);
	
	/*
	 * M�thode pour r�aliser un versement vers un compte
	 * Entr�e : Versement, idCompte
	 * Sortie : Versement
	 */
	public Verssement versement(Verssement v, Long idCompte);
	
	/*
	 * M�thode pour r�aliser un virement entre 2 comptes
	 * Entr�e : Retrait, idCompteDebite, Versement, idCompteCredite
	 * Sortie : Versement
	 */
	public Retrait virement(Retrait r, Long idCompteDebite, Verssement v, Long idCompteCredite);
	
}
