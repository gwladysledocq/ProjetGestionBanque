package com.groupe1.adaming.metierBanque;
/*Class: BanqueMetierImp
 * Classe qui implemente IBanqueMetier
 * Package: com.groupe1.adaming.metierBanque
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
import java.util.Collection;

import com.groupe1.adaming.daoBanque.BanqueDaoImp;
import com.groupe1.adaming.daoBanque.IBanqueDao;
import com.groupe1.adaming.entities.Banque;

public class BanqueMetierImp implements IBanqueMetier{

	/* creation de la DAO Banque */
	IBanqueDao daoBanque = new BanqueDaoImp();
	
	/* methode qui appelle la methode addBanque (Banque banque) de IBanqueDao
	   Entree : Banque
	   Sortie : Banque
	   */
	@Override
	public Banque addBanque(Banque banque) {
		return daoBanque.addBanque(banque);
	}

	/* methode qui appelle la methode getBanques() de IBanqueDao
	   Entree : void
	   Sortie : Collection<Banque>
	*/
	@Override
	public Collection<Banque> getBanques() {
		return daoBanque.getBanques();
	}

}
