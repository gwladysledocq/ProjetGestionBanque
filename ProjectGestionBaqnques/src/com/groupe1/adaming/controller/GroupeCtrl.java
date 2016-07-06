package com.groupe1.adaming.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;
import com.groupe1.adaming.exception.NomVideGroupeException;
import com.groupe1.adaming.metierEmploye.IEmployeMetier;
import com.groupe1.adaming.metierGroupe.IGroupeMetier;
import com.groupe1.adaming.model.GroupeModel;

@Controller
public class GroupeCtrl {

	@Autowired
    private IGroupeMetier metier;
	@Autowired
    private IEmployeMetier metierEmp;
	
    private boolean affichage = false;
	
	@RequestMapping(value="/groupe")
	public String indexGroupe(GroupeModel groupeModel, Model model){
		Collection<Groupe> groupes = metier.getGroupes();
		groupeModel.setTabGroupe(groupes);
		Collection<Employe> tousEmploye = metierEmp.getListEmploye();
		groupeModel.setTousEmploye(tousEmploye);
		model.addAttribute("AttrGroupe",groupeModel);
		return "groupe";
	}
	
	@RequestMapping(value="/getGroupes")
	public String getGroupe(GroupeModel groupeModel, Model model){
		Collection<Groupe> groupes = metier.getGroupes();
		groupeModel.setTabGroupe(groupes);
		Collection<Employe> tousEmploye = metierEmp.getListEmploye();
		groupeModel.setTousEmploye(tousEmploye);
		affichage=true;
		groupeModel.setAffichageGroupes(affichage);
		model.addAttribute("AttrGroupe",groupeModel);
		return "groupe";
	}
	
	@RequestMapping(value="/saveGroupe",method=RequestMethod.POST)
	public String saveGroupe(GroupeModel groupeModel, Model model,
		@RequestParam("nomGroupe")   String nomGroupe){
		Collection<Groupe> groupes = metier.getGroupes();
		groupeModel.setTabGroupe(groupes);
		Collection<Employe> tousEmploye = metierEmp.getListEmploye();
		groupeModel.setTousEmploye(tousEmploye);
		affichage=true;
		try {
			if(nomGroupe.equals("")){
				throw new NomVideGroupeException("Le nom est vide !");
			}
			Groupe g = new Groupe(nomGroupe);
			metier.addGroupe(g);
			groupeModel.setAffichageGroupes(affichage);
			model.addAttribute("AttrGroupe",groupeModel);
		} catch (NomVideGroupeException e) {
			groupeModel.setNomVideException(e);
		}
		return "groupe";
	}
	
	@RequestMapping(value="/getEmployesOfGroupe",method=RequestMethod.POST)
	public String addEmployeToGroupe(GroupeModel groupeModel, Model model,
			@RequestParam("idGroupe") String SidGroupe){
		Long idGroupe = Long.parseLong(SidGroupe);
		groupeModel.setIdGroupe(idGroupe);
		Collection<Employe> tabEmploye = metier.getEmployes(idGroupe);
		groupeModel.setTabEmploye(tabEmploye);
		Collection<Groupe> groupes = metier.getGroupes();
		groupeModel.setTabGroupe(groupes);
		for(Groupe g : groupes){
			if(g.getIdGroupe() == idGroupe){
				groupeModel.setNomGroupe(g.getNomGroupe());
			}
		}
		Collection<Employe> tousEmploye = metierEmp.getListEmploye();
		groupeModel.setTousEmploye(tousEmploye);
		groupeModel.setAffichageGroupes(affichage);
		model.addAttribute("AttrGroupe",groupeModel);
		return "groupe";
	}
	
	@RequestMapping(value="/addEmployesToGroupe",method=RequestMethod.POST)
	public String addEmployeToGroupe(GroupeModel groupeModel, Model model,
			@RequestParam("idGroupeAdd") String SidGroupe,
			@RequestParam("idEmployeAdd") String SidEmploye){
		Long idGroupe = Long.parseLong(SidGroupe);
		Long idEmploye = Long.parseLong(SidEmploye);
		groupeModel.setIdGroupe(idGroupe);
		groupeModel.setIdEmploye(idEmploye);
		metier.addEmployeToGroupe(idGroupe, idEmploye);
		Collection<Employe> tousEmploye = metierEmp.getListEmploye();
		groupeModel.setTousEmploye(tousEmploye);
		Collection<Groupe> groupes = metier.getGroupes();
		groupeModel.setTabGroupe(groupes);
		for(Groupe g : groupes){
			if(g.getIdGroupe() == idGroupe){
				groupeModel.setNomGroupe(g.getNomGroupe());
			}
		}
		for(Employe e : tousEmploye){
			if(e.getIdEmploye() == idEmploye){
				groupeModel.setNomEmploye(e.getNomEmploye());
			}
		}
		groupeModel.setAffichageGroupes(affichage);
		model.addAttribute("AttrGroupe",groupeModel);
		return "groupe";
	}
	
}
