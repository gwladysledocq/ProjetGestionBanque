package com.groupe1.adaming.entities;
/*
 * Classe: CompteCourant
 * Package: com.groupe1.adaming.entities
 * Description: Classe fille de la classe Compte
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 30/06/2016
 * 
 */

import java.util.Date;

import javax.persistence.Entity;
@Entity
public class CompteCourant extends Compte {
	
	
	protected double decouvert;
	
	
	//Constructeurs//
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(double solde, Date dateDeCreation) {
		super(solde, dateDeCreation);
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(double solde, Date dateDeCreation, double decouvert) {
		super(solde, dateDeCreation);
		this.decouvert = decouvert;
	}
	
	//Getters And Setters//
	
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}
