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
 * Classe : Groupe
 * Package : com.myapp.entities
 * Auteur : Gwladys Ledocq
 * Version : 1.0.0
 * Date : 30/06/2016
 */

@Entity
public class Groupe {
	
	/*Attributs*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	
	@ManyToMany(mappedBy="tabGroupe",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Employe> tabEmploye;
	
	/*Contructeurs*/
	
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
	
	/*Redefiniton toString()*/
	
	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", nomGroupe=" + nomGroupe
				+ ", tabEmploye=" + tabEmploye + "]";
	}
	
	
	

}
