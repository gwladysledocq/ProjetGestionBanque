package com.groupe1.adaming.entities;
/*Class: Banque
 * Classe abstraite qui modelise une banque
 * Package: com.myapp.entities
 * Author: Philippe
 * Version: 1.0.0
 * Date: 30/06/16
 */

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorColumn;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Banque",discriminatorType=DiscriminatorType.STRING)

public abstract class Banque {
	/* attributs */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long idBanque;
	protected String nomAgence;
	protected String adresse;
	protected String codePostal;
	
	/* associations */
	@ManyToMany(mappedBy="tabBanque", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Compte> tabCompte;
	
	/* constructeur sans parametre*/
	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* constructeur avec parametres */
	public Banque(String nomAgence, String adresse, String codePostal) {
		super();
		this.nomAgence = nomAgence;
		this.adresse = adresse;
		this.codePostal = codePostal;
	}

	/* accesseurs */
	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
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

	public Collection<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(Collection<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}

	/* redefinition de toString */
	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", nomAgence=" + nomAgence + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", tabCompte=" + tabCompte + "]";
	}
	
}
