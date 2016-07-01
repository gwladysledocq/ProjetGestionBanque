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
	
	public Compte addCompte(Compte compte, Long idClient, Long idEmploye);
	public Compte deleteCompte(Long idCompte);
	public Collection<Compte> getComptesParClient(Compte compte, Long idClient);
	public Collection<Compte> getComptesParEmploye(Compte compte, Long idEmploye);
	public Compte updateCompte(Compte compte);

}
