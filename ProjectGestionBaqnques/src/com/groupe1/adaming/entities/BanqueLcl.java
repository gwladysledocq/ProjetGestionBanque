package com.groupe1.adaming.entities;

/*Class: BanqueLcl
 * Classe heritee de Banque qui modelise la banque LCL
 * Package: com.myapp.entities
 * Author: Philippe
 * Version: 1.0.0
 * Date: 30/06/16
 */
import javax.persistence.Entity;

@Entity
public class BanqueLcl extends Banque{

	/* constructeur sans parametre */
	public BanqueLcl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* constructeur avec parametres */
	public BanqueLcl(String nomAgence, String adresse, String codePostal) {
		super(nomAgence, adresse, codePostal);
		// TODO Auto-generated constructor stub
	}

}
