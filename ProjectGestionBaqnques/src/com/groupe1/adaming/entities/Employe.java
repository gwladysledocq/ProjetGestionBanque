package com.groupe1.adaming.entities;
/*
 * Classe: Employe
 * Package: com.groupe1.adaming.entities
 * Description:
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 30/06/2016
 * 
 */




import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Employe {
	
	//Attributs//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmploye;
	private String nomEmploye;
	
	@OneToMany (mappedBy = "employe", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Operation> operation;
	
	@ManyToMany
	@JoinTable (name = "tabEmploye")
	private Collection<Groupe> tabGroupe;

	
	//Constructeurs//
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}


	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	//Getters And Setters//
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


	public Collection<Operation> getOperation() {
		return operation;
	}


	public void setOperation(Collection<Operation> operation) {
		this.operation = operation;
	}


	public Collection<Groupe> getTabGroupe() {
		return tabGroupe;
	}


	public void setTabGroupe(Collection<Groupe> tabGroupe) {
		this.tabGroupe = tabGroupe;
	}

	//Redefinition toString//
	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye
				+ ", operation=" + operation + ", tabGroupe=" + tabGroupe + "]";
	}


	
	
	
	
	
	
	

}
