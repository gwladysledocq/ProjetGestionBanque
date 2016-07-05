package com.groupe1.adaming.metierCompte;

import java.util.Collection;

import com.groupe1.adaming.entities.Compte;
/*
 * Classe: ICompteMetier
 * Package: com.groupe1.adaming.metierCompte
 * Description: Interface
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 31/06/2016
 * 
 */

public interface ICompteMetier {
	
	public Compte addCompte(Compte compte, Long idClient, Long idEmploye, Long idBanque);
	public Compte deleteCompte(Long idCompte);
	public Compte getCompte (Long idCompte);
	public Compte updateCompte(Compte compte);

}