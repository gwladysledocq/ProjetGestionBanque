package com.groupe1.adaming.daoCompte;
/*
 * Classe: ICompteDao
 * Package: com.groupe1.adaming.daoCompte
 * Description: Interface
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 30/06/2016
 * 
 */

import java.util.Collection;

import com.groupe1.adaming.entities.Compte;

public interface ICompteDao {
	
	public Compte addCompte(Compte compte, Long idClient, Long idEmploye);
	public Compte deleteCompte(Long idCompte);
	public Compte getCompte (Long idCompte);
	public Collection<Compte> getComptesParEmploye(Compte compte, Long idEmploye);
	public Compte updateCompte(Compte compte);

}
