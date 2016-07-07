package com.groupe1.adaming.controller;
/*Class: ClientCtrl
 * Controlleur pour la page client.jsp
 * Package: com.groupe1.adaming.controller
 * Author: Philippe
 * Version: 1.0.0
 * Date: 06/07/16
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.metierClient.IClientMetier;
import com.groupe1.adaming.model.ClientModel;

@Controller
public class ClientCtrl {

	/* attributs */
	@Autowired
	private IClientMetier metier;

	/* methode pour afficher la page d accueil de client.jsp
	 * Entree : ClientModel, Model
	 * Sortie : String
	 */
	@RequestMapping(value = "/client")
	public String indexClient(ClientModel clientModel, Model model) {
		Collection<Client> tab = metier.getClientParMC("");
		clientModel.setTabClient(tab);
		model.addAttribute("AttributIndexClient", clientModel);
		return "client";
	}

	/* methode pour ajouter un client
	 * Entree : ClientModel, Model, String, STring, String
	 * Sortie : String
	 */
	@RequestMapping(value="/ajouterClient")
	public String addClient(ClientModel clientModel, Model model,
			@RequestParam("nomClient")   String nomClient,
			@RequestParam("prenomClient")   String prenomClient,
			@RequestParam("adrClient")   String adrClient){
		Client cli = new Client(nomClient, prenomClient, adrClient);
		metier.addClient(cli);
		Collection<Client> clients = metier.getClientParMC("");
		clientModel.setTabClient(clients);
		Collection<Compte> comptes = metier.getComptes(cli.getIdClient());
		clientModel.setTabCompte(comptes);
		model.addAttribute("AttributAddGroupe",clientModel);
		return "redirect:client";
	}

	/* methode pour afficher la liste des clients
	 * Entree : ClientModel, Model
	 * Sortie : String
	 */
	@RequestMapping(value = "/afficherClient")
	public String getClient(ClientModel clientModel, Model model) {
		Collection<Client> tab = metier.getClientParMC("");
		clientModel.setTabClient(tab);
		model.addAttribute("AttributAfficherClient", clientModel);
		return "client";
	}

	/* methode pour supprimer un client
	 * Entree : ClientModel, Model, String
	 * Sortie : String
	 */
	@RequestMapping(value = "/supprimerClient")
	public String deleteClient(ClientModel clientModel, Model model, @RequestParam("nomClient") String nomClient) {
		Collection<Client> tab = metier.getClientParMC("");
		Iterator<Client> it = tab.iterator();
		while(it.hasNext()){
			Client cl = it.next();
			if (cl.getNomClient().equals(nomClient)) {
				Client cli = metier.deleteClient(cl.getIdClient());
				clientModel.setClient(cli);
			}
		}
		model.addAttribute("AttributDeleteClient", clientModel);
		return "redirect:client";
	}

	/* methode pour updater un client
	 * Entree : ClientModel, Model, STring, String, String
	 * Sortie : String
	 */
	@RequestMapping(value = "/majerClient")
	public String updateClient(ClientModel clientModel, Model model) {
		//Collection<Client> tab = metier.getClientParMC("");
		//Collection<Client> tab = clientModel.getTabClient();
		List<Client> clientChoisi = (List<Client>) metier.getClientParMC(clientModel.getNomClientChoisi());
		Client cli = clientChoisi.get(0);
		
		/*
		Iterator<Client> it = tab.iterator();
		while(it.hasNext()){
			Client c = it.next();
			if (c.getNomClient().equals(ancienNomClient)) {
				cli = metier.updateClient(c);
			}
		}
		*/
		cli.setNomClient(clientModel.getNomClientUpdate());
		cli.setPrenomClient(clientModel.getPrenomClientUpdate());
		cli.setAdrClient(clientModel.getAdrClientUpdate());
		Client cli2 = metier.updateClient(cli);
		clientModel.setClient(cli2);
		Collection<Client> tab = metier.getClientParMC("");
		clientModel.setTabClient(tab);
		model.addAttribute("AttributUpdateClient", clientModel);
		return "redirect:client";
	}

	/* methode pour afficher la liste des comptes d un client
	 * Entree : ClientModel, Model, String
	 * Sortie : String
	 */
	@RequestMapping(value = "/comptesClient")
	public String getComptes(ClientModel clientModel, Model model, 
			@RequestParam("nomClient") String nomClient) {
		Collection<Client> tab = metier.getClientParMC("");
		Iterator<Client> it = tab.iterator();
		Collection<Compte> tabCompte;
		while(it.hasNext()){
			Client c = it.next();
			if (c.getNomClient().equals(nomClient)) {
				tabCompte = metier.getComptes(c.getIdClient());
				clientModel.setTabCompte(tabCompte);
			}
		}
		model.addAttribute("AttributGetComptes", clientModel);
		return "client";
	}

	/* methode pour recuperer la liste des clients en fonction d un mot cle
	 * Entree : ClientModel, Model, String
	 * Sortie : String
	 */
	@RequestMapping(value = "/motcleClient")
	public String getClientParMC(ClientModel clientModel, Model model, 
			@RequestParam("motCle") String motCle) {
		Collection<Client> tab = metier.getClientParMC(motCle);
		clientModel.setTabClientTemp(tab);
		model.addAttribute("AttributGetClientParMC", clientModel);
		return "client";
	}

}
