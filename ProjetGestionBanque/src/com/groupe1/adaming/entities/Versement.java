package com.groupe1.adaming.entities;

import java.util.Date;

import javax.persistence.Entity;

/*
 * Classe : Versement
 * Type : classe fille, étends Operation
 * Package : com.myapp.entities
 * Auteur : Gwladys Ledocq
 * Version : 1.0.0
 * Date : 30/06/2016
 */

@Entity
public class Versement extends Operation{

	/*Constructeurs*/
	
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}
	
	/*Redefinition toString*/

	@Override
	public String toString() {
		return "Versement [idOperation=" + idOperation + ", dateOperation="
				+ dateOperation + ", montant=" + montant + "]";
	}

}
