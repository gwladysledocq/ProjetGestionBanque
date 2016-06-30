package com.groupe1.adaming.entities;

import java.util.Date;

import javax.persistence.Entity;

/*
 * Classe : Retrait
 * Type : classe fille, étends Operation
 * Package : com.myapp.entities
 * Auteur : Gwladys Ledocq
 * Version : 1.0.0
 * Date : 30/06/2016
 */

@Entity
public class Retrait extends Operation{

	/*Construteurs*/
	
	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	/*Redefiniton toString*/
	
	@Override
	public String toString() {
		return "Retrait [idOperation=" + idOperation + ", dateOperation="
				+ dateOperation + ", montant=" + montant + "]";
	}

}
