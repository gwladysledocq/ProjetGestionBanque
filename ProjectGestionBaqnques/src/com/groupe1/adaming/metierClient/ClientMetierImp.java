package com.groupe1.adaming.metierClient;

import java.util.Collection;

import com.groupe1.adaming.daoClient.ClientDaoImp;
import com.groupe1.adaming.daoClient.IClientDao;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;

/*Class: ClientMetierImp
 * Classe qui implemente IClientMetier
 * Package: com.groupe1.adaming.metierClient
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
public class ClientMetierImp implements IClientMetier{

	/* creation de la DAO Client */
	IClientDao daoClient = new ClientDaoImp();
	
	/* methode qui appelle la methode addClient (Client client) de IClientDao
	   Entree : Client
	   Sortie : Client
	   */
	@Override
	public Client addClient(Client client) {
		return daoClient.addClient(client);
	}

	/* methode qui appelle la methode deleteClient (Long idClient) de IClientDao
	   Entree : Long
	   Sortie : Client
	   */
	@Override
	public Client deleteClient(Long idClient) {
		return daoClient.deleteClient(idClient);
	}

	/* methode qui appelle la methode updateClient (Client client) de IClientDao
	   Entree : Long
	   Sortie : Client
	   */
	@Override
	public Client updateClient(Client client) {
		return daoClient.updateClient(client);
	}

	/* methode qui appelle la methode getComptes (Long idClient) de IClientDao
	   Entree : Long
	   Sortie : Collection<Compte>
	   */
	@Override
	public Collection<Compte> getComptes(Long idClient) {
		return daoClient.getComptes(idClient);
	}

	/* methode qui appelle la methode getClientParMC (String mc) de IClientDao
	   Entree : String
	   Sortie : Collection<Client>
	   */
	@Override
	public Collection<Client> getClientParMC(String mc) {
		return daoClient.getClientParMC(mc);
	}

}
