package com.groupe1.adaming.model;

import java.util.Collection;

import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Groupe;
import com.groupe1.adaming.exception.NomVideGroupeException;

public class GroupeModel {

	/*Attributes*/
	
	private Collection<Groupe> tabGroupe;
	private Long idGroupe;
	private String nomGroupe;
	private Collection<Employe> tabEmploye;
	private Long idEmploye;
	private String nomEmploye;
	private Collection<Employe> tousEmploye;
	private NomVideGroupeException nomVideException;
	private boolean affichageGroupes = false;

	/*Getters and setters*/
	
	public Collection<Groupe> getTabGroupe() {
		return tabGroupe;
	}

	public void setTabGroupe(Collection<Groupe> tabGroupe) {
		this.tabGroupe = tabGroupe;
	}

	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public Collection<Employe> getTabEmploye() {
		return tabEmploye;
	}

	public void setTabEmploye(Collection<Employe> tabEmploye) {
		this.tabEmploye = tabEmploye;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Collection<Employe> getTousEmploye() {
		return tousEmploye;
	}

	public void setTousEmploye(Collection<Employe> tousEmploye) {
		this.tousEmploye = tousEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public NomVideGroupeException getNomVideException() {
		return nomVideException;
	}

	public void setNomVideException(NomVideGroupeException nomVideException) {
		this.nomVideException = nomVideException;
	}

	public boolean isAffichageGroupes() {
		return affichageGroupes;
	}

	public void setAffichageGroupes(boolean affichageGroupes) {
		this.affichageGroupes = affichageGroupes;
	}
	
	
	
}
