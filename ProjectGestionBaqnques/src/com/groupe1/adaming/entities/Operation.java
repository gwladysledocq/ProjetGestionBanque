package com.groupe1.adaming.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Nom : Operation
 * Package : com.groupe1.adaming.entities
 * Description : classe abstraite
 * Auteur : Gwladys Ledocq
 * Date : 30/06/2016
 * Version : 1.0.0
 */

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeOperation", discriminatorType=DiscriminatorType.STRING)
@Entity
public abstract class Operation {

	/*Attributs*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long idOperation;
	@Temporal(TemporalType.DATE)
	protected Date dateOperation;
	
	@ManyToOne
	@JoinColumn(name="idEMploye")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="idCompte")
	private Compte compte;
	
	/*Constructeurs*/
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation) {
		super();
		this.dateOperation = dateOperation;
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
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	/*Redefinition toString*/
	
	@Override
	public String toString() {
		return "Operation [idOperation=" + idOperation + ", dateOperation="
				+ dateOperation + "]";
	}
	
}
