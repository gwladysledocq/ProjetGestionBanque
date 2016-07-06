package com.groupe1.adaming.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Operation;
import com.groupe1.adaming.entities.Retrait;
import com.groupe1.adaming.entities.Verssement;
import com.groupe1.adaming.exception.ExceptionSoldeInsuffisant;
import com.groupe1.adaming.metierClient.IClientMetier;
import com.groupe1.adaming.metierCompte.ICompteMetier;
import com.groupe1.adaming.metierEmploye.IEmployeMetier;
import com.groupe1.adaming.metierOperation.IOperationMetier;
import com.groupe1.adaming.model.OperationModel;

@Controller
public class OperationCtrl {

	@Autowired
    private IOperationMetier metier;
	@Autowired
    private ICompteMetier metierCom;
	@Autowired
    private IClientMetier metierCli;
	@Autowired
    private IEmployeMetier metierEmp;
	
	@RequestMapping(value="/operation")
	public String indexOperation(OperationModel operationModel, Model model){
		Collection<Client> tousClient = metierCli.getClientParMC("");
		operationModel.setTousClient(tousClient);
		List<Compte> tousComptes = new ArrayList<Compte>();
		for(Client c : tousClient){
			for(Compte comp : c.getTabCompte()){
				tousComptes.add(comp);
			}
		}
		operationModel.setTabCompte(tousComptes);
		Collection<Employe> tabEmploye = metierEmp.getListEmploye();
		operationModel.setTousEmploye(tabEmploye);
		model.addAttribute("AttrOperation", operationModel);
		return "operation";
	}
	
	@RequestMapping(value="/getOperationsOfCompteOfClient")
	public String selectCompte(OperationModel operationModel, Model model,
			@RequestParam("idCompte")   Long idCompte){
		Collection<Client> tousClient = metierCli.getClientParMC("");
		operationModel.setTousClient(tousClient);
		List<Compte> tousComptes = new ArrayList<Compte>();
		for(Client c : tousClient){
			for(Compte comp : c.getTabCompte()){
				tousComptes.add(comp);
			}
		}
		operationModel.setTabCompte(tousComptes);
		List<Operation> tabOperation = new ArrayList<Operation>();
		for(Compte comp : tousComptes){
			if(comp.getIdCompte() == idCompte){
				tabOperation = (List<Operation>) comp.getOperation();
			}
		}
		operationModel.setTabOperation(tabOperation);
		model.addAttribute("AttrOperation", operationModel);
		return "operation";
	}
	
	@RequestMapping(value="/addOperationUnCompte")
	public String addOperation(OperationModel operationModel, Model model){
		Collection<Client> tousClient = metierCli.getClientParMC("");
		operationModel.setTousClient(tousClient);
		List<Compte> tousComptes = new ArrayList<Compte>();
		for(Client c : tousClient){
			for(Compte comp : c.getTabCompte()){
				tousComptes.add(comp);
			}
		}
		operationModel.setTabCompte(tousComptes);
		Collection<Employe> tabEmploye = metierEmp.getListEmploye();
		operationModel.setTousEmploye(tabEmploye);
		Compte compte = metierCom.getCompte(operationModel.getIdCompte());
		operationModel.setSoldeBefore(compte.getSolde());
		if(operationModel.getType().equals("retrait")){
			try {
				if(operationModel.getSoldeBefore() - compte.getDecouvert() < operationModel.getMontant()){
					throw new ExceptionSoldeInsuffisant("Le solde est insufisant !");
				}
				Operation o = metier.addOperation(new Retrait(new Date()), operationModel.getIdCompte(), operationModel.getIdEmploye());
				metier.retrait(o.getIdOperation(), operationModel.getMontant());
			} catch (ExceptionSoldeInsuffisant e) {
				operationModel.setExceptionSoldeInsuffisant(e);
			}
		} else if(operationModel.getType().equals("versement")){
			Operation o = metier.addOperation(new Verssement(new Date()), operationModel.getIdCompte(), operationModel.getIdEmploye());
			metier.versement(o.getIdOperation(), operationModel.getMontant());
		}
		compte = metierCom.getCompte(operationModel.getIdCompte());
		operationModel.setSoldeAfter(compte.getSolde());
		model.addAttribute("AttrOperation", operationModel);
		return "redirect:operation";
	}
	
	@RequestMapping(value="/addOperationVirement")
	public String addOperationVirement(OperationModel operationModel, Model model){
		Collection<Client> tousClient = metierCli.getClientParMC("");
		operationModel.setTousClient(tousClient);
		List<Compte> tousComptes = new ArrayList<Compte>();
		for(Client c : tousClient){
			for(Compte comp : c.getTabCompte()){
				tousComptes.add(comp);
			}
		}
		operationModel.setTabCompte(tousComptes);
		Collection<Employe> tabEmploye = metierEmp.getListEmploye();
		operationModel.setTousEmploye(tabEmploye);
		Compte compteDebite = metierCom.getCompte(operationModel.getIdCompteDebite());
		Compte compteCredite = metierCom.getCompte(operationModel.getIdCompteCredite());
		operationModel.setSoldeBeforeDebite(compteDebite.getSolde());
		operationModel.setSoldeBeforeCredite(compteCredite.getSolde());
		try {
			if(operationModel.getSoldeBeforeDebite() - compteDebite.getDecouvert() < operationModel.getMontant()){
				throw new ExceptionSoldeInsuffisant("Le solde est insufisant !");
			}
			Operation o = metier.addOperation(new Retrait(new Date()), operationModel.getIdCompteDebite(), operationModel.getIdEmploye());
			metier.retrait(o.getIdOperation(), operationModel.getMontant());
		} catch (ExceptionSoldeInsuffisant e) {
			operationModel.setExceptionSoldeInsuffisant(e);
		}
		Operation o = metier.addOperation(new Verssement(new Date()), operationModel.getIdCompteCredite(), operationModel.getIdEmploye());
		metier.versement(o.getIdOperation(), operationModel.getMontant());
		compteDebite = metierCom.getCompte(operationModel.getIdCompteDebite());
		compteCredite = metierCom.getCompte(operationModel.getIdCompteCredite());
		operationModel.setSoldeAfterDebite(compteDebite.getSolde());
		operationModel.setSoldeAfterCredite(compteCredite.getSolde());
		model.addAttribute("AttrOperation", operationModel);
		return "operation";
	}
	
}
