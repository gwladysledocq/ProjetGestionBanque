package com.groupe1.adaming.entities;
/*Class: BanqueBnp
 * Classe heritee de Banque qui modelise la banque BNP
 * Package: com.myapp.entities
 * Author: Philippe
 * Version: 1.0.0
 * Date: 30/06/16
 */
import javax.persistence.Entity;

@Entity
public class BanqueBnp extends Banque {

	/* constructeur sans parametre */
	public BanqueBnp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* constructeur avec parametres */
	public BanqueBnp(String nomAgence, String adresse, String codePostal) {
		super(nomAgence, adresse, codePostal);
		// TODO Auto-generated constructor stub
	}

}
