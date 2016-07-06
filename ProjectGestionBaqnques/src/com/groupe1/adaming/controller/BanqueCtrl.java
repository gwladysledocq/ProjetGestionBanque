package com.groupe1.adaming.controller;
/*Class: BanqueCtrl
 * Controlleur pour la page banque.jsp
 * Package: com.groupe1.adaming.controller
 * Author: Philippe
 * Version: 1.0.0
 * Date: 06/07/16
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupe1.adaming.metierBanque.IBanqueMetier;
import com.groupe1.adaming.metierClient.IClientMetier;
import com.groupe1.adaming.metierCompte.ICompteMetier;
import com.groupe1.adaming.model.BanqueModel;
import com.groupe1.adaming.entities.Banque;
import com.groupe1.adaming.entities.BanqueBnp;
import com.groupe1.adaming.entities.BanqueCic;
import com.groupe1.adaming.entities.BanqueLcl;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.exception.ExceptionControllerBanqueDejaAjoutee;
import com.groupe1.adaming.exception.ExceptionControllerBanquePasDeBanque;

@Controller
public class BanqueCtrl {

	/* attributs */
	@Autowired
	private IBanqueMetier metier;
	
	@Autowired
	private ICompteMetier metierCompte;

	/* methode pour afficher la page d accueil de banque.jsp
	 * Entree : BanqueModel, Model
	 * Sortie : String
	 */
	@RequestMapping(value = "/banque")
	public String indexBanque(BanqueModel banqueModel, Model model) {
		Collection<Banque> tab = metier.getBanques();
		banqueModel.setTabBanque(tab);
/*		Collection<Compte> tabCompte = banqueModel.getTabCompte();
		Iterator<Banque> it = tab.iterator();
		while(it.hasNext()){
			tabCompte.addAll(it.next().getTabCompte());
		}
		banqueModel.setTabCompte(tabCompte);*/
		model.addAttribute("AttributIndexBanque", banqueModel);
		return "banque";
	}

	/* methode pour afficher les banques
	 * Entree : BanqueModel, Model
	 * Sortie : String
	 */
	@RequestMapping(value = "/afficherBanque")
	public String getBanque(BanqueModel banqueModel, Model model) {
		Collection<Banque> tab = metier.getBanques();
		banqueModel.setTabBanque(tab);
		model.addAttribute("AttributIndexBanque", banqueModel);
		return "banque";
	}

	/* methode pour ajouter une banque
	 * Entree : BanqueModel, Model, String, String, String, String
	 * Sortie : String
	 */
	@RequestMapping(value = "/ajouterBanque", method = RequestMethod.POST)
	public String ajouterBanque(BanqueModel banqueModel, Model model, @RequestParam("nomAgence") String nomAgence,
			@RequestParam("adrAgence") String adrAgence, @RequestParam("cpAgence") String cpAgence,
			@RequestParam("typeBanque") String typeBanque) {

		Banque b = null;

		if (typeBanque.equals("cic")) {
			b = new BanqueCic(nomAgence, adrAgence, cpAgence);
			System.out.println("1");
		}
		if (typeBanque.equals("bnp")) {
			b = new BanqueBnp(nomAgence, adrAgence, cpAgence);
			System.out.println("2");
		}
		if (typeBanque.equals("lcl")) {
			b = new BanqueLcl(nomAgence, adrAgence, cpAgence);
			System.out.println("3");
		}

		metier.addBanque(b);
		Collection<Banque> tabBanque = metier.getBanques();
		banqueModel.setTabBanque(tabBanque);
		model.addAttribute("AttributAddBanque", banqueModel);
		
		return "banque";

	}

	/* methode pour afficher les informations d une banque
	 * Entree : BanqueModel, Model, String
	 * Sortie : String
	 */
	/*@RequestMapping(value = "/afficherInfosBanque", method = RequestMethod.POST)
	public String afficherInfosBanque(BanqueModel banqueModel, Model model,
			@RequestParam("nomAgence") String nomAgence) {
		System.out.println("afficherInfosBanque");
		Collection<Banque> tab = metier.getBanques();
		banqueModel.setTabBanque(tab);
		Banque b = null;
		
		Compte cli = null;
		System.out.println("------------A-------------tab"+tab.size());
		for (Banque banq : tab) {
			if (banq.getNomAgence().equals(nomAgence)) {
				b = banq;
				banqueModel.setBanque(b);
				
				Collection<Compte> tabCompteOfBanque = b.getTabCompte();
				banqueModel.setTabCompte(tabCompteOfBanque); 
				Iterator<Compte> iterator = tabCompteOfBanque.iterator();

				
				Collection<Client> tabClient =  banqueModel.getTabClient();
				Collection<Employe> tabEmploye = banqueModel.getTabEmploye();
				System.out.println("-----B-------tabCompte "+tabCompteOfBanque.size());
				//ça marche jusque là
				while (iterator.hasNext()) {
					
					cli = (Compte) iterator.next();
					System.out.println("----------------it"+cli.getSolde());
					System.out.println("----------------iterator"+cli.getEmploye());
					//tabClient.add(cli.getClient());
					//tabEmploye.add(cli.getEmploye());
				}

					
				
				//System.out.println("----------tabClient------"+tabClient.size());
				//banqueModel.setTabClient(tabClient);
				//banqueModel.setTabEmploye(tabEmploye);
			}
			
			model.addAttribute("AttributAfficherInfosBanque", banqueModel);

		}
		return "banque";

	}*/
	@RequestMapping(value = "/afficherInfosBanque", method = RequestMethod.GET)
		
		public String afficherInfosBanque(BanqueModel banqueModel, Model model){
		    
		   Collection<Banque> tabB = metier.getBanquesById(banqueModel.getIdBanqueChercher());
		   banqueModel.setTabBanqueChoisie(tabB);
		   
		   model.addAttribute("Att", banqueModel);
		   
		    return "banque";
		
	     }
	
}
