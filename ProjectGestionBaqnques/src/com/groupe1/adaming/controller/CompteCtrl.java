package com.groupe1.adaming.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.CompteCourant;
import com.groupe1.adaming.entities.CompteEpargne;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.metierCompte.ICompteMetier;
import com.groupe1.adaming.model.CompteModel;
import com.groupe1.adaming.model.EmployeModel;



@Controller
public class CompteCtrl {
	
	@Autowired
    private ICompteMetier metier;
	
	@RequestMapping(value="/indexCompte")
	public String index(CompteModel compteModel,Model model){
		return "compte";
	}
	
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@RequestMapping(value="/addCompteCourant")
	public String addCompteCourant(CompteModel compteModel, Model model, 
         @RequestParam ("solde") double solde,
         @RequestParam ("date") String dateDeCreation,
         @RequestParam ("decouvert") double decouvert,
	     @RequestParam ("idClient") Long idClient,
	     @RequestParam ("idEmploye") Long idEmploye,
	     @RequestParam ("idBanque") Long idBanque) throws ParseException{
		compteModel.setSolde(solde);
		compteModel.setDateDeCreation(dateDeCreation);
		compteModel.setDecouvert(decouvert);
		compteModel.setIdClient(idClient);
		compteModel.setIdEmploye(idEmploye);
		compteModel.setIdBanque(idBanque);
		Date d1 = sf.parse(dateDeCreation);
		Compte c = new CompteCourant(solde, d1, decouvert);
		metier.addCompte(c, idClient, idEmploye, idBanque);	
		compteModel.setCompte(c);
		model.addAttribute("AttrCompte",compteModel);
		return "compte";	
	}
	
	@RequestMapping(value="/addCompteEpargne")
	public String addCompteEpargne(CompteModel compteModel, Model model,
			 @RequestParam ("solde") double solde,
	         @RequestParam ("date") String dateDeCreation,
	         @RequestParam ("decouvert") double decouvert,
	         @RequestParam ("taux") double tauxInteret,
	         @RequestParam ("idClient") Long idClient,
		     @RequestParam ("idEmploye") Long idEmploye,
		     @RequestParam ("idBanque") Long idBanque) throws ParseException{
		compteModel.setSolde(solde);
		compteModel.setDateDeCreation(dateDeCreation);
		compteModel.setDecouvert(decouvert);
		compteModel.setTauxInteret(tauxInteret);
		Date d2 = sf.parse(dateDeCreation);
		Compte c = new CompteEpargne(solde, d2, decouvert, tauxInteret);
		metier.addCompte(c, idClient, idEmploye, idBanque);		
		compteModel.setCompte(c);
		model.addAttribute("AttrCompte",compteModel);
		return "compte";	
	}

	
	
	@RequestMapping(value="/getCompte")
	public String getCompte(CompteModel compteModel, Model model){
		Compte c = metier.getCompte(compteModel.getIdCompte2());
	    compteModel.setCompte2(c);
		model.addAttribute("AttrCompte",compteModel);
		return "compte";
	}
	
	@RequestMapping(value="/deleteCompte")
	public String deleteCompte(CompteModel compteModel, Model model){
		Compte c = metier.deleteCompte(compteModel.getIdCompte());
		compteModel.setCompte(c);
		model.addAttribute("AttrCompte",compteModel);
		return "compte";
	}
	
	@RequestMapping(value="/updateCompte")
	public String updateCompte(CompteModel compteModel, Model model,
			 @RequestParam ("idCompte3") Long idCompte3,
			 @RequestParam ("solde") double solde,
	         @RequestParam ("date") String dateDeCreation,
	         @RequestParam ("decouvert") double decouvert) throws ParseException{
		Compte c = metier.getCompte(idCompte3);
		
		compteModel.setSolde(solde);
		compteModel.setDateDeCreation(dateDeCreation);
		compteModel.setDecouvert(decouvert);
		Date d3 = sf.parse(dateDeCreation);
		c.setSolde(solde);
		c.setDateDeCreation(d3);
		c.setDecouvert(decouvert);
		compteModel.setCompte3(c);
		metier.updateCompte(c);
		model.addAttribute("AttrCompte",compteModel);
		return "compte";
	}
	
	
	
	
}
