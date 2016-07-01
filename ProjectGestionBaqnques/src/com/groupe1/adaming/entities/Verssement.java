package com.groupe1.adaming.entities;

import java.util.Date;

import javax.persistence.Entity;
/*
 * Nom : Verssement
 * Package : com.groupe1.adaming.entities
 * Description : classe étends Operation
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

@Entity
public class Verssement extends Operation{

	/*Constructeurs*/
	
	public Verssement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Verssement(Date dateOperation) {
		super(dateOperation);
		// TODO Auto-generated constructor stub
	}

}
