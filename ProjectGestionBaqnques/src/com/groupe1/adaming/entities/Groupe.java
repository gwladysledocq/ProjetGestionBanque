package com.groupe1.adaming.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*
 * Nom : Groupe
 * Package : com.groupe1.adaming.entities
 * Description : classe
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

@Entity
public class Groupe {

	/*Attributs*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	
	@ManyToMany(mappedBy="tabGroupe", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Employe> tabEmploye;

	/*Constructeurs*/
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

	/*Getters and setters*/
	
	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Collection<Employe> getTabEmploye() {
		return tabEmploye;
	}

	public void setTabEmploye(Collection<Employe> tabEmploye) {
		this.tabEmploye = tabEmploye;
	}

	/*Redefinition toString*/
	
	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", nomGroupe=" + nomGroupe
				+ ", tabEmploye=" + tabEmploye + "]";
	}

	
}
