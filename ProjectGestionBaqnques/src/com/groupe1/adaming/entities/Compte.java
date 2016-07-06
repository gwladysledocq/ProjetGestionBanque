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

import org.springframework.format.annotation.DateTimeFormat;

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
		@JoinColumn (name = "IDC")
		protected Client client;
		
		@ManyToOne
		@JoinColumn (name = "IDE")
		protected Employe employe;
		
		@OneToMany (mappedBy="compte", cascade=CascadeType.ALL)
		protected Collection<Operation> operation;
		
		@ManyToOne
		@JoinColumn (name = "idBanque")
		protected Banque banque;
		
		protected double decouvert;
		
		//Constructeurs//
		

		public Compte() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Compte(double solde, Date dateDeCreation, double decouvert) {
			super();
			this.solde = solde;
			this.dateDeCreation = dateDeCreation;
			this.decouvert = decouvert;
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


		public Collection<Operation> getOperation() {
			return operation;
		}


		public void setOperation(Collection<Operation> operation) {
			this.operation = operation;
		}


		
		public Banque getBanque() {
			return banque;
		}


		public void setBanque(Banque banque) {
			this.banque = banque;
		}


		public double getDecouvert() {
			return decouvert;
		}


		public void setDecouvert(double decouvert) {
			this.decouvert = decouvert;
		}


		



		//Redefinition toString//


		@Override
		public String toString() {
			return "Compte [idCompte=" + idCompte + ", solde=" + solde
					+ ", dateDeCreation=" + dateDeCreation + ", decouvert="
					+ decouvert + "]";
		}


		
		
}
