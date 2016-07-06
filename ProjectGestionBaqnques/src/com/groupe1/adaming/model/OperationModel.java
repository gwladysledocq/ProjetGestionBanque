package com.groupe1.adaming.model;

import java.util.Collection;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.entities.Operation;
import com.groupe1.adaming.exception.ExceptionSoldeInsuffisant;

public class OperationModel {

	private Collection< Client> tousClient;
	private Long idClient;
	private Collection<Compte> tabCompte;
	private Long idCompte;
	private Collection<Operation> tabOperation;
	private String type;
	private Long idEmploye;
	private double montant;
	private Collection<Employe> tousEmploye;
	private double soldeBefore;
	private double soldeAfter;
	private ExceptionSoldeInsuffisant exceptionSoldeInsuffisant;
	private Long idCompteCredite;
	private double soldeBeforeCredite;
	private double soldeAfterCredite;
	private Long idCompteDebite;
	private double soldeBeforeDebite;
	private double soldeAfterDebite;
	
	
	public Collection< Client> getTousClient() {
		return tousClient;
	}

	public void setTousClient(Collection< Client> tousClient) {
		this.tousClient = tousClient;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Collection<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(Collection<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public Collection<Operation> getTabOperation() {
		return tabOperation;
	}

	public void setTabOperation(Collection<Operation> tabOperation) {
		this.tabOperation = tabOperation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Collection<Employe> getTousEmploye() {
		return tousEmploye;
	}

	public void setTousEmploye(Collection<Employe> tousEmploye) {
		this.tousEmploye = tousEmploye;
	}

	public double getSoldeBefore() {
		return soldeBefore;
	}

	public void setSoldeBefore(double soldeBefore) {
		this.soldeBefore = soldeBefore;
	}

	public double getSoldeAfter() {
		return soldeAfter;
	}

	public void setSoldeAfter(double soldeAfter) {
		this.soldeAfter = soldeAfter;
	}

	public ExceptionSoldeInsuffisant getExceptionSoldeInsuffisant() {
		return exceptionSoldeInsuffisant;
	}

	public void setExceptionSoldeInsuffisant(
			ExceptionSoldeInsuffisant exceptionSoldeInsuffisant) {
		this.exceptionSoldeInsuffisant = exceptionSoldeInsuffisant;
	}

	public Long getIdCompteCredite() {
		return idCompteCredite;
	}

	public void setIdCompteCredite(Long idCompteCredite) {
		this.idCompteCredite = idCompteCredite;
	}

	public double getSoldeBeforeCredite() {
		return soldeBeforeCredite;
	}

	public void setSoldeBeforeCredite(double soldeBeforeCredite) {
		this.soldeBeforeCredite = soldeBeforeCredite;
	}

	public double getSoldeAfterCredite() {
		return soldeAfterCredite;
	}

	public void setSoldeAfterCredite(double soldeAfterCredite) {
		this.soldeAfterCredite = soldeAfterCredite;
	}

	public Long getIdCompteDebite() {
		return idCompteDebite;
	}

	public void setIdCompteDebite(Long idCompteDebite) {
		this.idCompteDebite = idCompteDebite;
	}

	public double getSoldeBeforeDebite() {
		return soldeBeforeDebite;
	}

	public void setSoldeBeforeDebite(double soldeBeforeDebite) {
		this.soldeBeforeDebite = soldeBeforeDebite;
	}

	public double getSoldeAfterDebite() {
		return soldeAfterDebite;
	}

	public void setSoldeAfterDebite(double soldeAfterDebite) {
		this.soldeAfterDebite = soldeAfterDebite;
	}

	
	
	
}
