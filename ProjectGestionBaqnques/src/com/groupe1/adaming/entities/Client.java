package com.groupe1.adaming.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*Class: Client
 * Classe qui modelise un client
 * Package: com.myapp.entities
 * Author: Philippe
 * Version: 1.0.0
 * Date: 30/06/16
 */
@Entity
public class Client {

	/* attributs */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	private String adrClient;

	/* associations */
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Collection<Compte> tabCompte;

	/* constructeur sans parametre */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* constructeur avec parametres */
	public Client(String nomClient, String prenomClient, String adrClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adrClient = adrClient;
	}

	/* accesseurs */
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	/* redefinition de toString */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", adrClient=" + adrClient + ", tabCompte=" + tabCompte + "]";
	}

	
}