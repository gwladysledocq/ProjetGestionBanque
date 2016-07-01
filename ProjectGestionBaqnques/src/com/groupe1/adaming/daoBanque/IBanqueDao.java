package com.groupe1.adaming.daoBanque;
/*Class: IBanqueDao
 * Interface DAO Banque
 * Package: com.groupe1.adaming.daoBanque
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
import java.util.Collection;

import com.groupe1.adaming.entities.Banque;

public interface IBanqueDao {
	/* methodes implementees dans BanqueDaoImp */
	public Banque addBanque (Banque banque);
	public Collection<Banque> getBanques();
}
