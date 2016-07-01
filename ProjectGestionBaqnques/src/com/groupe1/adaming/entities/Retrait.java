package com.groupe1.adaming.entities;

import java.util.Date;

import javax.persistence.Entity;

/*
 * Nom : Retrait
 * Package : com.groupe1.adaming.entities
 * Description : classe étends Operation
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

@Entity
public class Retrait extends Operation{

	/*Constructeurs*/
	
	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

}
