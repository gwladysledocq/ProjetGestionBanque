package com.groupe1.adaming.metierCompte;

import java.util.Collection;
import java.util.logging.Logger;

import com.groupe1.adaming.daoCompte.ICompteDao;
import com.groupe1.adaming.entities.Compte;
/*
 * Classe: CompteMetierImp
 * Package: com.groupe1.adaming.metierCompte
 * Description: Implementation de l'interface ICompteMetier
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 31/06/2016
 * 
 */

public class CompteMetierImp implements ICompteMetier{
	
	//Attributs//
    private ICompteDao dao;
    //Logger//
	Logger log = Logger.getLogger("CompteMetierImp");
	
	//Setter//
	public void setDao(ICompteDao dao) {
		this.dao = dao;
		log.info("<----------daoCompte injectée-------->");
	}
	
	
	

	@Override
	public Compte addCompte(Compte compte, Long idClient, Long idEmploye) {
		return dao.addCompte(compte, idClient, idEmploye);
	}

	@Override
	public Compte deleteCompte(Long idCompte) {
		return dao.deleteCompte(idCompte);
	}

	@Override
	public Collection<Compte> getComptesParClient(Compte compte, Long idClient) {
		return dao.getComptesParClient(compte, idClient);
	}

	@Override
	public Collection<Compte> getComptesParEmploye(Compte compte, Long idEmploye) {
		return dao.getComptesParEmploye(compte, idEmploye);
	}

	@Override
	public Compte updateCompte(Compte compte) {
		return dao.updateCompte(compte);
	}


}
