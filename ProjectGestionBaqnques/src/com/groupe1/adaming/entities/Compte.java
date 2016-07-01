package com.groupe1.adaming.entities;
/*
 * Classe: Compte
 * Package: com.groupe1.adaming.entities
 * Description: Classe abstraite
 * Auteur: Romain Ganet
 * Version: 1.0.0
 * Date: 30/06/2016
 * 
 */

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeCompte", discriminatorType=DiscriminatorType.STRING)
@Entity
public abstract class Compte {
	
	//Attributs//
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		protected Long idCompte;
		protected double solde;
		@Temporal(TemporalType.DATE)
		protected Date dateDeCreation;
		
		@ManyToOne
		@JoinColumn (name = "idCompte")
		protected Client client;
		
		@ManyToOne
		@JoinColumn (name = "idEmploye")
		protected Employe employe;
		
		@OneToMany (mappedBy="compte", cascade=CascadeType.ALL)
		protected Collection operation;
		
		@ManyToMany
		protected Collection tabBanque;
		
		
		
		//Constructeurs//
		public Compte(double solde, Date dateDeCreation) {
			super();
			this.solde = solde;
			this.dateDeCreation = dateDeCreation;
		}


		public Compte() {
			super();
			// TODO Auto-generated constructor stub
		}


		//Getters And Setters//
		
		public Long getIdCompte() {
			return idCompte;
		}


		public void setIdCompte(Long idCompte) {
			this.idCompte = idCompte;
		}


		public double getSolde() {
			return solde;
		}


		public void setSolde(double solde) {
			this.solde = solde;
		}


		public Date getDateDeCreation() {
			return dateDeCreation;
		}


		public void setDateDeCreation(Date dateDeCreation) {
			this.dateDeCreation = dateDeCreation;
		}


		public Client getClient() {
			return client;
		}


		public void setClient(Client client) {
			this.client = client;
		}


		public Employe getEmploye() {
			return employe;
		}


		public void setEmploye(Employe employe) {
			this.employe = employe;
		}


		public Collection getOperation() {
			return operation;
		}


		public void setOperation(Collection operation) {
			this.operation = operation;
		}


		public Collection getTabBanque() {
			return tabBanque;
		}


		public void setTabBanque(Collection tabBanque) {
			this.tabBanque = tabBanque;
		}
		
		
		
		
		
		
		
}
