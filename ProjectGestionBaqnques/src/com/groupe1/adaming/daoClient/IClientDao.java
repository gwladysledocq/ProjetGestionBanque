package com.groupe1.adaming.daoClient;
/*Class: IClientDao
 * Interface DAO Client
 * Package: com.groupe1.adaming.daoClient
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
import java.util.Collection;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;

public interface IClientDao {
	/* methodes implementees dans ClientDaoImp */
	public Client addClient (Client client);
	public Client deleteClient (Long idClient);
	public Client updateClient (Client client);
	public Collection<Compte> getComptes (Long idClient);
	public Collection<Client> getClientParMC (String mc);
}
