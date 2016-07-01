package com.groupe1.adaming.entities;
/*Class: BanqueCic
 * Classe heritee de Banque qui modelise la banque CIC
 * Package: com.myapp.entities
 * Author: Philippe
 * Version: 1.0.0
 * Date: 30/06/16
 */
import javax.persistence.Entity;

@Entity
public class BanqueCic extends Banque{

	/* constructeur sans parametre */
	public BanqueCic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* constructeur avec parametres */
	public BanqueCic(String nomAgence, String adresse, String codePostal) {
		super(nomAgence, adresse, codePostal);
		// TODO Auto-generated constructor stub
	}

}
