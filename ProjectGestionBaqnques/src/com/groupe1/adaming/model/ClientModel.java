package com.groupe1.adaming.model;
/*Class: ClientModel
 * Classe qui stocke les donnees de client.jsp
 * Package: com.groupe1.adaming.model
 * Author: Philippe
 * Version: 1.0.0
 * Date: 07/07/16
 */
import java.util.Collection;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;

public class ClientModel {
	
	/* attributs */
	private Collection<Client> tabClient;
	private String nomClient;
	private String prenomClient;
	private String adrClient;
	private Collection<Compte> tabCompte;
	private Collection<Client> tabClientTemp;
	private Client client;
	private String nomClientChoisi;
	private String nomClientUpdate;
	private String prenomClientUpdate;
	private String adrClientUpdate;

	/* accesseurs */
	public Collection<Client> getTabClient() {
		return tabClient;
	}

	public void setTabClient(Collection<Client> tabClient) {
		this.tabClient = tabClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdrClient() {
		return adrClient;
	}

	public void setAdrClient(String adrClient) {
		this.adrClient = adrClient;
	}

	public Collection<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(Collection<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}

	public Collection<Client> getTabClientTemp() {
		return tabClientTemp;
	}

	public void setTabClientTemp(Collection<Client> tabClientTemp) {
		this.tabClientTemp = tabClientTemp;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public String getNomClientUpdate() {
		return nomClientUpdate;
	}

	public void setNomClientUpdate(String nomClientUpdate) {
		this.nomClientUpdate = nomClientUpdate;
	}

	public String getPrenomClientUpdate() {
		return prenomClientUpdate;
	}

	public void setPrenomClientUpdate(String prenomClientUpdate) {
		this.prenomClientUpdate = prenomClientUpdate;
	}

	public String getAdrClientUpdate() {
		return adrClientUpdate;
	}

	public void setAdrClientUpdate(String adrClientUpdate) {
		this.adrClientUpdate = adrClientUpdate;
	}

	public String getNomClientChoisi() {
		return nomClientChoisi;
	}

	public void setNomClientChoisi(String nomClientChoisi) {
		this.nomClientChoisi = nomClientChoisi;
	}

}
