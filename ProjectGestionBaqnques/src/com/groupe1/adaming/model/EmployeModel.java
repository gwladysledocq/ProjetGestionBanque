package com.groupe1.adaming.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;



public class EmployeModel {
	
	private Collection<Employe> tabEmploye;
	private Collection<Compte> tabCompte;
	private Long idEmploye;
	private Long idCompte;
	private double solde;
	private Date dateDeCreation;
	private String nomEmploye;
	private boolean affichageEmployes = false;

	
	
	

	


	

	public Collection<Employe> getTabEmploye() {
		return tabEmploye;
	}

	public void setTabEmploye(Collection<Employe> tabEmploye) {
		this.tabEmploye = tabEmploye;
	}

	public Collection<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(Collection<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public boolean isAffichageEmployes() {
		return affichageEmployes;
	}

	public void setAffichageEmployes(boolean affichageEmployes) {
		this.affichageEmployes = affichageEmployes;
	}

	
	
	
	

}
