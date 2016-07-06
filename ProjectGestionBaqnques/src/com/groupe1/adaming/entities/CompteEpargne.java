package com.groupe1.adaming.entities;
/*
 * Classe: CompteEpargne
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
public class CompteEpargne extends Compte{
	
	protected double tauxInteret;

	
	

	//Constructeurs//
	
	public CompteEpargne(double tauxInteret) {
		super();
		this.tauxInteret = tauxInteret;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompteEpargne(double solde, Date dateDeCreation, double decouvert, double tauxInteret) {
		super(solde, dateDeCreation, decouvert);
		// TODO Auto-generated constructor stub
	}



	//Getters And Setters//
	
	

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	
	
	

}
