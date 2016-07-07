package com.groupe1.adaming.model;
/*Class: BanqueModel
 * Classe qui stocke les donnees de banque.jsp
 * Package: com.groupe1.adaming.model
 * Author: Philippe
 * Version: 1.0.0
 * Date: 07/07/16
 */
import com.groupe1.adaming.entities.Banque;
import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;

import java.util.Collection;

public class BanqueModel {
	
	/* attributs */
	private Long idBanqueChercher;
	private Employe employe;
	private String motCle;
	private Collection<Banque> tabBanque;
	private Collection<Banque> tabBanqueChoisie;
	private Banque banque;
	private Long idBanque;
	private Collection<Compte> tabCompte;
	private String nomAgence;
	private String adresse;
	private String codePostal;
	private Collection<Client> tabClient;
	private Collection<Employe> tabEmploye;
	private Compte compte;
	
	/* accesseurs */
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public Collection<Banque> getTabBanque() {
		return tabBanque;
	}
	public void setTabBanque(Collection<Banque> tabBanque) {
		this.tabBanque = tabBanque;
	}
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	public Long getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}
	public Collection<Compte> getTabCompte() {
		return tabCompte;
	}
	public void setTabCompte(Collection<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}
	public String getNomAgence() {
		return nomAgence;
	}
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Collection<Client> getTabClient() {
		return tabClient;
	}
	public void setTabClient(Collection<Client> tabClient) {
		this.tabClient = tabClient;
	}
	public Collection<Employe> getTabEmploye() {
		return tabEmploye;
	}
	public void setTabEmploye(Collection<Employe> tabEmploye) {
		this.tabEmploye = tabEmploye;
	}
	public Long getIdBanqueChercher() {
		return idBanqueChercher;
	}
	public void setIdBanqueChercher(Long idBanqueChercher) {
		this.idBanqueChercher = idBanqueChercher;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Collection<Banque> getTabBanqueChoisie() {
		return tabBanqueChoisie;
	}
	public void setTabBanqueChoisie(Collection<Banque> tabBanqueChoisie) {
		this.tabBanqueChoisie = tabBanqueChoisie;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
