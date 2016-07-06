package com.groupe1.adaming.model;

import java.util.Collection;
import java.util.Date;

import com.groupe1.adaming.entities.Compte;

public class CompteModel {
	
	private Collection<Compte> comptes;
	private Compte compte;
	private Long idEmploye;
	private Long idCompte;
	private double solde;
	private String dateDeCreation;
	private String nomEmploye;
	private double decouvert;
	private Long idClient;
	private Long idBanque;
	private double tauxInteret;
	private Long idCompte2;
	private Compte compte2;
	private Long idCompte3;
	private Compte compte3;
	private Long idCompte4;
	private Compte compte4;
	
	

	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

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

	

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public Long getIdCompte2() {
		return idCompte2;
	}

	public void setIdCompte2(Long idCompte2) {
		this.idCompte2 = idCompte2;
	}

	public Compte getCompte2() {
		return compte2;
	}

	public void setCompte2(Compte compte2) {
		this.compte2 = compte2;
	}

	public Long getIdCompte3() {
		return idCompte3;
	}

	public void setIdCompte3(Long idCompte3) {
		this.idCompte3 = idCompte3;
	}

	public Compte getCompte3() {
		return compte3;
	}

	public void setCompte3(Compte compte3) {
		this.compte3 = compte3;
	}

	public Long getIdCompte4() {
		return idCompte4;
	}

	public void setIdCompte4(Long idCompte4) {
		this.idCompte4 = idCompte4;
	}

	public Compte getCompte4() {
		return compte4;
	}

	public void setCompte4(Compte compte4) {
		this.compte4 = compte4;
	}
	
	

}
