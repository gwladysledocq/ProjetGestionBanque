package com.groupe1.adaming.daoClient;
/*Class: ClientDaoImp
 * Classe qui implemente IClientDao
 * Package: com.groupe1.adaming.daoClient
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
import java.util.Collection;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.groupe1.adaming.Singleton.Singleton;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.exception.ExceptionAucunClientTrouve;
import com.groupe1.adaming.exception.ExceptionAucunCompteTrouveDepuisClient;

public class ClientDaoImp implements IClientDao{

	/* import du singleton */
	SessionFactory sf = Singleton.getSf();
	
	/* creation du logger */
	Logger logger = Logger.getLogger("BanqueDaoImp");
	
	/* methode qui ajoute un client
	   Entree : Client
	   Sortie : Client
	 */
	@Override
	public Client addClient(Client client) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(client);
		ss.getTransaction().commit();
		//ss.close();
		logger.info("addClient (nomClient) : "+client.getNomClient());
		return client;
	}

	/* methode qui supprime un client
	   Entree : Long
	   Sortie : Client
	 */
	@Override
	public Client deleteClient(Long idClient) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		Client cli = (Client) ss.get(Client.class, idClient);
		ss.delete(cli);
		ss.getTransaction().commit();
		//ss.close();
		logger.info("deleteClient (nomClient) : "+cli.getNomClient());
		return cli;
	}

	/* methode qui modifie un client
	   Entree : Client
	   Sortie : Client
	 */
	@Override
	public Client updateClient(Client client) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.update(client);
		ss.getTransaction().commit();
		//ss.close();
		logger.info("updateClient (nomClient) : "+client.getNomClient());
		return client;
	}

	/* methode qui recupere la liste des comptes en fonction d un id client
	   Entree : Long
	   Sortie : Collection<Compte>
	*/
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Compte> getComptes(Long idClient) {
		Collection<Compte> tabCompte = null;
		try {
			Session ss = sf.openSession();
			ss.beginTransaction();
			Query req = ss.createQuery("from Compte c where c.idClient = ?");
			req.setParameter(1, idClient);
			tabCompte = req.list();
			if(tabCompte.isEmpty()){ //si le tableau de comptes est vide, ExceptionAucunCompteTrouveDepuisClient
				throw new ExceptionAucunCompteTrouveDepuisClient("getComptes : Collection<Compte> vide");
			}
			ss.getTransaction().commit();
			for(Compte c : tabCompte){
				logger.info("getComptes (idClient = "+idClient+") (solde) : "+c.getSolde());
			}
		} catch (Exception e) {
			logger.warning(e.getMessage());
		}
		//ss.close();
		return tabCompte;
	}

	/* methode qui recupere la liste des clients en faonction d un mot cle
	   Entree : String
	   Sortie : Collection<Client>
	*/
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Client> getClientParMC(String mc) {
		Collection<Client> tabClient = null;
		try {
			Session ss = sf.openSession();
			ss.beginTransaction();
			Query req = ss.createQuery("from Compte c where c.nomClient like :mc");
			req.setParameter("mc","%"+mc+"%");
			tabClient = req.list();
			if(tabClient.isEmpty()){ //si le tableau de clients est vide, ExceptionAucunClientTrouve
				throw new ExceptionAucunClientTrouve("getClientParMC : Collection<Client> vide");
			}
			ss.getTransaction().commit();
			for(Client c : tabClient){
				logger.info("getClientParMC (mot cle = "+mc+") (nomClient) : "+c.getNomClient());
			}
		} catch (Exception e) {
			logger.warning(e.getMessage());
		}
		//ss.close();
		return tabClient;
	}

}
