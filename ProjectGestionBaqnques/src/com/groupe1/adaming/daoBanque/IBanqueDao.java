package com.groupe1.adaming.daoBanque;
/*Class: IBanqueDao
 * Interface DAO Banque
 * Package: com.groupe1.adaming.daoBanque
 * Author: Philippe
 * Version: 1.0.1
 * Date: 07/07/16
 */
import java.util.Collection;
import java.util.List;

import com.groupe1.adaming.entities.Banque;

public interface IBanqueDao {
	/* methodes implementees dans BanqueDaoImp */
	public Banque addBanque (Banque banque);
	public Collection<Banque> getBanques();
	public Collection<Banque> getBanquesById(Long idBanque);
	public Banque getBanqueById(Long idBanque);

}
