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
	 * M�thode pour ajouter une op�ration � la base de donn�es
	 * Entr�e : Operation, Compte, Employe
	 * Sortie : Operation
	 */
	public Operation addOperation(Operation o, Long idCompte, Long idEmploye);
	
	/*
	 * M�thode pour r�aliser un retrait depuis un compte
	 * Entr�e : Retrait, montant
	 * Sortie : Retrait
	 */
	public Retrait retrait(Long idRetrait, double montant);
	
	/*
	 * M�thode pour r�aliser un versement vers un compte
	 * Entr�e : Versement, montant
	 * Sortie : Versement
	 */
	public Verssement versement(Long idVersement, double montant);
	
	/*
	 * M�thode pour r�aliser un virement entre 2 comptes
	 * Entr�e : Retrait, Versement, montant
	 * Sortie : Versement
	 */
	public Retrait virement(Long idRetrait, Long idVersement, double montant);
	
}
