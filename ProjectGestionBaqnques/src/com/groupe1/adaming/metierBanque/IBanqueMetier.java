package com.groupe1.adaming.metierBanque;
/*Class: IBanqueMetier
 * Interface Metier Banque
 * Package: com.groupe1.adaming.metierBanque
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
import java.util.Collection;

import com.groupe1.adaming.entities.Banque;

public interface IBanqueMetier {
	/* methodes implementees dans BanqueMetierImp */
	public Banque addBanque (Banque banque);
	public Collection<Banque> getBanques();
}
