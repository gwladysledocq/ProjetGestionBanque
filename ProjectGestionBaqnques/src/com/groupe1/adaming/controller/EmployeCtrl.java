package com.groupe1.adaming.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.metierEmploye.IEmployeMetier;
import com.groupe1.adaming.model.CompteModel;
import com.groupe1.adaming.model.EmployeModel;

@Controller
public class EmployeCtrl {
	

	@Autowired
    private IEmployeMetier metier;
	
	private boolean affichage = false;
	
	
	@RequestMapping(value="/indexEmploye")
	public String index(EmployeModel employeModel, Model model){
		Collection<Employe> employes = metier.getListEmploye();
		employeModel.setTabEmploye(employes);
		model.addAttribute("AttrEmploye",employeModel);
		return "employe";
	}
	
	
	
	@RequestMapping(value="/addEmploye",method=RequestMethod.POST)
	public String addEmploye(EmployeModel employeModel, Model model, @RequestParam("nom")String nomEmploye) {
		Employe e = new Employe(nomEmploye);
		metier.addEmploye(e);
		Collection<Employe> tabEmploye = metier.getListEmploye();
		employeModel.setTabEmploye(tabEmploye);
		model.addAttribute("AttrEmploye",employeModel);
		return "redirect:indexEmploye";	
	}
	
	@RequestMapping(value="/getListEmploye")
	public String getListEmploye(EmployeModel employeModel, Model model){
		Collection <Employe> employe = metier.getListEmploye();
	    employeModel.setTabEmploye(employe);
	    affichage=true;
	    employeModel.setAffichageEmployes(affichage);
		model.addAttribute("AttrEmploye",employeModel);
		return "employe";
	}
	
	
/*	@RequestMapping(value="/getComptesParEmploye",method=RequestMethod.POST)
	public String getComptesParEmploye(EmployeModel employeModel, Model model,@RequestParam("idEmploye") String SidEmploye){
		Long idEmploye = Long.parseLong(SidEmploye);
		employeModel.setIdEmploye(idEmploye);
		Collection<Compte> tabCompte = metier.getComptesParEmploye(idEmploye);
		employeModel.setTabCompte(tabCompte);
		Collection<Employe> tabEmploye = metier.getListEmploye();
		employeModel.setTabEmploye(tabEmploye);
		for(Employe e : tabEmploye){
			if(e.getIdEmploye() == idEmploye){
				employeModel.setNomEmploye(e.getNomEmploye());
			}
		}
		model.addAttribute("AttrEmploye",employeModel);
		return "employe";
	}*/
	
	@RequestMapping(value="/getComptesParEmploye")
	public String getComptesParEmploye(EmployeModel employeModel, Model model){
		List<Compte> tbComptes=null;
		tbComptes=(List<Compte>) metier.getComptesParEmploye(employeModel.getIdEmploye());
		employeModel.setTabCompte(tbComptes);
		model.addAttribute("AttrEmploye",employeModel);
		return "employe";
	}
	
}
	
