package com.groupe1.adaming.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Classe : Operation
 * Type : classe abstraite
 * Package : com.myapp.entities
 * Auteur : Gwladys Ledocq
 * Version : 1.0.0
 * Date : 30/06/2016
 */

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
public abstract class Operation {

	/*Attributs*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long idOperation;
	@Temporal(TemporalType.DATE)
	protected Date dateOperation;
	protected double montant;
	
	@ManyToMany(mappedBy="tabOperation",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	protected Compte compte;
	
	/*Constructeurs*/
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	
	/*Getters and setters*/
	
	public Long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
