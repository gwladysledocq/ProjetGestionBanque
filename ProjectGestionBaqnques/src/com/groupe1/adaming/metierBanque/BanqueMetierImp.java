package com.groupe1.adaming.metierBanque;
/*Class: BanqueMetierImp
 * Classe qui implemente IBanqueMetier
 * Package: com.groupe1.adaming.metierBanque
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
import java.util.Collection;
import java.util.logging.Logger;

import com.groupe1.adaming.daoBanque.IBanqueDao;
import com.groupe1.adaming.entities.Banque;
import com.groupe1.adaming.entities.BanqueBnp;
import com.groupe1.adaming.entities.BanqueCic;
import com.groupe1.adaming.entities.BanqueLcl;

public class BanqueMetierImp implements IBanqueMetier{
	/* creation du logger */
	Logger logger = Logger.getLogger("BanqueDaoImp");

	/* creation de la DAO Banque */
	private IBanqueDao dao;
	
	/* setteur de daoBanque */
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
		logger.info("<-----------IBanqueDao a ete injectee ----------->");
	}

	/* methode qui appelle la methode addBanque (Banque banque) de IBanqueDao
	   Entree : Banque
	   Sortie : Banque
	   */
	@Override
	public Banque addBanque(Banque banque) {
		return dao.addBanque(banque);
	}

	/* methode qui appelle la methode getBanques() de IBanqueDao
	   Entree : void
	   Sortie : Collection<Banque>
	*/
	@Override
	public Collection<Banque> getBanques() {
		return dao.getBanques();
	}

	@Override
	public Collection<Banque> getBanquesById(Long idBanque) {
		return dao.getBanquesById(idBanque);
	}

	/*
	@Override
	public Banque addBanqueBnp(Banque banque) {
		// TODO Auto-generated method stub
		return dao.addBanqueBnp(new BanqueBnp());
	}

	@Override
	public Banque addBanqueLcl(Banque banque) {
		// TODO Auto-generated method stub
		return dao.addBanqueLcl(new BanqueLcl());
	}

	@Override
	public Banque addBanqueCic(Banque banque) {
		return dao.addBanqueCic(new BanqueCic());
	}
*/
}
